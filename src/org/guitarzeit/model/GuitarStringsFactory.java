package org.guitarzeit.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cdan on 25/11/14.
 */
public class GuitarStringsFactory {

    private static Map<Integer, GuitarStrings> guitarStringsMap = new HashMap<>();


    /**
     * @pre
     * @post Creates GuitarStrings object by attributes and pushes object into map for sharing
     * @methodtype factory
     * @collaboration Value Object
     */
    public static GuitarStrings getInstance(int strings, int size, GuitarStringMaterial material) {
        int hashCode = getGuitarStringsHash(strings, size, material);
        if (!guitarStringsMap.containsKey(hashCode))
            guitarStringsMap.put(hashCode, new GuitarStrings.Builder().setStrings(strings)
                                                                      .setSize(size)
                                                                      .setMaterial(material)
                                                                      .build());

        return guitarStringsMap.get(hashCode);
    }


    /**
     * @pre
     * @post Generates hash code for specific attributes
     * @methodtype utility
     * @collaboration Value Object
     */
    private static int getGuitarStringsHash(Integer strings, Integer size, GuitarStringMaterial material) {
        return new StringBuilder().append(strings.hashCode())
                                  .append(size.hashCode())
                                  .append(material.hashCode())
                                  .toString()
                                  .hashCode();
    }
}
