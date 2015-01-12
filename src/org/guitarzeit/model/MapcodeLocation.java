package org.guitarzeit.model;

import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

/**
 * Created by nuesser on 03/11/14.
 */
public class MapcodeLocation extends AbstractLocation {

    private String mapcode;

    /**
     * @pre
     * @post
     * @methodtype constructor
     * @collaboration Location
     */
    public MapcodeLocation() {
        super();
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     * @collaboration Location
     */

    public MapcodeLocation(String mapcode) {
        this.mapcode = mapcode;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    public String getMapcode() {
        return mapcode;
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    public void setMapcode(String mapcode) {
        this.mapcode = mapcode;
    }


    /**
     * @pre
     * @post
     * @methodtype conversion
     * @collaboration Location
     */
    @Override
    protected double doGetLatitude() {
        try {
            return MapcodeCodec.decode(mapcode).getLatDeg();
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode to latitude");
        }
    }


    /**
     * @pre
     * @post
     * @methodtype conversion
     * @collaboration Location
     */
    @Override
    protected double doGetLongitude() {
        try {
            return MapcodeCodec.decode(mapcode).getLonDeg();
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode to longitude");
        }
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    protected String doGetMapcode() {
        return getMapcode();
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    protected void doSetLatitude(double latitude) {
        if (mapcode != null) {
            try {
                Point gpsCoordinates = MapcodeCodec.decode(mapcode);
                double newLatitude = latitude;
                double oldLongitude = gpsCoordinates.getLonDeg();
                setMapcode(MapcodeCodec.encodeToShortest(newLatitude, oldLongitude).toString());
            } catch (UnknownMapcodeException e) {
                throw new RuntimeException("Decoding error, could not decode mapcode");
            }
        }
        else
            setMapcode(MapcodeCodec.encodeToInternational(latitude, 0.0).toString());
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    protected void doSetLongitude(double longitude) {
        if (mapcode != null) {
            try {
                Point gpsCoordinates = MapcodeCodec.decode(mapcode);
                double oldLatitude = gpsCoordinates.getLatDeg();
                double newLongitude = longitude;
                setMapcode(MapcodeCodec.encodeToShortest(oldLatitude, newLongitude).toString());
            } catch (UnknownMapcodeException e) {
                throw new RuntimeException("Decoding error, could not decode mapcode");
            }
        }
        else
            setMapcode(MapcodeCodec.encodeToInternational(0.0, longitude).toString());
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    protected void doSetMapcode(String mapcode) {
        setMapcode(mapcode);
    }


    /**
     * @pre
     * @post
     * @methodtype conversion
     * @collaboration Location
     */
    @Override
    protected String doAsString() {
        return "Mapcode: " + getMapcode();
    }
}
