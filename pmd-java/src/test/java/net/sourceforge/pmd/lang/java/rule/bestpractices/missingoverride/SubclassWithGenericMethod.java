/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.bestpractices.missingoverride;

public class SubclassWithGenericMethod extends AbstractClass {

    @Override
    public <T, R> R generic(final T t, final R r) {
        return super.generic(t, r);
    }
}
