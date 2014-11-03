package org.wahlzeit.model.location;

import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

/**
 * Created by cdan on 03/11/14.
 */
public class MapcodeLocation extends AbstractLocation {

    private String mapcode;

    @Override
    public String getMapcode() {
        return mapcode;
    }

    @Override
    public void setMapcode(String mapcode) {
        this.mapcode = mapcode;
    }

    @Override
    protected double doGetLatitude() {
        try {
            return MapcodeCodec.decode(mapcode).getLatDeg();
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode to latitude");
        }
    }

    @Override
    protected double doGetLongitude() {
        try {
            return MapcodeCodec.decode(mapcode).getLonDeg();
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode to longitude");
        }
    }

    @Override
    protected String doGetMapcode() {
        return getMapcode();
    }

    @Override
    protected void doSetLatitude(double latitude) {
        try {
            Point gpsCoordinates = MapcodeCodec.decode(mapcode);
            double newLatitude = latitude;
            double oldLongitude = gpsCoordinates.getLonDeg();
            setMapcode(MapcodeCodec.encodeToInternational(newLatitude, oldLongitude).toString());
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode");
        }
    }

    @Override
    protected void doSetLongitude(double longitude) {
        try {
            Point gpsCoordinates = MapcodeCodec.decode(mapcode);
            double oldLatitude = gpsCoordinates.getLatDeg();
            double newLongitude = longitude;
            setMapcode(MapcodeCodec.encodeToInternational(oldLatitude, newLongitude).toString());
        } catch (UnknownMapcodeException e) {
            throw new RuntimeException("Decoding error, could not decode mapcode");
        }
    }

    @Override
    protected void doSetMapcode(String mapcode) {
        setMapcode(mapcode);
    }

    @Override
    protected String doAsString() {
        return "Mapcode: " + getMapcode();
    }
}
