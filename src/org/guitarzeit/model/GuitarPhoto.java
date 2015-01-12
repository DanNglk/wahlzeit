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
     * @collaboration Manager
     */
    public GuitarPhoto(PhotoId myId) {
        super(myId);
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     * @collaboration Manager
     */
    public GuitarPhoto(ResultSet rset) throws SQLException {
        super(rset);
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client, GuitarPhoto/Guitar
     */
    public Guitar getGuitar() {
        return guitar;
    }


    /**
     * @pre guitar != null
     * @post correct value set
     * @methodtype set
     * @collaboration Client, GuitarPhoto/Guitar
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
     * @collaboration Serializer
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        guitar = GuitarFactory.getInstance().createGuitar(GuitarId.getIdFromInt(rset.getInt("guitar_id")));
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     * @collaboration Serializer
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateInt("guitar_id", guitar.getGuitarId().asInt());
    }
}
