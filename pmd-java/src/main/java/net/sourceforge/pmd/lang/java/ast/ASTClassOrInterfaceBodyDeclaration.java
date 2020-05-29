/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.annotation.InternalApi;

public class ASTClassOrInterfaceBodyDeclaration extends AbstractTypeBodyDeclaration implements CanSuppressWarnings, ASTAnyTypeBodyDeclaration {

    @InternalApi
    @Deprecated
    public ASTClassOrInterfaceBodyDeclaration(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTClassOrInterfaceBodyDeclaration(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public boolean isFindBoundary() {
        return isAnonymousInnerClass();
    }

    @Override
    public boolean hasSuppressWarningsAnnotationFor(final Rule rule) {
        for (int i = 0; i < getNumChildren(); i++) {
            if (getChild(i) instanceof ASTAnnotation) {
                ASTAnnotation a = (ASTAnnotation) getChild(i);
                if (a.suppresses(rule)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public boolean isAnonymousInnerClass() {
        return getParent().getParent() instanceof ASTAllocationExpression;
    }

    public boolean isEnumChild() {
        return getParent().getParent() instanceof ASTEnumConstant;
    }
}
