package org.wahlzeit.model.photos;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cdan on 25/11/14.
 */
public class GuitarStringsFactory {

    private static Map<Long, GuitarStrings> guitarStringsMap = new HashMap<>();


    public static GuitarStrings getInstance(int strings, int size, GuitarStringMaterial material) {
        long hashCode = getGuitarStringsHash(strings, size, material);
        if (!guitarStringsMap.containsKey(hashCode))
            guitarStringsMap.put(hashCode, new GuitarStrings.Builder().setStrings(strings)
                                                                      .setSize(size)
                                                                      .setMaterial(material)
                                                                      .build());

        return guitarStringsMap.get(hashCode);
    }


    private static long getGuitarStringsHash(Integer strings, Integer size, GuitarStringMaterial material) {
        return strings.hashCode() * 1 + size.hashCode() * 10 + material.hashCode();
    }
}
