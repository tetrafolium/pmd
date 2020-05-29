/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule;

import java.util.List;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.annotation.Experimental;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.JavaLanguageModule;
import net.sourceforge.pmd.lang.java.ast.ASTAdditiveExpression;
import net.sourceforge.pmd.lang.java.ast.ASTAllocationExpression;
import net.sourceforge.pmd.lang.java.ast.ASTAndExpression;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotationMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotationTypeBody;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotationTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTAnnotationTypeMemberDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTArgumentList;
import net.sourceforge.pmd.lang.java.ast.ASTArguments;
import net.sourceforge.pmd.lang.java.ast.ASTArrayDimsAndInits;
import net.sourceforge.pmd.lang.java.ast.ASTArrayInitializer;
import net.sourceforge.pmd.lang.java.ast.ASTAssertStatement;
import net.sourceforge.pmd.lang.java.ast.ASTAssignmentOperator;
import net.sourceforge.pmd.lang.java.ast.ASTBlock;
import net.sourceforge.pmd.lang.java.ast.ASTBlockStatement;
import net.sourceforge.pmd.lang.java.ast.ASTBooleanLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.java.ast.ASTCastExpression;
import net.sourceforge.pmd.lang.java.ast.ASTCatchStatement;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceBody;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceBodyDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.lang.java.ast.ASTCompilationUnit;
import net.sourceforge.pmd.lang.java.ast.ASTConditionalAndExpression;
import net.sourceforge.pmd.lang.java.ast.ASTConditionalExpression;
import net.sourceforge.pmd.lang.java.ast.ASTConditionalOrExpression;
import net.sourceforge.pmd.lang.java.ast.ASTConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTContinueStatement;
import net.sourceforge.pmd.lang.java.ast.ASTDefaultValue;
import net.sourceforge.pmd.lang.java.ast.ASTDoStatement;
import net.sourceforge.pmd.lang.java.ast.ASTEmptyStatement;
import net.sourceforge.pmd.lang.java.ast.ASTEnumBody;
import net.sourceforge.pmd.lang.java.ast.ASTEnumConstant;
import net.sourceforge.pmd.lang.java.ast.ASTEnumDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTEqualityExpression;
import net.sourceforge.pmd.lang.java.ast.ASTExclusiveOrExpression;
import net.sourceforge.pmd.lang.java.ast.ASTExplicitConstructorInvocation;
import net.sourceforge.pmd.lang.java.ast.ASTExpression;
import net.sourceforge.pmd.lang.java.ast.ASTExtendsList;
import net.sourceforge.pmd.lang.java.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTFinallyStatement;
import net.sourceforge.pmd.lang.java.ast.ASTForInit;
import net.sourceforge.pmd.lang.java.ast.ASTForStatement;
import net.sourceforge.pmd.lang.java.ast.ASTForUpdate;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameter;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameters;
import net.sourceforge.pmd.lang.java.ast.ASTIfStatement;
import net.sourceforge.pmd.lang.java.ast.ASTImplementsList;
import net.sourceforge.pmd.lang.java.ast.ASTImportDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTInclusiveOrExpression;
import net.sourceforge.pmd.lang.java.ast.ASTInitializer;
import net.sourceforge.pmd.lang.java.ast.ASTInstanceOfExpression;
import net.sourceforge.pmd.lang.java.ast.ASTLabeledStatement;
import net.sourceforge.pmd.lang.java.ast.ASTLambdaExpression;
import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTLocalVariableDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMarkerAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTMemberSelector;
import net.sourceforge.pmd.lang.java.ast.ASTMemberValue;
import net.sourceforge.pmd.lang.java.ast.ASTMemberValueArrayInitializer;
import net.sourceforge.pmd.lang.java.ast.ASTMemberValuePair;
import net.sourceforge.pmd.lang.java.ast.ASTMemberValuePairs;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclarator;
import net.sourceforge.pmd.lang.java.ast.ASTMethodReference;
import net.sourceforge.pmd.lang.java.ast.ASTModuleDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTModuleDirective;
import net.sourceforge.pmd.lang.java.ast.ASTModuleName;
import net.sourceforge.pmd.lang.java.ast.ASTMultiplicativeExpression;
import net.sourceforge.pmd.lang.java.ast.ASTName;
import net.sourceforge.pmd.lang.java.ast.ASTNameList;
import net.sourceforge.pmd.lang.java.ast.ASTNormalAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTNullLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTPackageDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTPostfixExpression;
import net.sourceforge.pmd.lang.java.ast.ASTPreDecrementExpression;
import net.sourceforge.pmd.lang.java.ast.ASTPreIncrementExpression;
import net.sourceforge.pmd.lang.java.ast.ASTPrimaryExpression;
import net.sourceforge.pmd.lang.java.ast.ASTPrimaryPrefix;
import net.sourceforge.pmd.lang.java.ast.ASTPrimarySuffix;
import net.sourceforge.pmd.lang.java.ast.ASTPrimitiveType;
import net.sourceforge.pmd.lang.java.ast.ASTRSIGNEDSHIFT;
import net.sourceforge.pmd.lang.java.ast.ASTRUNSIGNEDSHIFT;
import net.sourceforge.pmd.lang.java.ast.ASTRecordBody;
import net.sourceforge.pmd.lang.java.ast.ASTRecordComponent;
import net.sourceforge.pmd.lang.java.ast.ASTRecordComponentList;
import net.sourceforge.pmd.lang.java.ast.ASTRecordConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTRecordDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTReferenceType;
import net.sourceforge.pmd.lang.java.ast.ASTRelationalExpression;
import net.sourceforge.pmd.lang.java.ast.ASTResource;
import net.sourceforge.pmd.lang.java.ast.ASTResourceSpecification;
import net.sourceforge.pmd.lang.java.ast.ASTResources;
import net.sourceforge.pmd.lang.java.ast.ASTResultType;
import net.sourceforge.pmd.lang.java.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.java.ast.ASTShiftExpression;
import net.sourceforge.pmd.lang.java.ast.ASTSingleMemberAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTStatement;
import net.sourceforge.pmd.lang.java.ast.ASTStatementExpression;
import net.sourceforge.pmd.lang.java.ast.ASTStatementExpressionList;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchExpression;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchLabel;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchLabeledBlock;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchLabeledExpression;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchLabeledThrowStatement;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchStatement;
import net.sourceforge.pmd.lang.java.ast.ASTSynchronizedStatement;
import net.sourceforge.pmd.lang.java.ast.ASTThrowStatement;
import net.sourceforge.pmd.lang.java.ast.ASTTryStatement;
import net.sourceforge.pmd.lang.java.ast.ASTType;
import net.sourceforge.pmd.lang.java.ast.ASTTypeArgument;
import net.sourceforge.pmd.lang.java.ast.ASTTypeArguments;
import net.sourceforge.pmd.lang.java.ast.ASTTypeBound;
import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTTypeParameter;
import net.sourceforge.pmd.lang.java.ast.ASTTypeParameters;
import net.sourceforge.pmd.lang.java.ast.ASTTypeTestPattern;
import net.sourceforge.pmd.lang.java.ast.ASTUnaryExpression;
import net.sourceforge.pmd.lang.java.ast.ASTUnaryExpressionNotPlusMinus;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclarator;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import net.sourceforge.pmd.lang.java.ast.ASTVariableInitializer;
import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.ast.ASTWildcardBounds;
import net.sourceforge.pmd.lang.java.ast.ASTYieldStatement;
import net.sourceforge.pmd.lang.java.ast.JavaNode;
import net.sourceforge.pmd.lang.java.ast.JavaParserVisitor;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.rule.ImmutableLanguage;

