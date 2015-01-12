package org.guitarzeit.model;

/**
 * Created by cdan on 03/11/14.
 */
public abstract class AbstractLocation implements Location{

    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    public double getLatitude() {
        return doGetLatitude();
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    public double getLongitude() {
        return doGetLongitude();
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Location
     */
    @Override
    public String getMapcode() {
        return doGetMapcode();
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    public void setLatitude(double latitude) {
        doSetLatitude(latitude);
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    public void setLongitude(double longitude) {
        doSetLongitude(longitude);
    }


    /**
     * @pre
     * @post
     * @methodtype set
     * @collaboration Location
     */
    @Override
    public void setMapcode(String mapcode) {
        doSetMapcode(mapcode);
    }


    /**
     * @pre
     * @post
     * @methodtype conversion
     * @collaboration Location
     */
    @Override
    public String asString() {
        return doAsString();
    }


    /**
     * @pre
     * @post
     * @methodtype get, hook
     * @collaboration Location
     */
    protected abstract double doGetLatitude();


    /**
     * @pre
     * @post
     * @methodtype get, hook
     * @collaboration Location
     */
    protected abstract double doGetLongitude();


    /**
     * @pre
     * @post
     * @methodtype get, hook
     * @collaboration Location
     */
    protected abstract String doGetMapcode();


    /**
     * @pre
     * @post
     * @methodtype set, hook
     * @collaboration Location
     */
    protected abstract void doSetLatitude(double latitude);


    /**
     * @pre
     * @post
     * @methodtype set, hook
     * @collaboration Location
     */
    protected abstract void doSetLongitude(double longitude);


    /**
     * @pre
     * @post
     * @methodtype set, hook
     * @collaboration Location
     */
    protected abstract void doSetMapcode(String mapcode);


    /**
     * @pre
     * @post
     * @methodtype conversion, hook
     * @collaboration Location
     */
    protected abstract String doAsString();
}
