package tuni.tiko.parser;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

/**
 * Tests for JSONArray.
 *
 * @author Lauri Latva-Kyyny
 * @version 1.0
 */
public class JSONArrayTest extends TestCase {

    /**
     * Tests creation of JSONArray.
     */
    public void testJSONArray() {
        JSONArray ja = new JSONArray();
        assertEquals(ja.toString(), "[]");
        assertFalse(ja.toString().equals("[[]]"));
    }

    /**
     * Tests JSONArray add method.
     */
    public void testJSONArrayAdd() {
        JSONArrayTestClass test = new JSONArrayTestClass("banana", 5);
        Map<String, Object> map = new JSONParser().pojoToMap(test);
        JSONArray ja1 = new JSONArray();
        ja1.add(map);
        assertEquals(ja1.toString(), "[" + test.toString() +"]");
        assertFalse(ja1.toString().equals("{" + test.toString() + "}"));
    }

    /**
     * Tests JSONArray writeToFile method.
     */
    public void testWriteToFile() {
        JSONArrayTestClass test1 = new JSONArrayTestClass("banana", 5);
        Map<String, Object> map1 = new JSONParser().pojoToMap(test1);
        JSONArray ja2 = new JSONArray();
        ja2.add(map1);
        File file = new File("testfile.txt");
        ja2.writeToFile(file);
        String allLines = "";
        if(file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    allLines += line;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        assertEquals(ja2.toString(), allLines);
        assertFalse(ja2.toString().equals("[" + allLines + "]"));
    }

    // Test class to imitate plain java objects.
    public static class JSONArrayTestClass {
        private String name;
        private int amount;

        public JSONArrayTestClass(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "{\"name\":" + "\"" + name  + "\"" + ", \"amount\":" +  amount + "}";
        }
    }
}
