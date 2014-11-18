package org.wahlzeit.model.photos;

import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 18/11/14.
 */
public class ElectricGuitarPhoto extends GuitarPhoto {

    private int pickups;


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public ElectricGuitarPhoto() {
        super();
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public ElectricGuitarPhoto(PhotoId myId) {
        super(myId);
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public ElectricGuitarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public int getPickups() {
        return pickups;
    }


    /**
     * @pre pickups > 0
     * @post correct value set
     * @methodtype set
     */
    public void setPickups(int pickups) {
        assert pickups > 0;
        this.pickups = pickups;
        assert this.pickups == pickups;
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        //todo: set attributes
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        //todo: write attributes
    }
}