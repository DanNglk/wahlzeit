package org.guitarzeit.model;

/**
 * Created by cdan on 15/12/14.
 */
public class GuitarManufacturer {

    private String name;
    private int founded;
    private String headOffice;


    /**
     * @pre none
     * @post GuitarManufacturer constructed
     * @methodtype constructor
     */
    public GuitarManufacturer(String name, int founded, String headOffice) {
        this.name = name;
        this.founded = founded;
        this.headOffice = headOffice;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public String getName() {
        return name;
    }


    /**
     * @pre
     * @post correct value set
     * @methodtype set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public int getFounded() {
        return founded;
    }


    /**
     * @pre
     * @post correct value set
     * @methodtype set
     */
    public void setFounded(int founded) {
        this.founded = founded;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public String getHeadOffice() {
        return headOffice;
    }


    /**
     * @pre
     * @post correct value set
     * @methodtype set
     */
    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }


    /**
     * @pre
     * @post get string representation of GuitarManufacturer
     * @methodtype converter
     */
    public String asString() {
        return name + " " + founded + " " + headOffice;
    }
}
