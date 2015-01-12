package org.guitarzeit.model;

import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

/**
 * Created by cdan on 03/11/14.
 */
public class GPSLocation extends AbstractLocation {

    private double latitude;
    private double longitude;


    /**
     * @pre
     * @post
     * @methodtype constructor
     * @collaboration Location
     */
    public GPSLocation() {
        super();
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     * @collaboration Location
     */
    public GPSLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    public double getLatitude() {
        return latitude;
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    public double getLongitude() {
        return longitude;
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    protected double doGetLatitude() {
        return getLatitude();
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    protected double doGetLongitude() {
        return getLongitude();
    }


    /**
     * @pre
     * @post
     * @methodtype conversion
     * @collaboration Location
     */
    @Override
    protected String doGetMapcode() {
        return MapcodeCodec.encodeToShortest(getLatitude(), getLongitude()).toString();
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    protected void doSetLatitude(double latitude) {
        setLatitude(latitude);
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    protected void doSetLongitude(double longitude) {
        setLongitude(longitude);
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    protected void doSetMapcode(String mapcode) {
        try {
            Point point = MapcodeCodec.decode(mapcode);
            setLatitude(point.getLatDeg());
            setLongitude(point.getLonDeg());
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode");
        }
    }


    /**
     * @pre
     * @post
     * @methodtype conversion
     * @collaboration Location
     */
    @Override
    protected String doAsString() {
        return "Latitude: " + getLatitude() + " ; Longitude: " + getLongitude();
    }
}
