/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.NewSetInitExpression;

public class ASTNewSetInitExpression extends AbstractApexNode<NewSetInitExpression> {

    @Deprecated
    @InternalApi
    public ASTNewSetInitExpression(final NewSetInitExpression newSetInitExpression) {
        super(newSetInitExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
