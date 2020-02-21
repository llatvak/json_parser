package tuni.tiko.parser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Map;

/**
 * Unit test for JSONParser app.
 *
 * @author Lauri Latva-Kyyny
 * @version 1.0
 */
public class JSONParserTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JSONParserTest(String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( JSONParserTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }

    /**
     * Tests the JSONparser pojoToMap method
     */
    public void testPojoToMap() {
        ParserTestClass p = new ParserTestClass("banana", 5);
        Map<String,Object> map = new JSONParser().pojoToMap(p);
        assertEquals(map.toString(), p.toString());
        assertFalse(map.toString().equals("{" + p.toString() + "}"));
    }

    // Test class to imitate plain java objects.
    public static class ParserTestClass {
        private String name;
        private int amount;

        public ParserTestClass(String name, int amount) {
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
            // Puts key value and name to quotes
            return "{\"name\"=" + "\"" + name  + "\"" + ", \"amount\"=" +  amount + "}";
        }
    }
}
