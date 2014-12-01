package org.wahlzeit.model.photos;

/**
 * Created by cdan on 18/11/14.
 */
public class GuitarStrings {

    private final int strings;
    private final int size;
    private final GuitarStringMaterial material;


    public static class Builder {

        private int strings;
        private int size;
        private GuitarStringMaterial material;


        /**
         * @pre strings > 4
         * @post correct value set
         * @methodtype set
         */
        public Builder setStrings(int strings) {
            assert strings > 4;
            this.strings = strings;
            assert this.strings == strings;
            return this;
        }


        /**
         * @pre size > 0
         * @post correct value set
         * @methodtype set
         */
        public Builder setSize(int size) {
            assert size > 0;
            this.size = size;
            assert this.size == size;
            return this;
        }


        /**
         * @pre material != null
         * @post correct value set
         * @methodtype set
         */
        public Builder setMaterial(GuitarStringMaterial material) {
            assert material != null;
            this.material = material;
            assert this.material == material;
            return this;
        }


        public GuitarStrings build() {
            return new GuitarStrings(this);
        }
    }


    /**
     * @pre
     * @post
     * @methodtype constructor
     */
    public GuitarStrings(Builder builder) {
        this.strings = builder.strings;
        this.size = builder.size;
        this.material = builder.material;
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
     * @pre
     * @post
     * @methodtype get
     */
    public int getSize() {
        return size;
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
     * @pre
     * @post
     * @methodtype get
     */
    public String asString() {
        return strings + " string; size " + size + "; " + material;
    }


    @Override
    public boolean equals(Object obj) {
        GuitarStrings guitarStrings = (GuitarStrings) obj;
        return this.strings == guitarStrings.strings && this.size == guitarStrings.size && this.material == guitarStrings.material;
    }
}
