/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.multifile.testdata;

import org.apache.commons.lang3.StringUtils;

// Fields:
// 2 private static final
// 3 public
// 1 protected

// Constructors:
// 3 public

// Getters/ Setters:
// 4 public
// 4 package

// Static:
// 2 private
// 2 public

// Methods:
// 1 public
// 1 private
// 2 protected
// 2 protected final
public abstract class SignatureCountTestData {

    private static final int MAX_X = 0;
    private static final int MIN_X = 0;
    public int x;
    public int y;
    public int z;
    protected int t;


    public SignatureCountTestData(final int x, final int y, final int z, final int t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }


    public SignatureCountTestData(final int x, final int y, final int z) { }


    public SignatureCountTestData(final int x, final int y) { }


    public int getX() {
        return x;
    }


    void setX(final int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    void setY(final int y) {
        this.y = y;
    }


    public int getZ() {
        return z;
    }


    void setZ(final int z) {
        this.z = z;
    }


    public int getT() {
        return t;
    }


    void setT(final int t) {
        this.t = t;
    }


    public boolean isNotEmpty(final String value) {
        return !isEmpty(value);
    }


    private boolean isEmpty(final String value) {
        return StringUtils.isBlank(value);
    }


    protected boolean isMissing(final String value) {
        return StringUtils.isEmpty(value);
    }


    protected boolean areSemanticEquals(final String a, final String b) {
        return a.equals(b);
    }


    protected abstract String replaceString(String original, String oldString, String newString);


    @Deprecated
    protected abstract void appendXmlEscaped(StringBuilder buf, String src);


    public static boolean startsWithAny(final String text, final String... prefixes) {
        return false;
    }


    public static boolean isAnyOf(final String text, final String... tests) {
        return false;
    }


    private static String withoutPrefixes(final String text, final String... prefixes) {
        return text;
    }


    private static void appendXmlEscaped(final StringBuilder buf, final String src, final boolean supportUTF8) {
    }


}
