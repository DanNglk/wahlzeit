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


    public GPSLocation() {
        super();
    }


    public GPSLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    @Override
    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    @Override
    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @Override
    protected double doGetLatitude() {
        return getLatitude();
    }


    @Override
    protected double doGetLongitude() {
        return getLongitude();
    }


    @Override
    protected String doGetMapcode() {
        return MapcodeCodec.encodeToShortest(getLatitude(), getLongitude()).toString();
    }


    @Override
    protected void doSetLatitude(double latitude) {
        setLatitude(latitude);
    }


    @Override
    protected void doSetLongitude(double longitude) {
        setLongitude(longitude);
    }


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


    @Override
    protected String doAsString() {
        return "Latitude: " + getLatitude() + " ; Longitude: " + getLongitude();
    }
}
