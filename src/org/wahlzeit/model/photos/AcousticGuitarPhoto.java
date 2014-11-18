package org.wahlzeit.model.photos;

import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 18/11/14.
 */
public class AcousticGuitarPhoto extends GuitarPhoto {

    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public AcousticGuitarPhoto() {
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public AcousticGuitarPhoto(PhotoId myId) {
        super(myId);
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public AcousticGuitarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }
}
