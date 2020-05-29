/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.Experimental;

/**
 * External wrapper for a visitor decorator. This one drives the AST visit, delegating to the base controlless visitor
 * given in the constructor. Add decorators using the {@link #decorateWith(JavaParserVisitorDecorator)}.
 *
 * <p>Important! This modified decorator pattern compels you to use the data object as the accumulator for your result!
 * The {@code visit} methods or your decorators and base visitors must only perform side effects on this object, their
 * return values will be ignored.
 *
 * @author Clément Fournier
 * @since 6.0.0
 *
 * @deprecated Visitor decorators are deprecated because they lead to fragile code.
 */
@Deprecated
public class JavaParserDecoratedVisitor implements JavaParserVisitor {


    private JavaParserControllessVisitor visitor;


    /**
     * Creates a decorated visitor using the parameter as the base visitor. Add decorators using the {@link
     * #decorateWith(JavaParserVisitorDecorator)} method.
     *
     * @param baseVisitor The base visitor
     */
    public JavaParserDecoratedVisitor(final JavaParserControllessVisitor baseVisitor) {
        this.visitor = baseVisitor;
    }


    /**
     * Adds a decorator to this decorated visitor.
     *
     * @param decorator The decorator to add
     */
    public void decorateWith(final JavaParserVisitorDecorator decorator) {
        decorator.setBase(visitor);
        visitor = decorator;
    }


    @Override
    public Object visit(final JavaNode node, final Object data) {
        return node.childrenAccept(this, data);
    }


    @Override
    public Object visit(final ASTExtendsList node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTClassOrInterfaceDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTImplementsList node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTypeParameters node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMemberSelector node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTypeParameter node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTypeBound node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTClassOrInterfaceBody node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTClassOrInterfaceBodyDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTEnumBody node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTEnumConstant node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTReferenceType node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTClassOrInterfaceType node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTypeArguments node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTypeArgument node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTWildcardBounds node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAnnotation node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTNormalAnnotation node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMarkerAnnotation node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTSingleMemberAnnotation node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMemberValuePairs node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMemberValuePair node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMemberValue node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMemberValueArrayInitializer node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAnnotationTypeDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAnnotationTypeBody node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAnnotationTypeMemberDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAnnotationMethodDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTDefaultValue node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    /**
     * @deprecated Will be removed in 7.0.0. Use {@link ASTShiftExpression#getOperator()}
     */
    @Override
    @Deprecated
    public Object visit(final ASTRUNSIGNEDSHIFT node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    /**
     * @deprecated Will be removed in 7.0.0. Use {@link ASTShiftExpression#getOperator()}
     */
    @Override
    @Deprecated
    public Object visit(final ASTRSIGNEDSHIFT node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTCompilationUnit node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTEnumDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAssertStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPackageDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTImportDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTypeDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTVariableDeclarator node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTVariableDeclaratorId node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTVariableInitializer node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTArrayInitializer node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMethodDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMethodDeclarator node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTFormalParameters node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTFormalParameter node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTConstructorDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTExplicitConstructorInvocation node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTInitializer node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTType node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPrimitiveType node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTResultType node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTName node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTNameList node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAssignmentOperator node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTConditionalExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTConditionalOrExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTConditionalAndExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTInclusiveOrExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTExclusiveOrExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAndExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTEqualityExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTInstanceOfExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTRelationalExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTShiftExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAdditiveExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMultiplicativeExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTUnaryExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPreIncrementExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPreDecrementExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTUnaryExpressionNotPlusMinus node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPostfixExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTCastExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPrimaryExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPrimaryPrefix node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTPrimarySuffix node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTLiteral node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTBooleanLiteral node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTNullLiteral node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTArguments node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTArgumentList node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTAllocationExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTArrayDimsAndInits node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTLabeledStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTBlock node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTBlockStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTLocalVariableDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTEmptyStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTStatementExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTSwitchStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTSwitchLabel node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTIfStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTWhileStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTDoStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTForStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTForInit node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTStatementExpressionList node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTForUpdate node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTBreakStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTContinueStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTThrowStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTSynchronizedStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTTryStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTResourceSpecification node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTResources node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTResource node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTFinallyStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTCatchStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTLambdaExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTMethodReference node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }


    @Override
    public Object visit(final ASTModuleDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTModuleDirective node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTModuleName node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabeledBlock node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabeledExpression node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabeledThrowStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTYieldStatement node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTTypeTestPattern node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordComponentList node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordComponent node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordBody node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordConstructorDeclaration node, final Object data) {
        visitor.visit(node, data);
        return visit((JavaNode) node, data);
    }
}
