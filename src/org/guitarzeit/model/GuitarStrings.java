package org.guitarzeit.model;

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
         * @collaboration Type Object
         */
        public Builder setStrings(int strings) {
            try {
                assert strings > 4;
            } catch (AssertionError error)
            {
                throw new RuntimeException("Wrong amount of strings. Must be more than 4, yours were " + strings);
            }
            this.strings = strings;
            assert this.strings == strings;
            return this;
        }


        /**
         * @pre size > 0
         * @post correct value set
         * @methodtype set
         * @collaboration Type Object
         */
        public Builder setSize(int size) {
            try {
                assert size > 0;
            } catch (AssertionError error)
            {
                throw new RuntimeException("Wrong size. Must be more than 0, yours were " + size);
            }
            this.size = size;
            assert this.size == size;
            return this;
        }


        /**
         * @pre material != null
         * @post correct value set
         * @methodtype set
         * @collaboration Type Object
         */
        public Builder setMaterial(GuitarStringMaterial material) {
            try {
                assert material != null;
            } catch (AssertionError error)
            {
                throw new RuntimeException("Wrong material, can not be null");
            }
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
     * @collaboration Type Object
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
     * @collaboration Type Object
     */
    public int getStrings() {
        return strings;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Type Object
     */
    public int getSize() {
        return size;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Type Object
     */
    public GuitarStringMaterial getMaterial() {
        return material;
    }


    /**
     * @pre
     * @post
     * @methodtype get
     * @collaboration Type Object
     */
    public String asString() {
        return strings + " string; size " + size + "; " + material;
    }


    /**
     * @pre
     * @post
     * @methodtype assertion
     * @collaboration Type Object
     */
    @Override
    public boolean equals(Object obj) {
        GuitarStrings guitarStrings = (GuitarStrings) obj;
        return this.strings == guitarStrings.strings && this.size == guitarStrings.size && this.material == guitarStrings.material;
    }
}
