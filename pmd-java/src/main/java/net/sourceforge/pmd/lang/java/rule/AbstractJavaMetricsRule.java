/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule;

import net.sourceforge.pmd.lang.java.ast.ASTAnnotationTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTAnyTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTEnumDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTLambdaExpression;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodOrConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.ast.MethodLikeNode;


/**
 * Java Rule with convenient visit methods to e.g. treat contructors and methods the same.
 *
 * @author Clément Fournier
 */
public abstract class AbstractJavaMetricsRule extends AbstractJavaRule {

    @Override
    public final Object visit(final ASTClassOrInterfaceDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    @Override
    public final Object visit(final ASTAnnotationTypeDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    @Override
    public final Object visit(final ASTEnumDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    public Object visit(final ASTAnyTypeDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }


    @Override
    public final Object visit(final ASTMethodDeclaration node, final Object data) {
        return visit((ASTMethodOrConstructorDeclaration) node, data);
    }


    @Override
    public final Object visit(final ASTConstructorDeclaration node, final Object data) {
        return visit((ASTMethodOrConstructorDeclaration) node, data);
    }

    @Override
    public final Object visit(final ASTLambdaExpression node, final Object data) {
        return visit((MethodLikeNode) node, data);
    }


    public Object visit(final ASTMethodOrConstructorDeclaration node, final Object data) {
        return visit((MethodLikeNode) node, data);
    }


    public Object visit(final MethodLikeNode node, final Object data) {
        return visit((JavaNode) node, data);
    }

}
