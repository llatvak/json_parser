package tuni.tiko.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class to create JSONArray and hold actions.
 *
 * @author Lauri Latva-Kyyny
 * @version 1.0
 */
public class JSONArray extends ArrayList {
    private List list;

    /**
     * Default constructor to initialize the list.
     */
    public JSONArray() {
        list = new ArrayList();
    }

    /**
     * Receives map as parameter and creates a JSONObject out of that map and adds it to JSONArray.
     *
     * @param map map to send to JSONObject
     */
    public void add(Map<String, Object> map) {
        list.add(new JSONObject(map));
    }

    /**
     * Receives a file as a parameter and writes that file in a JSON format.
     *
     * @param file received file to write to
     */
    public  void writeToFile(File file) {
        String path = file.getAbsolutePath();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), "utf-8"))) {
            writer.write(this.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the JSONArray and modifies it if contains JSONObjects.
     *
     * @return JSONArray contents as a string.
     */
    @Override
    public String toString() {
        String result = list.toString();
        if(result.contains("{")) {
            result = result.replace("=",":");
        }
        return result;
    }
}
