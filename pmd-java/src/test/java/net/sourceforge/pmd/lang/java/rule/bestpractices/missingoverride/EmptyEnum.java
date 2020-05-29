/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.bestpractices.missingoverride;

public enum EmptyEnum {
;  // SUPPRESS CHECKSTYLE now

    public static void main(final String... args) {
        method();
    }

    public static void method(final int... a) {
        System.out.println("1");
    }

    @SuppressWarnings("PMD.AvoidUsingShortType")
    public static void method(final short... b) {
        System.out.println("2");
    }
}
