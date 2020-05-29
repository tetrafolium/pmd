/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTModuleName extends AbstractJavaNode {

    @InternalApi
    @Deprecated
    public ASTModuleName(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTModuleName(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
