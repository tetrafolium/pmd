/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.typeresolution.testdata;

public class MethodThirdPhase {
    void test() {
        // more args than parameters
        Exception a = vararg(10, (Number) null, (Number) null);

        // less args than parameters
        Exception b = vararg(10);

        // component type determined properly
        int c = vararg(10, "", "", "");

        // most specific vararg method
        String d = mostSpecific(10, 10, 10);
    }

    Exception mostSpecific(final Number... b) {
        return null;
    }

    String mostSpecific(final Integer... b) {
        return null;
    }

    Exception vararg(final int a, final Number... b) {
        return null;
    }

    int vararg(final int a, final String c, final String... b) {
        return 0;
    }
}
