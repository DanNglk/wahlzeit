package org.guitarzeit.model;

/**
 * Created by cdan on 03/11/14.
 */
public interface Location {
    double getLatitude();
    double getLongitude();
    String getMapcode();
    void setLatitude(double latitude);
    void setLongitude(double longitude);
    void setMapcode(String mapcode);
    String asString();
}
