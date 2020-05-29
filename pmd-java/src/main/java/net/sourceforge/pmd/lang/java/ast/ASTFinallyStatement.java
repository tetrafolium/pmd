/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTFinallyStatement extends AbstractJavaNode {

    @InternalApi
    @Deprecated
    public ASTFinallyStatement(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTFinallyStatement(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }


    /**
     * Returns the body of this finally clause.
     */
    public ASTBlock getBody() {
        return (ASTBlock) getChild(0);
    }
}
