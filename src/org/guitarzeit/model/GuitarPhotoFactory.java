package org.guitarzeit.model;

import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 04/12/14.
 */
public class GuitarPhotoFactory extends PhotoFactory {

    public static GuitarPhotoFactory guitarPhotoFactory = null;


    public static synchronized GuitarPhotoFactory getInstance() {
        if (guitarPhotoFactory == null) {
            guitarPhotoFactory = new GuitarPhotoFactory();
        }
        return guitarPhotoFactory;
    }


    @Override
    public GuitarPhoto createPhoto(PhotoId id) {
        return new GuitarPhoto(id);
    }


    @Override
    public GuitarPhoto createPhoto(ResultSet rs) throws SQLException {
        return new GuitarPhoto(rs);
    }
}
