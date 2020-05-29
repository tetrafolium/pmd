/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.SoqlExpression;

public class ASTSoqlExpression extends AbstractApexNode<SoqlExpression> {

    @Deprecated
    @InternalApi
    public ASTSoqlExpression(final SoqlExpression soqlExpression) {
        super(soqlExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public String getQuery() {
        return node.getRawQuery();
    }

    public String getCanonicalQuery() {
        return node.getCanonicalQuery();
    }
}
