package org.guitarzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by cdan on 02/12/14.
 */
public class GuitarFactory {

    public static GuitarFactory guitarFactory = null;


    public static synchronized GuitarFactory getInstance() {
        if (guitarFactory == null) {
            guitarFactory = new GuitarFactory();
        }
        return guitarFactory;
    }


    public Guitar createGuitar(GuitarId guitarId) {
        return new Guitar(guitarId);
    }


    public Guitar createGuitar(ResultSet rs) throws SQLException {
        return new Guitar(rs);
    }
}
