/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.EmptyExpression;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTEmptyExpression extends AbstractEcmascriptNode<EmptyExpression> {
    @Deprecated
    @InternalApi
    public ASTEmptyExpression(final EmptyExpression emptyExpression) {
        super(emptyExpression);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
