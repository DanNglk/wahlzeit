package org.guitarzeit.model;

/**
 * Created by cdan on 03/11/14.
 */
public abstract class AbstractLocation implements Location{

    @Override
    public double getLatitude() {
        return doGetLatitude();
    }


    @Override
    public double getLongitude() {
        return doGetLongitude();
    }


    @Override
    public String getMapcode() {
        return doGetMapcode();
    }


    @Override
    public void setLatitude(double latitude) {
        doSetLatitude(latitude);
    }


    @Override
    public void setLongitude(double longitude) {
        doSetLongitude(longitude);
    }


    @Override
    public void setMapcode(String mapcode) {
        doSetMapcode(mapcode);
    }


    @Override
    public String asString() {
        return doAsString();
    }


    protected abstract double doGetLatitude();


    protected abstract double doGetLongitude();


    protected abstract String doGetMapcode();


    protected abstract void doSetLatitude(double latitude);


    protected abstract void doSetLongitude(double longitude);


    protected abstract void doSetMapcode(String mapcode);


    protected abstract String doAsString();
}
