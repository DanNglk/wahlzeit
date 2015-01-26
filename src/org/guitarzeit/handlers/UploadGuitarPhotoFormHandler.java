package org.guitarzeit.handlers;

import org.guitarzeit.model.*;
import org.wahlzeit.handlers.PartUtil;
import org.wahlzeit.handlers.UploadPhotoFormHandler;
import org.wahlzeit.model.*;
import org.wahlzeit.services.SysLog;

import java.io.File;
import java.util.Map;

/**
 * Created by cdan on 04/12/14.
 */
public class UploadGuitarPhotoFormHandler extends UploadPhotoFormHandler {

    /**
     * @pre
     * @post
     * @methodtype command
     * @collaboration Client
     */
    @Override
    protected String doHandlePost(UserSession us, Map args) {
        String tags = us.getAndSaveAsString(args, Photo.TAGS);
        String mapcode = us.getAndSaveAsString(args, Photo.MAPCODE);
        String latitude = us.getAndSaveAsString(args, Photo.LATITUDE);
        String longitude =us.getAndSaveAsString(args, Photo.LONGITUDE);
        String type = us.getAndSaveAsString(args, Guitar.TYPE);
        String shape = us.getAndSaveAsString(args, Guitar.SHAPE);
        String strings = us.getAndSaveAsString(args, Guitar.STRINGS);
        String stringSize = us.getAndSaveAsString(args, Guitar.STRING_SIZE);
        String stringMaterial = us.getAndSaveAsString(args, Guitar.STRING_MATERIAL);
        String manufacturerName = us.getAndSaveAsString(args, Guitar.MANUFACTURER_NAME);
        String manufacturerEstablished = us.getAndSaveAsString(args, Guitar.MANUFACTURER_ESTABLISHED);
        String manufacturerHeadOffice = us.getAndSaveAsString(args, Guitar.MANUFACTURER_HEADOFFICE);
        String frets = us.getAndSaveAsString(args, Guitar.FRETS);
        String features = us.getAndSaveAsString(args, Guitar.FEATURES);
        String pickups = us.getAndSaveAsString(args, Guitar.PICKUPS);

        try {
            GuitarPhotoManager pm = GuitarPhotoManager.getInstance();
            String sourceFileName = us.getAsString(args, "fileName");
            GuitarPhoto photo = pm.createPhoto(new File(sourceFileName));

            User user = (User) us.getClient();
            user.addPhoto(photo);

            photo.setTags(new Tags(tags));
            if (!mapcode.isEmpty())
                photo.setLocation(new MapcodeLocation(mapcode));
            else if (!latitude.isEmpty() && !longitude.isEmpty())
                photo.setLocation(new GPSLocation(Double.parseDouble(latitude), Double.parseDouble(longitude)));

            photo.getGuitar().setGuitarType(GuitarType.valueOf(type));
            photo.getGuitar().setGuitarShape(GuitarShape.valueOf(shape));
            photo.getGuitar().setGuitarStrings(GuitarStringsFactory.getInstance(Integer.valueOf(strings), Integer.valueOf(stringSize),
                    GuitarStringMaterial.valueOf(stringMaterial)));
            photo.getGuitar().setGuitarManufacturer(new GuitarManufacturer(manufacturerName, Integer.valueOf(manufacturerEstablished),
                    manufacturerHeadOffice));
            photo.getGuitar().setFrets(Integer.valueOf(frets));
            photo.getGuitar().setFeatures(features);
            photo.getGuitar().setPickups(Integer.valueOf(pickups));
            pm.savePhoto(photo);

            StringBuffer sb = UserLog.createActionEntry("UploadPhoto");
            UserLog.addCreatedObject(sb, "Photo", photo.getId().asString());
            UserLog.log(sb);

            us.setTwoLineMessage(us.cfg().getPhotoUploadSucceeded(), us.cfg().getKeepGoing());
        } catch (Exception ex) {
            SysLog.logThrowable(ex);
            us.setMessage(us.cfg().getPhotoUploadFailed() + " " + ex.getMessage());
        }
        return PartUtil.UPLOAD_PHOTO_PAGE_NAME;
    }
}
