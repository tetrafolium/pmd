/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.NewKeyValueObjectExpression;

public class ASTNewKeyValueObjectExpression extends AbstractApexNode<NewKeyValueObjectExpression> {

    @Deprecated
    @InternalApi
    public ASTNewKeyValueObjectExpression(final NewKeyValueObjectExpression node) {
        super(node);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public String getType() {
        return node.getTypeRef().getNames().get(0).getValue();
    }

    public int getParameterCount() {
        return node.getParameters().size();
    }
}
