/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.multifile.testdata;

/**
 * Test data for the metrics visitor
 *
 * @author Clément Fournier
 */
public class MultifileVisitorTestData2 {

    public String x;
    private String y;
    protected String z;
    String t;

    public MultifileVisitorTestData2() {

    }

    private MultifileVisitorTestData2(final String x) {

    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public void setX(final String n) {
        x = n;
    }

    public void setY(final String n) {
        y = n;
    }


    public static class NestedClass {

        public NestedClass() {

        }

        public void nestedMethod1() {

        }
    }

    public void mymethod1() {

    }

    private void mymethod2() {

    }

    protected static void mystatic1() {

    }

    private static void mystatic2(final String k) {

    }

    private static void mystatic2(final String k, final String l) {

    }

}
