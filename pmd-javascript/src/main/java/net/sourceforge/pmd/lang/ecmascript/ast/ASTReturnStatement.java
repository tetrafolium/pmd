/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.ReturnStatement;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTReturnStatement extends AbstractEcmascriptNode<ReturnStatement> {
    @Deprecated
    @InternalApi
    public ASTReturnStatement(final ReturnStatement returnStatement) {
        super(returnStatement);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public boolean hasResult() {
        return node.getReturnValue() != null;
    }
}
