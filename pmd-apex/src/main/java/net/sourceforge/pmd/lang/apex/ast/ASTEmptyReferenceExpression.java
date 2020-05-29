/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import apex.jorje.semantic.ast.expression.EmptyReferenceExpression;

public final class ASTEmptyReferenceExpression extends AbstractApexNode<EmptyReferenceExpression> {


    ASTEmptyReferenceExpression(final EmptyReferenceExpression node) {
        super(node);
    }


    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

}
