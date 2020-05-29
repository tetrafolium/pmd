/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.data.ast.PrefixOp;
import apex.jorje.semantic.ast.expression.PrefixExpression;

public class ASTPrefixExpression extends AbstractApexNode<PrefixExpression> {

    @Deprecated
    @InternalApi
    public ASTPrefixExpression(final PrefixExpression prefixExpression) {
        super(prefixExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }


    public PrefixOp getOperator() {
        return node.getOp();
    }
}
