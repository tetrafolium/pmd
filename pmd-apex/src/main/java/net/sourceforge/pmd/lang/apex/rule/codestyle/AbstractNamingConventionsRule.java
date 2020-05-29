/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.rule.codestyle;

import static net.sourceforge.pmd.properties.PropertyFactory.regexProperty;

import java.util.Map;
import java.util.regex.Pattern;

import net.sourceforge.pmd.lang.apex.ast.ApexNode;
import net.sourceforge.pmd.lang.apex.rule.AbstractApexRule;
import net.sourceforge.pmd.properties.PropertyBuilder;
import net.sourceforge.pmd.properties.PropertyDescriptor;

abstract class AbstractNamingConventionsRule extends AbstractApexRule {
    protected static final Pattern CAMEL_CASE = Pattern.compile("[a-z][a-zA-Z0-9]*");
    protected static final Pattern CAMEL_CASE_WITH_UNDERSCORES = Pattern.compile("[a-z][a-zA-Z0-9_]*");
    protected static final Pattern PASCAL_CASE_WITH_UNDERSCORES = Pattern.compile("[A-Z][a-zA-Z0-9_]*");
    protected static final Pattern ALL_CAPS = Pattern.compile("[A-Z][A-Z0-9_]*");

    abstract String displayName(String name);

    protected void checkMatches(final PropertyDescriptor<Pattern> propertyDescriptor, final ApexNode<?> node, final Object data) {
        checkMatches(propertyDescriptor, getProperty(propertyDescriptor), node, data);
    }

    protected void checkMatches(final PropertyDescriptor<Pattern> propertyDescriptor, final Pattern overridePattern, final ApexNode<?> node, final Object data) {
        String name = node.getImage();
        if (!overridePattern.matcher(name).matches()) {
            String displayName = displayName(propertyDescriptor.name());
            addViolation(data, node, new Object[] {displayName, name, overridePattern.toString() });
        }
    }

    protected static PropertyBuilder.RegexPropertyBuilder prop(final String name, final String displayName, final Map<String, String> descriptorToDisplayNames) {
        descriptorToDisplayNames.put(name, displayName);
        return regexProperty(name).desc("Regex which applies to " + displayName + " names");
    }
}
