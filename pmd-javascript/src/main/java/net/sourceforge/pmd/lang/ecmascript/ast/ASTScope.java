/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.Scope;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTScope extends AbstractEcmascriptNode<Scope> {
    @Deprecated
    @InternalApi
    public ASTScope(final Scope scope) {
        super(scope);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
