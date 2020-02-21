package tuni.tiko.parser;

import junit.framework.TestCase;

import java.util.HashMap;

/**
 * Tests for JSONObject.
 *
 * @author Lauri Latva-Kyyny
 * @version 1.0
 */
public class JSONObjectTest extends TestCase {
    /**
     * Tests JSONObject creation and toString.
     */
    public void testJSONObject() {
        // Test empty JSONObject constructor
        JSONObject jo = new JSONObject();
        assertEquals("{}",jo.toString());
        assertFalse(jo.toString().equals("{}}"));

        // Test map parameter JSONObject constructor
        JSONTestClass joTestObject = new JSONTestClass("milk",5);
        HashMap<String, Object> map = new HashMap<>();
        map.put(joTestObject.name, joTestObject.amount);
        JSONObject jo1 = new JSONObject(map);
        assertEquals("{milk:5}",jo1.toString());
        assertFalse("{milk=5}".equals(jo1.toString()));
    }


     // Test class to imitate plain java objects.
    public static class JSONTestClass {
        String name;
        int amount;

        public JSONTestClass(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }
}
