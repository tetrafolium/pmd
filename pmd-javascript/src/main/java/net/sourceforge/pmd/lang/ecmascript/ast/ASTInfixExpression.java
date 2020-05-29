/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.InfixExpression;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTInfixExpression extends AbstractInfixEcmascriptNode<InfixExpression> {
    @Deprecated
    @InternalApi
    public ASTInfixExpression(final InfixExpression infixExpression) {
        super(infixExpression);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
