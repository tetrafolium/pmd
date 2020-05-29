/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTCastExpression extends AbstractJavaTypeNode {

    private boolean intersectionTypes = false;

    @InternalApi
    @Deprecated
    public ASTCastExpression(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTCastExpression(final JavaParser p, final int id) {
        super(p, id);
    }

    @InternalApi
    @Deprecated
    public void setIntersectionTypes(final boolean intersectionTypes) {
        this.intersectionTypes = intersectionTypes;
    }

    public boolean hasIntersectionTypes() {
        return intersectionTypes;
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
