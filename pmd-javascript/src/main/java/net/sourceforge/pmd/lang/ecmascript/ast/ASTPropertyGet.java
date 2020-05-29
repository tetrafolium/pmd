/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.PropertyGet;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTPropertyGet extends AbstractInfixEcmascriptNode<PropertyGet> {
    @Deprecated
    @InternalApi
    public ASTPropertyGet(final PropertyGet propertyGet) {
        super(propertyGet, false);
        super.setImage(".");
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
