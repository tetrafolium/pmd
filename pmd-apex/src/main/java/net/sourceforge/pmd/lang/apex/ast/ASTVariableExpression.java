/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.VariableExpression;

public class ASTVariableExpression extends AbstractApexNode<VariableExpression> {

    @Deprecated
    @InternalApi
    public ASTVariableExpression(final VariableExpression variableExpression) {
        super(variableExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public String getImage() {
        if (node.getIdentifier() != null) {
            return node.getIdentifier().getValue();
        }
        return null;
    }
}
