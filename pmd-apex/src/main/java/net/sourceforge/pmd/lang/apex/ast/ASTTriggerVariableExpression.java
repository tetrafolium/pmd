/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.TriggerVariableExpression;

public class ASTTriggerVariableExpression extends AbstractApexNode<TriggerVariableExpression> {

    @Deprecated
    @InternalApi
    public ASTTriggerVariableExpression(final TriggerVariableExpression triggerVariableExpression) {
        super(triggerVariableExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
