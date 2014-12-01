package org.wahlzeit.model;

import junit.framework.TestCase;
import org.wahlzeit.model.photos.*;

/**
 * Created by cdan on 24/11/14.
 */
public class GuitarPhotoTest extends TestCase {

    public void testSetters_correctValues_success() {
        GuitarPhoto guitarPhoto = new GuitarPhoto();

        try {
            guitarPhoto.setGuitarType(GuitarType.Acoustic);
            guitarPhoto.setGuitarShape(GuitarShape.Concert);
            guitarPhoto.setGuitarStrings(GuitarStringsFactory.getInstance(6, 10, GuitarStringMaterial.Nylon));
            guitarPhoto.setFrets(24);
            guitarPhoto.setFeatures("none");
            guitarPhoto.setPickups(2);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }


    public void testSetters_incorrectFrets_assertionError() {
        GuitarPhoto guitarPhoto = new GuitarPhoto();

        try {
            guitarPhoto.setFrets(-1);
            fail();
        } catch (AssertionError e) {
            assertTrue(true);
        }
    }


    public void testSetters_incorrectPickups_assertionError() {
        GuitarPhoto guitarPhoto = new GuitarPhoto();

        try {
            guitarPhoto.setPickups(-2);
            fail();
        } catch (AssertionError e) {
            assertTrue(true);
        }
    }


    public void testSetters_incorrectStrings_assertionError() {
        GuitarPhoto guitarPhoto = new GuitarPhoto();

        try {
            guitarPhoto.setGuitarStrings(GuitarStringsFactory.getInstance(1, 10, GuitarStringMaterial.Nylon));
            fail();
        } catch (AssertionError e) {
            assertTrue(true);
        }
    }


    public void testSetters_incorrectStringSize_assertionError() {
        GuitarPhoto guitarPhoto = new GuitarPhoto();

        try {
            guitarPhoto.setGuitarStrings(GuitarStringsFactory.getInstance(6, 2, GuitarStringMaterial.Nylon));
            fail();
        } catch (AssertionError e) {
            assertTrue(true);
        }
    }


    public void testSetters_guitarStringsObjectSharing_equalObject() {
        GuitarPhoto guitarPhoto1 = new GuitarPhoto();
        GuitarPhoto guitarPhoto2 = new GuitarPhoto();

        try {
            guitarPhoto1.setGuitarStrings(GuitarStringsFactory.getInstance(6, 10, GuitarStringMaterial.Nylon));
            guitarPhoto2.setGuitarStrings(GuitarStringsFactory.getInstance(6, 10, GuitarStringMaterial.Nylon));
            assertTrue(guitarPhoto1.getGuitarStrings() == guitarPhoto2.getGuitarStrings());
        } catch (Exception e) {
            fail();
        }
    }


    public void testSetters_guitarStringsObjectSharing_assertionError() {
        GuitarPhoto guitarPhoto1 = new GuitarPhoto();
        GuitarPhoto guitarPhoto2 = new GuitarPhoto();

        try {
            guitarPhoto1.setGuitarStrings(GuitarStringsFactory.getInstance(6, 10, GuitarStringMaterial.Nylon));
            guitarPhoto2.setGuitarStrings(GuitarStringsFactory.getInstance(7, 10, GuitarStringMaterial.Nylon));
            assertFalse(guitarPhoto1.getGuitarStrings() == guitarPhoto2.getGuitarStrings());
        } catch (Exception e) {
            fail();
        }
    }


    public void testSetters_equalGuitarStringsValues_equalityByValue() {
        GuitarPhoto guitarPhoto1 = new GuitarPhoto();
        GuitarPhoto guitarPhoto2 = new GuitarPhoto();

        try {
            guitarPhoto1.setGuitarStrings(GuitarStringsFactory.getInstance(6, 10, GuitarStringMaterial.Nylon));
            guitarPhoto2.setGuitarStrings(new GuitarStrings.Builder().setStrings(6)
                                                                     .setSize(10)
                                                                     .setMaterial(GuitarStringMaterial.Nylon)
                                                                     .build());
            assertTrue(guitarPhoto1.getGuitarStrings().equals(guitarPhoto2.getGuitarStrings()));
        } catch (Exception e) {
            fail();
        }
    }


    public void testSetters_equalGuitarStringsValues_differentAddress() {
        GuitarPhoto guitarPhoto1 = new GuitarPhoto();
        GuitarPhoto guitarPhoto2 = new GuitarPhoto();

        try {
            guitarPhoto1.setGuitarStrings(GuitarStringsFactory.getInstance(6, 10, GuitarStringMaterial.Nylon));
            guitarPhoto2.setGuitarStrings(new GuitarStrings.Builder().setStrings(6)
                                                                     .setSize(10)
                                                                     .setMaterial(GuitarStringMaterial.Nylon)
                                                                     .build());
            assertFalse(guitarPhoto1.getGuitarStrings() == guitarPhoto2.getGuitarStrings());
        } catch (Exception e) {
            fail();
        }
    }
}
