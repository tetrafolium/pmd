/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.xpath;

import net.sourceforge.pmd.annotation.InternalApi;


@InternalApi
@Deprecated
public final class PMDFunctions {
    private PMDFunctions() { }

    public static boolean matches(final String s, final String pattern1) {
        return MatchesFunction.matches(s, pattern1);
    }

    public static boolean matches(final String s, final String pattern1, final String pattern2) {
        return MatchesFunction.matches(s, pattern1, pattern2);
    }

    public static boolean matches(final String s, final String pattern1, final String pattern2, final String pattern3) {
        return MatchesFunction.matches(s, pattern1, pattern2, pattern3);
    }

    public static boolean matches(final String s, final String pattern1, final String pattern2, final String pattern3, final String pattern4) {
        return MatchesFunction.matches(s, pattern1, pattern2, pattern3, pattern4);
    }

    public static boolean matches(final String s, final String pattern1, final String pattern2, final String pattern3, final String pattern4,
            final String pattern5) {
        return MatchesFunction.matches(s, pattern1, pattern2, pattern3, pattern4, pattern5);
    }

    public static boolean matches(final String s, final String pattern1, final String pattern2, final String pattern3, final String pattern4,
            final String pattern5, final String pattern6) {
        return MatchesFunction.matches(s, pattern1, pattern2, pattern3, pattern4, pattern5, pattern6);
    }
}
