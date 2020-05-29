/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.rule;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.RuleViolation;
import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.apex.ast.CanSuppressWarnings;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.ParametricRuleViolation;

/**
 * This is an Apex RuleViolation. It knows how to try to extract the following
 * extra information from the violation node:
 * <ul>
 * <li>Package name</li>
 * <li>Class name</li>
 * <li>Method name</li>
 * <li>Variable name</li>
 * <li>Suppression indicator</li>
 * </ul>
 * @param <T>
 *
 * @deprecated See {@link RuleViolation}
 */
@SuppressWarnings("PMD.UseUtilityClass") // we inherit non-static methods...
@Deprecated
@InternalApi
public class ApexRuleViolation<T> extends ParametricRuleViolation<Node> {

    public ApexRuleViolation(final Rule rule, final RuleContext ctx, final Node node, final String message, final int beginLine, final int endLine) {
        this(rule, ctx, node, message);

        setLines(beginLine, endLine);
    }

    public ApexRuleViolation(final Rule rule, final RuleContext ctx, final Node node, final String message) {
        super(rule, ctx, node, message);

        if (node != null) {
            if (!suppressed) {
                suppressed = isSupressed(node, getRule());
            }
        }
    }

    /**
     * Check for suppression on this node, on parents, and on contained types
     * for ASTCompilationUnit
     *
     * @deprecated Is internal API, not useful, there's a typo. See <a href="https://github.com/pmd/pmd/pull/1927">#1927</a>
     */
    @Deprecated
    public static boolean isSupressed(final Node node, final Rule rule) {
        boolean result = suppresses(node, rule);

        if (!result) {
            Node parent = node.getParent();
            while (!result && parent != null) {
                result = suppresses(parent, rule);
                parent = parent.getParent();
            }
        }

        return result;
    }

    private static boolean suppresses(final Node node, final Rule rule) {
        return node instanceof CanSuppressWarnings
                && ((CanSuppressWarnings) node).hasSuppressWarningsAnnotationFor(rule);
    }
}
