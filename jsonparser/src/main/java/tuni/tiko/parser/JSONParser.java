package tuni.tiko.parser;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class to run the app and get map out of POJO's
 *
 * @author Lauri Latva-Kyyny
 * @version 1.0
 */
public class JSONParser {

    /**
     * Main method to start the parser.
     *
     * @param args parameter arguments in a String array
     */
    public static void main( String[] args ) {
        System.out.println("Author: Lauri Latva-Kyyny");
    }

    /**
     * Creates a map from plain java object and returns it.
     * <p>
     * Saves the class and methods of object parameter and finds the key,value pair.
     * Puts the object key,value pair to HashMap.
     * </p>
     *
     * @param obj object which from to create the map
     * @return  returns map with object's key,value pair
     */
    public Map<String, Object> pojoToMap(Object obj) {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        try {
            // Saves object class to generic object which can be any type of object
            Class<? extends Object> c = obj.getClass();
            // Saves the method of that class into Method array using reflect
            Method m[] = c.getMethods();
            // Loops through object's methods
            for (int i = 0; i < m.length; i++) {
                // If method at index i starts with word "get" (ignorning the getClass method) saves the key and value to a HashMap
                if (m[i].getName().indexOf("get") == 0 && !m[i].getName().equals("getClass")) {
                    // Letter after get word is set to lower case and adds word after that string
                    String name = "\"" + m[i].getName().toLowerCase().substring(3, 4) + m[i].getName().substring(4) + "\"";
                    // gets the value from getter by invoking the method at index i
                    Object o = m[i].invoke(obj, new Object[0]);
                    // If value is type String sets it to lowercase and adds quotes around it
                    if(o instanceof String) {
                        o = "\"" + ((String) o).toLowerCase() + "\"";
                    }
                    hashMap.put(name, o);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
