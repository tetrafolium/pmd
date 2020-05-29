/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import java.util.Collection;
import java.util.List;

import net.sourceforge.pmd.lang.java.typeresolution.TypeHelper;

// package private
abstract class AbstractJavaAnnotatableNode extends AbstractJavaNode implements Annotatable {

    AbstractJavaAnnotatableNode(final int i) {
        super(i);
    }

    AbstractJavaAnnotatableNode(final JavaParser parser, final int i) {
        super(parser, i);
    }

    @Override
    public List<ASTAnnotation> getDeclaredAnnotations() {
        return this.getParent().findChildrenOfType(ASTAnnotation.class);
    }

    @Override
    public ASTAnnotation getAnnotation(final String annotQualifiedName) {
        List<ASTAnnotation> annotations = getDeclaredAnnotations();
        for (ASTAnnotation annotation : annotations) {
            ASTName name = annotation.getFirstDescendantOfType(ASTName.class);
            if (name != null && TypeHelper.isA(name, annotQualifiedName)) {
                return annotation;
            }
        }
        return null;
    }

    @Override
    public boolean isAnnotationPresent(final String annotQualifiedName) {
        return getAnnotation(annotQualifiedName) != null;
    }

    @Override
    public boolean isAnyAnnotationPresent(final Collection<String> annotQualifiedNames) {
        for (String annotQualifiedName : annotQualifiedNames) {
            if (isAnnotationPresent(annotQualifiedName)) {
                return true;
            }
        }
        return false;
    }
}
