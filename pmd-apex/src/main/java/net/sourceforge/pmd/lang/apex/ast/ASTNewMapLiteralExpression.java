/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.NewMapLiteralExpression;

public class ASTNewMapLiteralExpression extends AbstractApexNode<NewMapLiteralExpression> {

    @Deprecated
    @InternalApi
    public ASTNewMapLiteralExpression(final NewMapLiteralExpression newMapLiteralExpression) {
        super(newMapLiteralExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
