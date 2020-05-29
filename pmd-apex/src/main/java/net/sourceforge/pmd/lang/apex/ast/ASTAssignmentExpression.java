/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.data.ast.AssignmentOp;
import apex.jorje.semantic.ast.expression.AssignmentExpression;

public class ASTAssignmentExpression extends AbstractApexNode<AssignmentExpression> {

    @Deprecated
    @InternalApi
    public ASTAssignmentExpression(final AssignmentExpression assignmentExpression) {
        super(assignmentExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public AssignmentOp getOperator() {
        return node.getOp();
    }
}
