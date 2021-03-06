package org.guitarzeit.model;

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
    public static final String MANUFACTURER_CAPTION = "manufacturer";
    public static final String FRETS_CAPTION = "frets";
    public static final String FEATURES_CAPTION = "features";
    public static final String PICKUPS_CAPTION = "pickups";


    public static final String TYPE = "type";
    public static final String SHAPE = "shape";
    public static final String STRINGS = "strings";
    public static final String STRING_SIZE = "string_size";
    public static final String STRING_MATERIAL = "string_material";
    public static final String MANUFACTURER_NAME = "manufacturer_name";
    public static final String MANUFACTURER_ESTABLISHED = "manufacturer_established";
    public static final String MANUFACTURER_HEADOFFICE = "manufacturer_headoffice";
    public static final String FRETS = "frets";
    public static final String FEATURES = "features";
    public static final String PICKUPS = "pickups";


    private GuitarId guitarId;
    private GuitarType guitarType;
    private GuitarShape guitarShape;
    private GuitarStrings guitarStrings;
    private GuitarManufacturer guitarManufacturer;
    private int frets;
    private String features;
    private int pickups;


    /**
     * @pre
     * @post Guitar constructed
     * @methodtype constructor
     * @collaboration Manager
     */
    public Guitar(GuitarId guitarId) {
        this.guitarId = guitarId;
    }


    /**
     * @pre
     * @post Guitar constructed
     * @methodtype constructor
     * @collaboration Manager
     */
    public Guitar(ResultSet resultSet) throws SQLException {
        readFrom(resultSet);
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Manager
     */
    public GuitarId getGuitarId() {
        return guitarId;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client, Value Object
     */
    public GuitarType getGuitarType() {
        return guitarType;
    }


    /**
     * @pre param not null
     * @post correct value set
     * @methodtype set
     * @collaboration Client, Value Object
     */
    public void setGuitarType(GuitarType guitarType) {
        try
        {
            assert guitarType != null;
        } catch (AssertionError error)
        {
            throw new RuntimeException("guitarType must not be null");
        }
        this.guitarType = guitarType;
        assert this.guitarType == guitarType;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client, Value Object
     */
    public GuitarShape getGuitarShape() {
        return guitarShape;
    }


    /**
     * @pre param not null
     * @post correct value set
     * @methodtype set
     * @collaboration Client, Value Object
     */
    public void setGuitarShape(GuitarShape guitarShape) {
        try
        {
            assert guitarShape != null;
        } catch (AssertionError error)
        {
            throw new RuntimeException("guitarShape must not be null");
        }
        this.guitarShape = guitarShape;
        assert this.guitarShape == guitarShape;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client, Type Object
     */
    public GuitarStrings getGuitarStrings() {
        return guitarStrings;
    }


    /**
     * @pre param not null
     * @post correct value set
     * @methodtype set
     * @collaboration Client, Type Object
     */
    public void setGuitarStrings(GuitarStrings guitarStrings) {
        try
        {
            assert guitarStrings != null;
        } catch (AssertionError error)
        {
            throw new RuntimeException("guitarStrings must not be null");
        }
        this.guitarStrings = guitarStrings;
        assert this.guitarStrings == guitarStrings;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client, Type Object
     */
    public GuitarManufacturer getGuitarManufacturer() {
        return guitarManufacturer;
    }


    /**
     * @pre param not null
     * @post correct value set
     * @methodtype set
     * @collaboration Client, Type Object
     */
    public void setGuitarManufacturer(GuitarManufacturer guitarManufacturer) {
        try
        {
            assert guitarManufacturer != null;
        } catch (AssertionError error)
        {
            throw new RuntimeException("guitarManufacturer must not be null");
        }
        this.guitarManufacturer = guitarManufacturer;
        assert this.guitarManufacturer == guitarManufacturer;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client
     */
    public int getFrets() {
        return frets;
    }


    /**
     * @pre frets > 10
     * @post correct value set
     * @methodtype set
     * @collaboration Client
     */
    public void setFrets(int frets) {
        try
        {
            assert frets > 10;
        } catch (AssertionError error)
        {
            throw new RuntimeException("Wrong value. Frets must be greater than 10, yours were " + frets);
        }
        this.frets = frets;
        assert this.frets == frets;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client
     */
    public String getFeatures() {
        return features;
    }


    /**
     * @pre param not null
     * @post correct value set
     * @methodtype set
     * @collaboration Client
     */
    public void setFeatures(String features) {
        try
        {
            assert features != null;
        } catch (AssertionError error)
        {
            throw new RuntimeException("features must not be null");
        }
        this.features = features;
        assert this.features == features;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Client
     */
    public int getPickups() {
        return pickups;
    }


    /**
     * @pre pickups > 0
     * @post correct value set
     * @methodtype set
     * @collaboration Client
     */
    public void setPickups(int pickups) {
        try
        {
            assert pickups >= 0;
        } catch (AssertionError error)
        {
            throw new RuntimeException("Wrong value. Pickups must be 0 or greater than 0, yours were " + pickups);
        }
        this.pickups = pickups;
        assert this.pickups == pickups;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Serializer
     */
    @Override
    public String getIdAsString() {
        return guitarId.asString();
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     * @collaboration Serializer
     */
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        this.guitarId = GuitarId.getIdFromInt(rset.getInt("id"));
        this.guitarType = GuitarType.valueOf(rset.getString("type"));
        this.guitarShape = GuitarShape.valueOf(rset.getString("shape"));
        this.guitarStrings = GuitarStringsFactory.getInstance(rset.getInt("strings"), rset.getInt("strings_size"),
                GuitarStringMaterial.valueOf(rset.getString("strings_material")));
        this.guitarManufacturer = new GuitarManufacturer(rset.getString("manufacturer_name"), rset.getInt("manufacturer_founded"),
                rset.getString("manufacturer_headoffice"));
        this.frets = rset.getInt("frets");
        this.features = rset.getString("features");
        this.pickups = rset.getInt("pickups");
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     * @collaboration Serializer
     */
    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateInt("id", guitarId.asInt());
        rset.updateString("type", guitarType.name());
        rset.updateString("shape", guitarShape.name());
        rset.updateInt("strings", guitarStrings.getStrings());
        rset.updateInt("strings_size", guitarStrings.getSize());
        rset.updateString("strings_size", guitarStrings.getMaterial().name());
        rset.updateString("manufacturer_name", guitarManufacturer.getName());
        rset.updateInt("manufacturer_founded", guitarManufacturer.getFounded());
        rset.updateString("manufacturer_headoffice", guitarManufacturer.getHeadOffice());
        rset.updateInt("frets", getFrets());
        rset.updateString("features", getFeatures());
        rset.updateInt("pickups", getPickups());
    }


    /**
     * @pre
     * @post
     * @methodtype mutation
     * @collaboration Serializer
     */
    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        stmt.setInt(pos, guitarId.asInt());
    }
}