public abstract class AbstractJavaRule extends AbstractRule implements JavaParserVisitor, ImmutableLanguage {

    public AbstractJavaRule() {
        super.setLanguage(LanguageRegistry.getLanguage(JavaLanguageModule.NAME));
        // Enable Type Resolution on Java Rules by default
        super.setTypeResolution(true);
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        visitAll(nodes, ctx);
    }

    protected void visitAll(final List<? extends Node> nodes, final RuleContext ctx) {
        for (Object element : nodes) {
            /*
                It is important to note that we are assuming that all nodes here are of type Compilation Unit,
                but our caller method may be called with any type of node, and that's why we need to check the kind
                of instance of each element
            */
            if (element instanceof ASTCompilationUnit) {
                ASTCompilationUnit node = (ASTCompilationUnit) element;
                visit(node, ctx);
            }
        }
    }

    /**
     * Gets the Image of the first parent node of type
     * ASTClassOrInterfaceDeclaration or <code>null</code>
     *
     * @param node
     *            the node which will be searched
     *
     * @deprecated This method just returns the type name as a string
     *     which doesn't leverage any type resolution. Use {@link Node#getFirstParentOfType(Class)}
     *     directly to find the node of type {@link ASTClassOrInterfaceBodyDeclaration} via the
     *     {@code getType} method.
     */
    @Deprecated
    protected final String getDeclaringType(final Node node) {
        ASTClassOrInterfaceDeclaration c = node.getFirstParentOfType(ASTClassOrInterfaceDeclaration.class);
        if (c != null) {
            return c.getImage();
        }
        return null;
    }

