package org.guitarzeit.model;

import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdan on 02/12/14.
 */
public class Guitar extends DataObject {

    public static final String TYPE_CAPTION = "type";
    public static final String SHAPE_CAPTION = "shape";
    public static final String STRINGS_CAPTION = "strings";
    public static final String FRETS_CAPTION = "frets";
    public static final String FEATURES_CAPTION = "features";
    public static final String PICKUPS_CAPTION = "pickups";


    public static final String TYPE = "type";
    public static final String SHAPE = "shape";
    public static final String STRINGS = "strings";
    public static final String STRING_SIZE = "string_size";
    public static final String STRING_MATERIAL = "string_material";
    public static final String FRETS = "frets";
    public static final String FEATURES = "features";
    public static final String PICKUPS = "pickups";


    private PhotoId photoId;
    private GuitarId guitarId;
    private GuitarType guitarType;
    private GuitarShape guitarShape;
    private GuitarStrings guitarStrings;
    private int frets;
    private String features;
    private int pickups;


    /**
     * @pre
     * @post Guitar constructed
     * @methodtype constructor
     */
    public Guitar(GuitarId guitarId) {
        this.guitarId = guitarId;
    }


    /**
     * @pre
     * @post Guitar constructed
     * @methodtype constructor
     */
    public Guitar(ResultSet resultSet) throws SQLException {
        readFrom(resultSet);
    }


    public PhotoId getPhotoId() {
        return photoId;
    }

    public void setPhotoId(PhotoId photoId) {
        this.photoId = photoId;
    }

    public GuitarId getGuitarId() {
        return guitarId;
    }


    public void setGuitarId(GuitarId guitarId) {
        this.guitarId = guitarId;
    }


    public GuitarType getGuitarType() {
        return guitarType;
    }


    public void setGuitarType(GuitarType guitarType) {
        this.guitarType = guitarType;
    }


    public GuitarShape getGuitarShape() {
        return guitarShape;
    }


    public void setGuitarShape(GuitarShape guitarShape) {
        this.guitarShape = guitarShape;
    }


    public GuitarStrings getGuitarStrings() {
        return guitarStrings;
    }


    public void setGuitarStrings(GuitarStrings guitarStrings) {
        this.guitarStrings = guitarStrings;
    }


    public int getFrets() {
        return frets;
    }


    public void setFrets(int frets) {
        this.frets = frets;
    }


    public String getFeatures() {
        return features;
    }


    public void setFeatures(String features) {
        this.features = features;
    }


    public int getPickups() {
        return pickups;
    }


    public void setPickups(int pickups) {
        this.pickups = pickups;
    }


    @Override
    public String getIdAsString() {
        return guitarId.asString();
    }


    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        this.photoId = PhotoId.getIdFromInt(rset.getInt("photo_id"));
        this.guitarId = GuitarId.getIdFromInt(rset.getInt("guitar_id"));
        this.guitarType = GuitarType.valueOf(rset.getString("guitar_type"));
        this.guitarShape = GuitarShape.valueOf(rset.getString("guitar_shape"));
        this.guitarStrings = GuitarStringsFactory.getInstance(rset.getInt("guitar_strings"), rset.getInt("guitar_strings_size"),
                GuitarStringMaterial.valueOf(rset.getString("guitar_strings_material")));
        this.frets = rset.getInt("guitar_frets");
        this.features = rset.getString("guitar_features");
        this.pickups = rset.getInt("guitar_pickups");
    }


    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateInt("photo_id", photoId.asInt());
        rset.updateInt("guitar_id", guitarId.asInt());
        rset.updateString("guitar_type", guitarType.name());
        rset.updateString("guitar_shape", guitarShape.name());
        rset.updateInt("guitar_strings", guitarStrings.getStrings());
        rset.updateInt("guitar_strings_size", guitarStrings.getSize());
        rset.updateString("guitar_strings_size", guitarStrings.getMaterial().name());
        rset.updateInt("guitar_frets", getFrets());
        rset.updateString("guitar_features", getFeatures());
        rset.updateInt("guitar_pickups", getPickups());
    }


    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        stmt.setInt(pos, guitarId.asInt());
    }
}
