/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.EmptyStatement;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTEmptyStatement extends AbstractEcmascriptNode<EmptyStatement> {
    @Deprecated
    @InternalApi
    public ASTEmptyStatement(final EmptyStatement emptyStatement) {
        super(emptyStatement);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
