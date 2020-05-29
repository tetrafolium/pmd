/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.ArrayLoadExpression;

public class ASTArrayLoadExpression extends AbstractApexNode<ArrayLoadExpression> {

    @Deprecated
    @InternalApi
    public ASTArrayLoadExpression(final ArrayLoadExpression arrayLoadExpression) {
        super(arrayLoadExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
