/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.Assignment;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTAssignment extends AbstractInfixEcmascriptNode<Assignment> {
    @Deprecated
    @InternalApi
    public ASTAssignment(final Assignment asssignment) {
        super(asssignment);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