    public static boolean isQualifiedName(final Node node) {
        return node.getImage().indexOf('.') != -1;
    }

    public static boolean importsPackage(final ASTCompilationUnit node, final String packageName) {
        List<ASTImportDeclaration> nodes = node.findChildrenOfType(ASTImportDeclaration.class);
        for (ASTImportDeclaration n : nodes) {
            if (n.getPackageName().startsWith(packageName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @deprecated Not useful, and suppression should happen transparently to rule implementations.
     *             This will be removed with 7.0.0
     */
    @Deprecated
    protected boolean isSuppressed(final Node node) {
        return JavaRuleViolation.isSupressed(node, this);
    }

    //
    // The following APIs are identical to those in JavaParserVisitorAdapter.
    // Due to Java single inheritance, it preferred to extend from the more
    // complex Rule base class instead of from relatively simple Visitor.
    //
    @Override
    public Object visit(final JavaNode node, final Object data) {
        for (JavaNode child : node.children()) {
            child.jjtAccept(this, data);
        }
        return null;
    }

    @Override
    public Object visit(final ASTExtendsList node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassOrInterfaceDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTImplementsList node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeParameters node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMemberSelector node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeParameter node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeBound node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassOrInterfaceBody node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassOrInterfaceBodyDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTEnumBody node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTEnumConstant node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTReferenceType node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassOrInterfaceType node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeArguments node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeArgument node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTWildcardBounds node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAnnotation node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTNormalAnnotation node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMarkerAnnotation node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSingleMemberAnnotation node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMemberValuePairs node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMemberValuePair node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMemberValue node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMemberValueArrayInitializer node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAnnotationTypeDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAnnotationTypeBody node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAnnotationTypeMemberDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAnnotationMethodDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTDefaultValue node, final Object data) {
        return visit((JavaNode) node, data);
    }


    /**
     * @deprecated Will be removed in 7.0.0. Use {@link ASTShiftExpression#getOperator()}
     */
    @Override
    @Deprecated
    public Object visit(final ASTRUNSIGNEDSHIFT node, final Object data) {
        return visit((JavaNode) node, data);
    }


    /**
     * @deprecated Will be removed in 7.0.0. Use {@link ASTShiftExpression#getOperator()}
     */
    @Override
    @Deprecated
    public Object visit(final ASTRSIGNEDSHIFT node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTCompilationUnit node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTEnumDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAssertStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPackageDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTImportDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableDeclarator node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableDeclaratorId node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableInitializer node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTArrayInitializer node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMethodDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMethodDeclarator node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTFormalParameters node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTFormalParameter node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTConstructorDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTExplicitConstructorInvocation node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTInitializer node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTType node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimitiveType node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTResultType node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTName node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTNameList node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAssignmentOperator node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalOrExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalAndExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTInclusiveOrExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTExclusiveOrExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAndExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTEqualityExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTInstanceOfExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTRelationalExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTShiftExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAdditiveExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMultiplicativeExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTUnaryExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPreIncrementExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPreDecrementExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTUnaryExpressionNotPlusMinus node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPostfixExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTCastExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimaryExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimaryPrefix node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimarySuffix node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTLiteral node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTBooleanLiteral node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTNullLiteral node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTArguments node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTArgumentList node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTAllocationExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTArrayDimsAndInits node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTLabeledStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTBlock node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTBlockStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTLocalVariableDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTEmptyStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTStatementExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabel node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTIfStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTWhileStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTDoStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTForStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTForInit node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTStatementExpressionList node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTForUpdate node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTBreakStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTContinueStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTThrowStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSynchronizedStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTTryStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTFinallyStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTCatchStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTResourceSpecification node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTResources node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTResource node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTLambdaExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTMethodReference node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTModuleDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTModuleDirective node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTModuleName node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabeledBlock node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabeledExpression node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTSwitchLabeledThrowStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    public Object visit(final ASTYieldStatement node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTTypeTestPattern node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordComponentList node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordComponent node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordBody node, final Object data) {
        return visit((JavaNode) node, data);
    }

    @Override
    @Experimental
    public Object visit(final ASTRecordConstructorDeclaration node, final Object data) {
        return visit((JavaNode) node, data);
    }
}
