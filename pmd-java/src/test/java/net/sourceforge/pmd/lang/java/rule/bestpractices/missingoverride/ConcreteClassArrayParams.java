/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.bestpractices.missingoverride;

public class ConcreteClassArrayParams extends AbstractClass {
    @Override
    Object fun(final String s) {
        return null;
    }


    @Override
    public void arrayParams(final String dflt, final int[] keys, final StringBuilder[] labels) {
        super.arrayParams(dflt, keys, labels);
    }
}
