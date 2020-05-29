/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.viewer.model;

import net.sourceforge.pmd.lang.ast.xpath.Attribute;

/**
 * A toolkit for vaious attribute translations
 *
 * @author Boris Gruschko ( boris at gruschko.org )
 * @version $Id$
 */
@Deprecated // to be removed with PMD 7.0.0
public final class AttributeToolkit {

    private AttributeToolkit() { }

    /**
     * formats a value for its usage in XPath expressions
     *
     * @param attribute
     *            atribute which value should be formatted
     * @return formmated value
     */
    public static String formatValueForXPath(final Attribute attribute) {
        return '\'' + attribute.getStringValue() + '\'';
    }

    /**
     * constructs a predicate from the given attribute
     *
     * @param attribute
     *            attribute to be formatted as predicate
     * @return predicate
     */
    public static String constructPredicate(final Attribute attribute) {
        return "[@" + attribute.getName() + '=' + formatValueForXPath(attribute) + ']';
    }
}
