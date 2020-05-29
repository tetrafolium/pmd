/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.typeresolution.testdata;

public class MethodSecondPhase {
    void test() {
        // boxing and widening conversion
        String a = boxing(10, "");
        // boxing
        Exception b = boxing('a', "");
        // boxing and most specific
        int c = boxing(10L, "");

        // unboxing and widening conversion
        String d = unboxing("", (Integer) null);

        Exception e = unboxing("", (Character) null);
        int f = unboxing("", (Byte) null);
    }

    String boxing(final Number a, final String b) {
        return null;
    }

    Exception boxing(final Character a, final String b) {
        return null;
    }

    int boxing(final Long a, final String b) {
        return 0;
    }

    String unboxing(final String b, final long a) {
        return null;
    }

    Exception unboxing(final String b, final char a) {
        return null;
    }

    int unboxing(final String b, final short a) {
        return 0;
    }
}
