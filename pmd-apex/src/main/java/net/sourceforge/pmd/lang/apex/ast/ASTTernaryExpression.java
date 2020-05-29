/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.TernaryExpression;

public class ASTTernaryExpression extends AbstractApexNode<TernaryExpression> {

    @Deprecated
    @InternalApi
    public ASTTernaryExpression(final TernaryExpression ternaryExpression) {
        super(ternaryExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
