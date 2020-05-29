/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.ThrowStatement;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTThrowStatement extends AbstractEcmascriptNode<ThrowStatement> {
    @Deprecated
    @InternalApi
    public ASTThrowStatement(final ThrowStatement throwStatement) {
        super(throwStatement);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
