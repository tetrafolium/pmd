/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.typeresolution.testdata;

import java.util.Comparator;

public class AnonymousClassFromInterface {

    public Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(final Integer o1, final Integer o2) {
            return 0;
        }
    };
}
