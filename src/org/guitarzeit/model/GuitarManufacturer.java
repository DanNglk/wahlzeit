package org.guitarzeit.model;


import java.sql.Date;

/**
 * Created by cdan on 15/12/14.
 */
public class GuitarManufacturer {

    private String name;
    private Date establishedSince;
    private String headOffice;


    public GuitarManufacturer() {
        this.name = "default";
        this.establishedSince = new Date(0);
        this.headOffice = "default";
    }


    public GuitarManufacturer(String name, Date establishedSince, String headOffice) {
        this.name = name;
        this.establishedSince = establishedSince;
        this.headOffice = headOffice;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Date getEstablishedSince() {
        return establishedSince;
    }


    public void setEstablishedSince(Date establishedSince) {
        this.establishedSince = establishedSince;
    }


    public String getHeadOffice() {
        return headOffice;
    }


    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }
}
