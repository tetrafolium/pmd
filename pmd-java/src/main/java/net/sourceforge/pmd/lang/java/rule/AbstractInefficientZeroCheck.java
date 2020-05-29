/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTEqualityExpression;
import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTPrimitiveType;
import net.sourceforge.pmd.lang.java.ast.ASTRelationalExpression;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import net.sourceforge.pmd.lang.java.symboltable.JavaNameOccurrence;
import net.sourceforge.pmd.lang.symboltable.NameOccurrence;

/**
 * This is an abstract rule for patterns which compare a method invocation to 0.
 * It could be further abstracted to find code that compares something to
 * another definable pattern
 *
 * @author acaplan
 */
public abstract class AbstractInefficientZeroCheck extends AbstractJavaRule {

    private static Map<String, String> inverse = new HashMap<>();

    public abstract boolean appliesToClassName(String name);

    public abstract boolean isTargetMethod(JavaNameOccurrence occ);

    /**
     * For each relation/equality operator, comparison targets need to define.
     *
     * @return map
     */
    public Map<String, List<String>> getComparisonTargets() {
        Map<String, List<String>> rules = new HashMap<>();
        rules.put("==", Arrays.asList("0"));
        rules.put("!=", Arrays.asList("0"));
        rules.put(">", Arrays.asList("0"));
        rules.put("<", Arrays.asList("0"));
        return rules;
    }

    static {
        inverse.put("<", ">");
        inverse.put(">", "<");
        inverse.put("<=", ">=");
        inverse.put(">=", "<=");
        inverse.put("==", "==");
        inverse.put("!=", "!=");
    }

    @Override
    public Object visit(final ASTVariableDeclaratorId node, final Object data) {
        Node nameNode = node.getTypeNameNode();
        if (nameNode == null || nameNode instanceof ASTPrimitiveType
                || node.getNameDeclaration() == null
                || !appliesToClassName(node.getNameDeclaration().getTypeImage())) {
            return data;
        }

        List<NameOccurrence> declars = node.getUsages();
        for (NameOccurrence occ : declars) {
            JavaNameOccurrence jocc = (JavaNameOccurrence) occ;
            if (!isTargetMethod(jocc)) {
                continue;
            }
            Node expr = jocc.getLocation().getParent().getParent().getParent();
            checkNodeAndReport(data, jocc.getLocation(), expr);
        }
        return data;
    }

    /**
     * Checks whether the given expression is a equality/relation expression
     * that compares with a size() call.
     *
     * @param data
     *            the rule context
     * @param location
     *            the node location to report
     * @param expr
     *            the ==, &lt;, &gt; expression
     */
    protected void checkNodeAndReport(final Object data, final Node location, final Node expr) {
        if ((expr instanceof ASTEqualityExpression
                || expr instanceof ASTRelationalExpression && getComparisonTargets().containsKey(expr.getImage()))
                && isCompare(expr)) {
            addViolation(data, location);
        }
    }

    /**
     * We only need to report if this is comparing against one of the comparison
     * targets
     *
     * @param equality
     * @return true if this is comparing to one of the comparison targets else
     *         false
     * @see #getComparisonTargets()
     */
    private boolean isCompare(final Node equality) {
        if (isLiteralLeftHand(equality)) {
            return checkComparison(inverse.get(equality.getImage()), equality, 0);
        } else if (isLiteralRightHand(equality)) {
            return checkComparison(equality.getImage(), equality, 1);
        }
        return false;
    }

    private boolean isLiteralLeftHand(final Node equality) {
        return isLiteral(equality, 0);
    }

    private boolean isLiteralRightHand(final Node equality) {
        return isLiteral(equality, 1);
    }

    private boolean isLiteral(final Node equality, final int child) {
        Node target = equality.getChild(child);
        target = getFirstChildOrThis(target);
        target = getFirstChildOrThis(target);
        return target instanceof ASTLiteral;
    }

    private Node getFirstChildOrThis(final Node node) {
        if (node.getNumChildren() > 0) {
            return node.getChild(0);
        }
        return node;
    }

    /**
     * Checks if the equality expression passed in is of comparing against the
     * value passed in as i
     *
     * @param equality
     * @param i
     *            The ordinal in the equality expression to check
     * @return true if the value in position i is one of the comparison targets,
     *         else false
     * @see #getComparisonTargets()
     */
    private boolean checkComparison(final String operator, final Node equality, final int i) {
        Node target = equality.getChild(i).getChild(0).getChild(0);
        return target instanceof ASTLiteral && getComparisonTargets().get(operator).contains(target.getImage());
    }

}
