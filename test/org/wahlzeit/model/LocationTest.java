package org.wahlzeit.model;

import junit.framework.TestCase;
import org.guitarzeit.model.GPSLocation;
import org.guitarzeit.model.Location;
import org.guitarzeit.model.MapcodeLocation;

/**
 * Created by cdan on 03/11/14.
 */
public class LocationTest extends TestCase {

    public void testGPSLocationAsString()
    {
        Location location = new GPSLocation();
        location.setLatitude(10.12345);
        location.setLongitude(21.4321);

        assertTrue(location.asString().equals("Latitude: 10.12345 ; Longitude: 21.4321"));
    }


    public void testGPSLocationGetMapcode()
    {
        Location location = new GPSLocation();
        location.setLatitude(52.513714);
        location.setLongitude(13.374825);

        assertTrue(location.getMapcode().equals("DEU 6K.YC"));
    }


    public void testGPSLocationSetMapcode()
    {
        Location location = new GPSLocation();
        location.setMapcode("DEU 6K.YC");

        assertTrue(location.getLatitude() == 52.51368 && location.getLongitude() == 13.374825);
    }


    public void testMapcodeLocationAsString()
    {
        Location location = new MapcodeLocation();
        location.setMapcode("DEU 1W.3A");

        assertTrue(location.asString().equals("Mapcode: DEU 1W.3A"));
    }


    public void testMapcodeLocationGetLatitude()
    {
        Location location = new MapcodeLocation();
        location.setMapcode("DEU 6K.YC");

        assertTrue(location.getLatitude() == 52.51368);
    }


    public void testMapcodeLocationGetLongitude()
    {
        Location location = new MapcodeLocation();
        location.setMapcode("DEU 6K.YC");

        assertTrue(location.getLongitude() == 13.374825);
    }


    public void testMapcodeLocationSetLatLong()
    {
        Location location = new MapcodeLocation();
        location.setLatitude(52.513714);
        location.setLongitude(13.374825);

        assertTrue(location.getMapcode().equals("DEU 6K.YC"));
    }
}
