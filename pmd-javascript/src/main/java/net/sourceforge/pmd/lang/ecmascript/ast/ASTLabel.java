/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.Label;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTLabel extends AbstractEcmascriptNode<Label> {
    @Deprecated
    @InternalApi
    public ASTLabel(final Label label) {
        super(label);
        super.setImage(label.getName());
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
