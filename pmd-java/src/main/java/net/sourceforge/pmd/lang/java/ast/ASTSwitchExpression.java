/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTSwitchExpression extends AbstractJavaTypeNode {

    @Deprecated
    @InternalApi
    ASTSwitchExpression(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    ASTSwitchExpression(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
