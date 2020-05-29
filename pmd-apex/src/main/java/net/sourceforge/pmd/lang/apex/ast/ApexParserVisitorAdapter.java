/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

public class ApexParserVisitorAdapter implements ApexParserVisitor {

    /**
     * @deprecated Use {@link #visit(ApexNode, Object)}. That method
     *     also visits comments now.
     */
    @Deprecated
    @Override
    public Object visit(final AbstractApexNodeBase node, final Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(final ApexNode<?> node, final Object data) {
        for (ApexNode<?> child : node.children()) {
            child.jjtAccept(this, data);
        }
        return data;
    }

    @Override
    public Object visit(final ASTMethod node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUserClass node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTModifierNode node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTParameter node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUserClassMethods node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBridgeMethodCreator node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTLiteralExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTConstructorPreambleStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUserInterface node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUserEnum node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTWhileLoopStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTTryCatchFinallyBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTForLoopStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTIfElseBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTIfBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTForEachStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTField node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBreakStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTThrowStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDoLoopStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTTernaryExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSoqlExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBooleanExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTAnnotation node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTAnonymousClass node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTArrayLoadExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTArrayStoreExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTAssignmentExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBinaryExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTBindExpressions node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTCatchBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTClassRefExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTContinueStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDmlDeleteStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDmlInsertStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDmlMergeStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDmlUndeleteStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDmlUpdateStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTDmlUpsertStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTExpressionStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTFieldDeclarationStatements node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTInstanceOfExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTJavaMethodCallExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTJavaVariableExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTMapEntryNode node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTMethodCallExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTModifierOrAnnotation node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewListInitExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewListLiteralExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewMapInitExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewMapLiteralExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewObjectExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewSetInitExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewSetLiteralExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTPackageVersionExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTPostfixExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTPrefixExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTProperty node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTReferenceExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTRunAsBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSoslExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTStandardCondition node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSuperMethodCallExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSuperVariableExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTThisMethodCallExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTThisVariableExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTTriggerVariableExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUserExceptionMethods node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTUserTrigger node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTVariableDeclaration node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTVariableDeclarationStatements node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTVariableExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTAnnotationParameter node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTCastExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTConstructorPreamble node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTIllegalStoreExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTMethodBlockStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTModifier node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTMultiStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNestedExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNestedStoreExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTNewKeyValueObjectExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTStatementExecuted node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTFormalComment node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTSwitchStatement node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTElseWhenBlock node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTTypeWhenBlock node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTValueWhenBlock node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTIdentifierCase node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTLiteralCase node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

    @Override
    public Object visit(final ASTEmptyReferenceExpression node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }
}
