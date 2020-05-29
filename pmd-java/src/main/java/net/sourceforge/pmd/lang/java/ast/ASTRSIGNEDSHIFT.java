/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

/**
 * @deprecated Will be removed in 7.0.0. Use {@link ASTShiftExpression#getOperator()}
 */
@Deprecated
public class ASTRSIGNEDSHIFT extends AbstractJavaNode {

    @InternalApi
    @Deprecated
    public ASTRSIGNEDSHIFT(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTRSIGNEDSHIFT(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
