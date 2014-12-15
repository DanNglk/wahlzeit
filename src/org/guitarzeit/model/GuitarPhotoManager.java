package org.guitarzeit.model;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.model.PhotoUtil;

import java.awt.*;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 04/12/14.
 */
public class GuitarPhotoManager extends PhotoManager {

    private static GuitarPhotoManager guitarPhotoManager = null;


    /**
     * @pre
     * @post Return singleton instance of GuitarPhotoManager
     * @methodtype get
     */
    public static GuitarPhotoManager getInstance() {
        if(guitarPhotoManager == null)
            guitarPhotoManager = new GuitarPhotoManager();
        return guitarPhotoManager;
    }


    @Override
    protected GuitarPhoto createObject(ResultSet rset) throws SQLException {
        return GuitarPhotoFactory.getInstance().createPhoto(rset);
    }


    @Override
    public GuitarPhoto createPhoto(File file) throws Exception {
        PhotoId id = PhotoId.getNextId();
        Image image = PhotoUtil.createImageFiles(file, id);

        GuitarPhoto guitarPhoto = GuitarPhotoFactory.getInstance().createPhoto(id);
        guitarPhoto.setWidthAndHeight(image.getWidth(null), image.getHeight(null));

        Guitar guitar = GuitarManager.getInstance().createGuitar();
        guitarPhoto.setGuitar(guitar);

        addPhoto(guitarPhoto);
        return guitarPhoto;
    }


    @Override
    public void savePhoto(Photo photo) {
        GuitarPhoto guitarPhoto = (GuitarPhoto) photo;
        GuitarManager.getInstance().saveGuitar(guitarPhoto.getGuitar());
        super.savePhoto(photo);
    }


    @Override
    public GuitarPhoto getPhotoFromId(PhotoId id) {
        GuitarPhoto guitarPhoto = (GuitarPhoto) super.getPhotoFromId(id);

        if (guitarPhoto == null) {
            return null;
        }

        GuitarId guitarId = guitarPhoto.getGuitar().getGuitarId();
        Guitar guitar = GuitarManager.getInstance().getGuitarFromId(guitarId);
        guitarPhoto.setGuitar(guitar);
        return guitarPhoto;
    }
}
