/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.Comment;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTComment extends AbstractEcmascriptNode<Comment> {
    @Deprecated
    @InternalApi
    public ASTComment(final Comment comment) {
        super(comment);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public String getValue() {
        return node.getValue();
    }
}
