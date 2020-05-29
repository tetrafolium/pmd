/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.ParenthesizedExpression;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTParenthesizedExpression extends AbstractEcmascriptNode<ParenthesizedExpression> {
    @Deprecated
    @InternalApi
    public ASTParenthesizedExpression(final ParenthesizedExpression parenthesizedExpression) {
        super(parenthesizedExpression);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
