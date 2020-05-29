/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.typeresolution.testdata.dummytypes;

public class OverloadedMethods {

    public static boolean equals(final byte[] a, final byte[] b) {
        return false;
    }

    public static boolean equals(final Object[] a, final Object[] b) {
        return false;
    }
}
