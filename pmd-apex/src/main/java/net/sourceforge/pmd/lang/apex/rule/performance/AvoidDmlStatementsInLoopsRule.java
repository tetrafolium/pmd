/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.rule.performance;

import net.sourceforge.pmd.lang.apex.ast.ASTDmlDeleteStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlInsertStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlMergeStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUndeleteStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUpdateStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUpsertStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDoLoopStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTForEachStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTForLoopStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTWhileLoopStatement;
import net.sourceforge.pmd.lang.apex.rule.AbstractApexRule;
import net.sourceforge.pmd.lang.ast.AbstractNode;
import net.sourceforge.pmd.lang.ast.Node;

public class AvoidDmlStatementsInLoopsRule extends AbstractApexRule {

    public AvoidDmlStatementsInLoopsRule() {
        setProperty(CODECLIMATE_CATEGORIES, "Performance");
        // Note: Often more complicated as just moving the SOQL a few lines.
        // Involves Maps...
        setProperty(CODECLIMATE_REMEDIATION_MULTIPLIER, 150);
        setProperty(CODECLIMATE_BLOCK_HIGHLIGHTING, false);
    }

    @Override
    public Object visit(final ASTDmlDeleteStatement node, final Object data) {
        if (insideLoop(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(final ASTDmlInsertStatement node, final Object data) {
        if (insideLoop(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(final ASTDmlMergeStatement node, final Object data) {
        if (insideLoop(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(final ASTDmlUndeleteStatement node, final Object data) {
        if (insideLoop(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(final ASTDmlUpdateStatement node, final Object data) {
        if (insideLoop(node)) {
            addViolation(data, node);
        }
        return data;
    }

    @Override
    public Object visit(final ASTDmlUpsertStatement node, final Object data) {
        if (insideLoop(node)) {
            addViolation(data, node);
        }
        return data;
    }

    private boolean insideLoop(final AbstractNode node) {
        Node n = node.getParent();

        while (n != null) {
            if (n instanceof ASTDoLoopStatement || n instanceof ASTWhileLoopStatement
                    || n instanceof ASTForLoopStatement || n instanceof ASTForEachStatement) {
                return true;
            }
            n = n.getParent();
        }

        return false;
    }
}
