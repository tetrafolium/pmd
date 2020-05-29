/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.vf.ast;

public class VfParserVisitorAdapter implements VfParserVisitor {

    @Override
    public Object visit(final VfNode node, final Object data) {
        node.childrenAccept(this, data);
        return data;
    }

    @Override
    public Object visit(final ASTCompilationUnit node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTText node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTElExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTCData node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTElement node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTAttribute node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTAttributeValue node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDeclaration node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDoctypeDeclaration node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDoctypeExternalId node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTHtmlScript node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTLiteral node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTIdentifier node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTArguments node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDotExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTContent node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTNegationExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

}
