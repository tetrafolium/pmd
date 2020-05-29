/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.ArrayStoreExpression;

public class ASTArrayStoreExpression extends AbstractApexNode<ArrayStoreExpression> {

    @Deprecated
    @InternalApi
    public ASTArrayStoreExpression(final ArrayStoreExpression arrayStoreExpression) {
        super(arrayStoreExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
