package org.guitarzeit.model;

import java.util.Random;

/**
 * Created by cdan on 08/12/14.
 */
public class GuitarId {

    protected static int currentId = 0;

    public static final int BUFFER_SIZE_INCREMENT = 64;

    public static final GuitarId NULL_ID = new GuitarId(0);

    protected static GuitarId[] ids = new GuitarId[BUFFER_SIZE_INCREMENT];

    public static final int ID_START = getFromString("x1abz") + 1 ;

    protected static Random randomNumber = new Random(System.currentTimeMillis());

    public static int getCurrentIdAsInt() {
        return currentId;
    }


    public static synchronized void setCurrentIdFromInt(int id) {
        currentId = id;
        ids = new GuitarId[currentId + BUFFER_SIZE_INCREMENT];
        ids[0] = NULL_ID;
    }


    public static synchronized int getNextIdAsInt() {
        currentId += 1;
        if (currentId >= ids.length) {
            GuitarId[] nids = new GuitarId[currentId + BUFFER_SIZE_INCREMENT];
            System.arraycopy(ids, 0, nids, 0, currentId);
            ids = nids;
        }
        return currentId;
    }


    public static GuitarId getIdFromInt(int id) {
        if ((id < 0) || (id > currentId)) {
            return NULL_ID;
        }

        // @FIXME http://en.wikipedia.org/wiki/Double-checked_locking
        GuitarId result = ids[id];
        if (result == null) {
            synchronized(ids) {
                result = ids[id];
                if (result == null) {
                    result = new GuitarId(id);
                    ids[id] = result;
                }
            }
        }

        return result;
    }


    public static GuitarId getIdFromString(String id) {
        return getIdFromInt(getFromString(id));
    }


    public static GuitarId getNextId() {
        return getIdFromInt(getNextIdAsInt());
    }


    public static GuitarId getRandomId() {
        int max = getCurrentIdAsInt() - 1;
        int id = randomNumber.nextInt();
        id = (id == Integer.MIN_VALUE) ? id ++ : id;
        id = (Math.abs(id) % max) + 1;
        return getIdFromInt(id);
    }


    protected int value = 0;
    protected String stringValue = null;


    protected GuitarId(int myValue) {
        value = myValue;
        stringValue = getFromInt(myValue);
    }


    public boolean equals(Object o) {
        // @FIXME

        if (!(o instanceof GuitarId)) {
            return false;
        }

        GuitarId pid = (GuitarId) o;
        return isEqual(pid);
    }


    public boolean isEqual(GuitarId other) {
        return other.value == value;
    }


    public int hashCode() {
        return value;
    }


    public boolean isNullId() {
        return this == NULL_ID;
    }


    public int asInt() {
        return value;
    }


    public String asString() {
        return stringValue;
    }


    public static String getFromInt(int id) {
        StringBuffer result = new StringBuffer(10);

        id += ID_START;
        for ( ; id > 0;	id = id / 36 ) {
            char letterOrDigit;
            int modulus = id % 36;
            if (modulus < 10) {
                letterOrDigit = (char) ((int) '0' + modulus);
            } else {
                letterOrDigit = (char) ((int) 'a' - 10 + modulus);
            }
            result.insert(0, letterOrDigit);

        }

        return "x" + result.toString();
    }


    public static int getFromString(String value) {
        int result = 0;
        for (int i = 1; i < value.length(); i ++ ) {
            int temp = 0;
            char letterOrDigit = value.charAt(i);
            if (letterOrDigit < 'a') {
                temp = (int) letterOrDigit - '0';
            } else {
                temp = 10 + (int) letterOrDigit - 'a';
            }
            result = result * 36 + temp;
        }

        result -= ID_START;
        if (result < 0) {
            result = 0;
        }

        return result;
    }
}
