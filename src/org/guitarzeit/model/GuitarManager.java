package org.guitarzeit.model;

import org.wahlzeit.main.ServiceMain;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.SysLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by cdan on 08/12/14.
 */
public class GuitarManager extends ObjectManager {

    private static GuitarManager instance = null;
    private Map<GuitarId, Guitar> guitarCache = new HashMap<GuitarId, Guitar>();


    /**
     * @pre
     * @post get singleton instance of GuitarManager
     * @methodtype get
     */
    public static final GuitarManager getInstance() {
        if (instance == null)
            instance = new GuitarManager();
        return instance;
    }


    @Override
    protected Guitar createObject(ResultSet rset) throws SQLException {
        return GuitarFactory.getInstance().createGuitar(rset);
    }


    /**
     * @pre
     * @post Creates new guitar object
     * @methodtype factory
     */
    public Guitar createGuitar() {
        GuitarId id = GuitarId.getNextId();
        Guitar guitar = GuitarFactory.getInstance().createGuitar(id);
        addGuitar(guitar);
        return guitar;
    }


    /**
     * @pre
     * @post Inserts guitar object into database
     * @methodtype command
     */
    public void addGuitar(Guitar guitar) {
        GuitarId id = guitar.getGuitarId();
        assertIsNewGuitar(id);
        doAddGuitar(guitar);

        try {
            PreparedStatement stmt = getReadingStatement("INSERT INTO guitars(id) VALUES(?)");
            createObject(guitar, stmt, id.asInt());
            ServiceMain.getInstance().saveGlobals();
            saveGuitar(guitar);
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }
    }

    /**
     * @pre
     * @post adds guitar to cache
     * @methodtype command
     */
    protected void doAddGuitar(Guitar myGuitar) {
        guitarCache.put(myGuitar.getGuitarId(), myGuitar);
    }


    /**
     * @pre
     * @post returns guitar from database by selecting from id
     * @methodtype get
     */
    public Guitar getGuitarFromId(GuitarId id) {
        if (id.isNullId()) {
            return null;
        }

        Guitar result = doGetGuitarFromId(id);

        if (result == null) {
            try {
                PreparedStatement stmt = getReadingStatement("SELECT * FROM guitars WHERE id = ?");
                result = (Guitar) readObject(stmt, id.asInt());
            } catch (SQLException sex) {
                SysLog.logThrowable(sex);
            }
            if (result != null) {
                doAddGuitar(result);
            }
        }

        return result;
    }


    /**
     * @pre
     * @post get guitar from cache by id
     * @methodtype get
     */
    protected Guitar doGetGuitarFromId(GuitarId id) {
        return guitarCache.get(id);
    }


    /**
     * @pre
     * @post saves guitar to database by selecting and updating guitar
     * @methodtype command
     */
    public void saveGuitar(Guitar guitar) {
        try {
            PreparedStatement stmt = getUpdatingStatement("SELECT * FROM guitars WHERE id = ?");
            updateObject(guitar, stmt);
        } catch (SQLException sex) {
            SysLog.logThrowable(sex);
        }
    }


    /**
     * @pre
     * @post asserts if guitar exists, if so new IllegalStateException is thrown
     * @methodtype assertion
     */
    protected void assertIsNewGuitar(GuitarId id) {
        if (getGuitarFromId(id) != null)  {
            throw new IllegalStateException("Guitar already exists!");
        }
    }
}
