/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.bestpractices.missingoverride;

/**
 * @author Clément Fournier
 * @since 6.2.0
 */
public abstract class AbstractClass {

    Object fun(final String s) {
        return new Object();
    }


    public void arrayParams(final String dflt, final int[] keys, final StringBuilder[] labels) {
    }


    public <T, R> R generic(final T t, final R r) {
        return r;
    }

}
