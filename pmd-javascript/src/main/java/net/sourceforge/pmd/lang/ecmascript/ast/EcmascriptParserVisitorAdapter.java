/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

public class EcmascriptParserVisitorAdapter implements EcmascriptParserVisitor {

    @Override
    public Object visit(final EcmascriptNode<?> node, final Object data) {
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(final ASTArrayComprehension node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTArrayComprehensionLoop node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTArrayLiteral node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTAssignment node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTAstRoot node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBlock node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBreakStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTCatchClause node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTComment node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTConditionalExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTContinueStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDoLoop node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTElementGet node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTEmptyExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTExpressionStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTForInLoop node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTForLoop node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTFunctionCall node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTFunctionNode node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTIfStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTInfixExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTKeywordLiteral node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTLabel node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTLabeledStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTLetNode node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTName node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNumberLiteral node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTObjectLiteral node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTObjectProperty node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTParenthesizedExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTPropertyGet node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTRegExpLiteral node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTScope node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTStringLiteral node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSwitchCase node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSwitchStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTThrowStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTTryStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUnaryExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTVariableDeclaration node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTVariableInitializer node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTWhileLoop node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTWithStatement node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTXmlDotQuery node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTXmlExpression node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTXmlMemberGet node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTXmlString node, final Object data) {
        return visit((EcmascriptNode<?>) node, data);
    }
}
