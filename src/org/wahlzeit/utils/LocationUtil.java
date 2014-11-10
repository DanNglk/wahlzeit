package org.wahlzeit.utils;

/**
 * Created by cdan on 10/11/14.
 */
public class LocationUtil {

    public static boolean isLegalGPSCoordinate(String gpsCoordinate) {
        try {
            double coordinate = Double.parseDouble(gpsCoordinate);
            if (coordinate < 0)
                return false;
        } catch (Exception e) {
            return false | gpsCoordinate.isEmpty();
        }
        return true;
    }


    public static boolean isLegalMapcode(String mapcode){
        String regex = "[A-Z]+\\s[A-Za-z0-9].[A-Za-z0-9]";
        return mapcode.matches(regex) | mapcode.isEmpty();
    }
}
