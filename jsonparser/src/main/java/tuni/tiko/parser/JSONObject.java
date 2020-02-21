package tuni.tiko.parser;

import java.util.HashMap;
import java.util.Map;

public class JSONObject extends HashMap {
    private HashMap values;

    /**
     * Default constructor to intitialize the JSONObject.
     *
     */
    public JSONObject() {
        // Construct empty JSONObject
        values = new HashMap();
    }

    /**
     * Parameter constructor to initialize JSONArray using received map.
     *
     * @param map to initialize the JSONObject
     */
    public JSONObject(Map<String, Object> map) {
        // Construct empty JSONObject
        values = (HashMap)map;
    }

    /**
     * Receives a map and saves it to JSONObject HashMap.
     *
     * @param map to type cast into HashMap to hold key pair values
     */
    public void put(Map<String, Object> map) {
        values = (HashMap)map;
    }

    /**
     * Returns the JSONObject as a String and replaces all "=" marks to ":".
     *
     *  @return JSONObject as a String
     */
    @Override
    public String toString() {
        return values.toString().replaceAll("=",":");
    }
}
