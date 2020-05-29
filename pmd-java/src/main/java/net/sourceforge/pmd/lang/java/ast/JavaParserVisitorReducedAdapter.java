/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Visitor adapter with convenient visit methods to e.g. treat contructors and methods the same.
 *
 * @author Clément Fournier
 */
public class JavaParserVisitorReducedAdapter extends JavaParserVisitorAdapter {

    @Override
    public Object visit(final ASTClassOrInterfaceDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    @Override
    public Object visit(final ASTAnnotationTypeDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    @Override
    public Object visit(final ASTEnumDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    @Override
    public Object visit(final ASTRecordDeclaration node, final Object data) {
        return visit((ASTAnyTypeDeclaration) node, data);
    }


    public Object visit(final ASTAnyTypeDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMethodDeclaration node, final Object data) {
        return visit((ASTMethodOrConstructorDeclaration) node, data);
    }


    @Override
    public Object visit(final ASTConstructorDeclaration node, final Object data) {
        return visit((ASTMethodOrConstructorDeclaration) node, data);
    }


    public Object visit(final ASTMethodOrConstructorDeclaration node, final Object data) {
        return visit((MethodLikeNode) node, data);
    }


    @Override
    public Object visit(final ASTLambdaExpression node, final Object data) {
        return visit((MethodLikeNode) node, data);
    }


    public Object visit(final MethodLikeNode node, final Object data) {
        return visit((JavaNode) node, data);
    }


}
