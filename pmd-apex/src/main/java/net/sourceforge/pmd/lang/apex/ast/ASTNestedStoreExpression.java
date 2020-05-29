/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.NestedStoreExpression;

public class ASTNestedStoreExpression extends AbstractApexNode<NestedStoreExpression> {

    @Deprecated
    @InternalApi
    public ASTNestedStoreExpression(final NestedStoreExpression node) {
        super(node);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
