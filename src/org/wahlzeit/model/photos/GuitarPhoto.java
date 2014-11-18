package org.wahlzeit.model.photos;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 18/11/14.
 */
public class GuitarPhoto extends Photo {

    private GuitarStrings guitarStrings;
    private GuitarShape guitarShape;
    private int frets;
    private String features;


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public GuitarPhoto() {
        super();
    }


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
    public GuitarStrings getGuitarStrings() {
        return guitarStrings;
    }


    /**
     * @pre guitarStrings != null
     * @post correct value set
     * @methodtype set
     */
    public void setGuitarStrings(GuitarStrings guitarStrings) {
        assert guitarStrings != null;
        this.guitarStrings = guitarStrings;
        assert this.guitarStrings == guitarStrings;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public GuitarShape getGuitarShape() {
        return guitarShape;
    }


    /**
     * @pre guitarShape != null
     * @post correct value set
     * @methodtype set
     */
    public void setGuitarShape(GuitarShape guitarShape) {
        assert guitarShape != null;
        this.guitarShape = guitarShape;
        assert this.guitarShape == guitarShape;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public int getFrets() {
        return frets;
    }


    /**
     * @pre frets > 0
     * @post correct value set
     * @methodtype set
     */
    public void setFrets(int frets) {
        assert frets > 0;
        this.frets = frets;
        assert this.frets == frets;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public String getFeatures() {
        return features;
    }


    /**
     * @pre features != null
     * @post correct value set
     * @methodtype set
     */
    public void setFeatures(String features) {
        assert features != null;
        this.features = features;
        assert this.features == features;
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        //todo: read new attributes
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        //todo: write new attributes
    }
}
