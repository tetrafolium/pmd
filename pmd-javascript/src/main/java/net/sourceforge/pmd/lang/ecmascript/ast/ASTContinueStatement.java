/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.ContinueStatement;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTContinueStatement extends AbstractEcmascriptNode<ContinueStatement> {
    @Deprecated
    @InternalApi
    public ASTContinueStatement(final ContinueStatement continueStatement) {
        super(continueStatement);
        super.setImage(continueStatement.getLabel() != null ? continueStatement.getLabel().getIdentifier() : null);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public boolean hasLabel() {
        return node.getLabel() != null;
    }

    public ASTName getLabel() {
        return (ASTName) getChild(0);
    }
}
