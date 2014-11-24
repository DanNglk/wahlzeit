package org.wahlzeit.model.photos;

/**
 * Created by cdan on 18/11/14.
 */
public class GuitarStrings {

    private int strings;
    private int size;
    private GuitarStringMaterial material;


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public GuitarStrings(int strings, int size, GuitarStringMaterial material) {
        this.strings = strings;
        this.size = size;
        this.material = material;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public int getStrings() {
        return strings;
    }


    /**
     * @pre strings > 4
     * @post correct value set
     * @methodtype set
     */
    public void setStrings(int strings) {
        assert strings > 4;
        this.strings = strings;
        assert this.strings == strings;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public int getSize() {
        return size;
    }


    /**
     * @pre size > 0
     * @post correct value set
     * @methodtype set
     */
    public void setSize(int size) {
        assert size > 0;
        this.size = size;
        assert this.size == size;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public GuitarStringMaterial getMaterial() {
        return material;
    }


    /**
     * @pre material != null
     * @post correct value set
     * @methodtype set
     */
    public void setMaterial(GuitarStringMaterial material) {
        assert material != null;
        this.material = material;
        assert this.material == material;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     */
    public String asString() {
        return strings + " string; size " + size + "; " + material;
    }
}
