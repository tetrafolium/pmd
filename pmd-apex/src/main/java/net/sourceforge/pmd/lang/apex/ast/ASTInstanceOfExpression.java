/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.InstanceOfExpression;

public class ASTInstanceOfExpression extends AbstractApexNode<InstanceOfExpression> {

    @Deprecated
    @InternalApi
    public ASTInstanceOfExpression(final InstanceOfExpression instanceOfExpression) {
        super(instanceOfExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
