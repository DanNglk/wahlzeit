/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.handlers;

import java.util.*;
import java.io.*;

import org.wahlzeit.model.*;
import org.wahlzeit.model.location.GPSLocation;
import org.wahlzeit.model.location.Location;
import org.wahlzeit.model.location.MapcodeLocation;
import org.wahlzeit.model.photos.*;
import org.wahlzeit.services.*;
import org.wahlzeit.utils.*;
import org.wahlzeit.webparts.*;

/**
 * 
 * @author dirkriehle
 *
 */
public class UploadPhotoFormHandler extends AbstractWebFormHandler {
	
	/**
	 *
	 */
	public UploadPhotoFormHandler() {
		initialize(PartUtil.UPLOAD_PHOTO_FORM_FILE, AccessRights.USER);
	}
	
	/**
	 * 
	 */
	protected void doMakeWebPart(UserSession us, WebPart part) {
		Map<String, Object> args = us.getSavedArgs();
		part.addStringFromArgs(args, UserSession.MESSAGE);
		part.maskAndAddStringFromArgs(args, Photo.TAGS);
	}
	
	/**
	 * 
	 */
	protected String doHandlePost(UserSession us, Map args) {
		String tags = us.getAndSaveAsString(args, Photo.TAGS);

        String mapcode = us.getAndSaveAsString(args, Photo.MAPCODE);
        String latitude = us.getAndSaveAsString(args, Photo.LATITUDE);
        String longitude =us.getAndSaveAsString(args, Photo.LONGITUDE);

        String type = us.getAndSaveAsString(args, GuitarPhoto.TYPE);
        String shape = us.getAndSaveAsString(args, GuitarPhoto.SHAPE);
        String strings = us.getAndSaveAsString(args, GuitarPhoto.STRINGS);
        String stringSize = us.getAndSaveAsString(args, GuitarPhoto.STRING_SIZE);
        String stringMaterial = us.getAndSaveAsString(args, GuitarPhoto.STRING_MATERIAL);
        String frets = us.getAndSaveAsString(args, GuitarPhoto.FRETS);
        String features = us.getAndSaveAsString(args, GuitarPhoto.FEATURES);
        String pickups = us.getAndSaveAsString(args, GuitarPhoto.PICKUPS);


		if (!StringUtil.isLegalTagsString(tags)) {
			us.setMessage(us.cfg().getInputIsInvalid());
			return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
		}

        if (!LocationUtil.isLegalMapcode(mapcode)) {
            us.setMessage(us.cfg().getInputIsInvalid());
            return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
        }

        if (!LocationUtil.isLegalGPSCoordinate(latitude) && !LocationUtil.isLegalGPSCoordinate(longitude)) {
            us.setMessage(us.cfg().getInputIsInvalid());
            return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
        }

		try {
			PhotoManager pm = PhotoManager.getInstance();
			String sourceFileName = us.getAsString(args, "fileName");
			File file = new File(sourceFileName);
			GuitarPhoto photo = (GuitarPhoto) pm.createPhoto(file);

			String targetFileName = SysConfig.getBackupDir().asString() + photo.getId().asString();
			createBackup(sourceFileName, targetFileName);
		
			User user = (User) us.getClient();
			user.addPhoto(photo); 
			
			photo.setTags(new Tags(tags));
            if (!mapcode.isEmpty())
                photo.setLocation(new MapcodeLocation(mapcode));
            else if (!latitude.isEmpty() && !longitude.isEmpty())
                photo.setLocation(new GPSLocation(Double.parseDouble(latitude), Double.parseDouble(longitude)));

            photo.setGuitarType(GuitarType.valueOf(type));
            photo.setGuitarShape(GuitarShape.valueOf(shape));
            photo.setGuitarStrings(new GuitarStrings(Integer.valueOf(strings), Integer.valueOf(stringSize),
                    GuitarStringMaterial.valueOf(stringMaterial)));
            photo.setFrets(Integer.valueOf(frets));
            photo.setFeatures(features);
            photo.setPickups(Integer.valueOf(pickups));
			pm.savePhoto(photo);

			StringBuffer sb = UserLog.createActionEntry("UploadPhoto");
			UserLog.addCreatedObject(sb, "Photo", photo.getId().asString());
			UserLog.log(sb);
			
			us.setTwoLineMessage(us.cfg().getPhotoUploadSucceeded(), us.cfg().getKeepGoing());
		} catch (Exception ex) {
			SysLog.logThrowable(ex);
			us.setMessage(us.cfg().getPhotoUploadFailed());
		}
		return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
	}
	
	/**
	 * 
	 */
	protected void createBackup(String sourceName, String targetName) {
		try {
			File sourceFile = new File(sourceName);
			InputStream inputStream = new FileInputStream(sourceFile);
			File targetFile = new File(targetName);
			OutputStream outputStream = new FileOutputStream(targetFile);
			// @FIXME IO.copy(inputStream, outputStream);
		} catch (Exception ex) {
			SysLog.logSysInfo("could not create backup file of photo");
			SysLog.logThrowable(ex);			
		}
	}
}
