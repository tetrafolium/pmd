/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

public class JspParserVisitorAdapter implements JspParserVisitor {

    @Override
    public Object visit(final JspNode node, final Object data) {
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(final ASTCompilationUnit node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTContent node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspDirective node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspDirectiveAttribute node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspScriptlet node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspExpression node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspDeclaration node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspComment node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTText node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTUnparsedText node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTElExpression node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTValueBinding node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTCData node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTElement node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTAttribute node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTAttributeValue node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTJspExpressionInAttribute node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTCommentTag node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTDeclaration node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTDoctypeDeclaration node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTDoctypeExternalId node, final Object data) {
        return visit((JspNode) node, data);
    }

    @Override
    public Object visit(final ASTHtmlScript node, final Object data) {
        return visit((JspNode) node, data);
    }
}
