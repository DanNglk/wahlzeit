package org.wahlzeit.model.photos;

/**
 * Created by cdan on 18/11/14.
 */
public class GuitarStrings {

    private int strings;
    private GuitarStringMaterial material;


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public GuitarStrings(int strings, GuitarStringMaterial material) {
        this.strings = strings;
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
}
