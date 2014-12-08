package org.guitarzeit.model;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 18/11/14.
 */
public class GuitarPhoto extends Photo {

    private Guitar guitar;


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public GuitarPhoto(PhotoId myId) {
        super(myId);
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public GuitarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public Guitar getGuitar() {
        return guitar;
    }


    /**
     * @pre guitar != null
     * @post correct value set
     * @methodtype set
     */
    public void setGuitar(Guitar guitar) {
        assert guitar != null;
        this.guitar = guitar;
        assert this.guitar == guitar;
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        guitar.readFrom(rset);
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        guitar.writeOn(rset);
    }
}
