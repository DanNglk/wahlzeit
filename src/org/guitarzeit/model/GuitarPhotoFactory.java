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


    /**
     * @pre
     * @post Return singleton instance of GuitarPhotoFactory
     * @methodtype get
     * @collaboration Manager
     */
    public static synchronized GuitarPhotoFactory getInstance() {
        if (guitarPhotoFactory == null) {
            guitarPhotoFactory = new GuitarPhotoFactory();
        }
        return guitarPhotoFactory;
    }


    /**
     * @pre
     * @post Creates GuitarPhoto by id
     * @methodtype factory
     * @collaboration Manager
     */
    @Override
    public GuitarPhoto createPhoto(PhotoId id) {
        return new GuitarPhoto(id);
    }


    /**
     * @pre
     * @post Creates GuitarPhoto by ResultSet
     * @methodtype factory
     * @collaboration Manager
     */
    @Override
    public GuitarPhoto createPhoto(ResultSet rs) throws SQLException {
        return new GuitarPhoto(rs);
    }
}
