/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.rule;

import java.util.List;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ParserOptions;
import net.sourceforge.pmd.lang.apex.ApexLanguageModule;
import net.sourceforge.pmd.lang.apex.ApexParserOptions;
import net.sourceforge.pmd.lang.apex.ast.ASTAnnotation;
import net.sourceforge.pmd.lang.apex.ast.ASTAnnotationParameter;
import net.sourceforge.pmd.lang.apex.ast.ASTAnonymousClass;
import net.sourceforge.pmd.lang.apex.ast.ASTArrayLoadExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTArrayStoreExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTAssignmentExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTBinaryExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTBindExpressions;
import net.sourceforge.pmd.lang.apex.ast.ASTBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTBooleanExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTBridgeMethodCreator;
import net.sourceforge.pmd.lang.apex.ast.ASTCastExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTCatchBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTClassRefExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTConstructorPreamble;
import net.sourceforge.pmd.lang.apex.ast.ASTConstructorPreambleStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTContinueStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlDeleteStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlInsertStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlMergeStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUndeleteStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUpdateStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDmlUpsertStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTDoLoopStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTElseWhenBlock;
import net.sourceforge.pmd.lang.apex.ast.ASTEmptyReferenceExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTExpressionStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTField;
import net.sourceforge.pmd.lang.apex.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.apex.ast.ASTFieldDeclarationStatements;
import net.sourceforge.pmd.lang.apex.ast.ASTForEachStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTForLoopStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTFormalComment;
import net.sourceforge.pmd.lang.apex.ast.ASTIdentifierCase;
import net.sourceforge.pmd.lang.apex.ast.ASTIfBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTIfElseBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTIllegalStoreExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTInstanceOfExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTJavaMethodCallExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTJavaVariableExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTLiteralCase;
import net.sourceforge.pmd.lang.apex.ast.ASTLiteralExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTMapEntryNode;
import net.sourceforge.pmd.lang.apex.ast.ASTMethod;
import net.sourceforge.pmd.lang.apex.ast.ASTMethodBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTMethodCallExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTModifier;
import net.sourceforge.pmd.lang.apex.ast.ASTModifierNode;
import net.sourceforge.pmd.lang.apex.ast.ASTModifierOrAnnotation;
import net.sourceforge.pmd.lang.apex.ast.ASTMultiStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTNestedExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNestedStoreExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewKeyValueObjectExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewListInitExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewListLiteralExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewMapInitExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewMapLiteralExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewObjectExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewSetInitExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTNewSetLiteralExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTPackageVersionExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTParameter;
import net.sourceforge.pmd.lang.apex.ast.ASTPostfixExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTPrefixExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTProperty;
import net.sourceforge.pmd.lang.apex.ast.ASTReferenceExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTRunAsBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTSoqlExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTSoslExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTStandardCondition;
import net.sourceforge.pmd.lang.apex.ast.ASTStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTStatementExecuted;
import net.sourceforge.pmd.lang.apex.ast.ASTSuperMethodCallExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTSuperVariableExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTSwitchStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTTernaryExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTThisMethodCallExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTThisVariableExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTThrowStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTTriggerVariableExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTTryCatchFinallyBlockStatement;
import net.sourceforge.pmd.lang.apex.ast.ASTTypeWhenBlock;
import net.sourceforge.pmd.lang.apex.ast.ASTUserClass;
import net.sourceforge.pmd.lang.apex.ast.ASTUserClassMethods;
import net.sourceforge.pmd.lang.apex.ast.ASTUserEnum;
import net.sourceforge.pmd.lang.apex.ast.ASTUserExceptionMethods;
import net.sourceforge.pmd.lang.apex.ast.ASTUserInterface;
import net.sourceforge.pmd.lang.apex.ast.ASTUserTrigger;
import net.sourceforge.pmd.lang.apex.ast.ASTValueWhenBlock;
import net.sourceforge.pmd.lang.apex.ast.ASTVariableDeclaration;
import net.sourceforge.pmd.lang.apex.ast.ASTVariableDeclarationStatements;
import net.sourceforge.pmd.lang.apex.ast.ASTVariableExpression;
import net.sourceforge.pmd.lang.apex.ast.ASTWhileLoopStatement;
import net.sourceforge.pmd.lang.apex.ast.AbstractApexNodeBase;
import net.sourceforge.pmd.lang.apex.ast.ApexNode;
import net.sourceforge.pmd.lang.apex.ast.ApexParserVisitor;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.rule.ImmutableLanguage;
import net.sourceforge.pmd.renderers.CodeClimateRule;

public abstract class AbstractApexRule extends AbstractRule
        implements ApexParserVisitor, ImmutableLanguage, CodeClimateRule {

    public AbstractApexRule() {
        super.setLanguage(LanguageRegistry.getLanguage(ApexLanguageModule.NAME));
        definePropertyDescriptor(CODECLIMATE_CATEGORIES);
        definePropertyDescriptor(CODECLIMATE_REMEDIATION_MULTIPLIER);
        definePropertyDescriptor(CODECLIMATE_BLOCK_HIGHLIGHTING);
    }

    @Override
    public ParserOptions getParserOptions() {
        return new ApexParserOptions();
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        visitAll(nodes, ctx);
    }

    protected void visitAll(final List<? extends Node> nodes, final RuleContext ctx) {
        for (Object element : nodes) {
            if (element instanceof ASTUserClass) {
                visit((ASTUserClass) element, ctx);
            } else if (element instanceof ASTUserInterface) {
                visit((ASTUserInterface) element, ctx);
            } else if (element instanceof ASTUserTrigger) {
                visit((ASTUserTrigger) element, ctx);
            }
        }
    }

    /**
     * @deprecated Use {@link #visit(ApexNode, Object)}. That method
     *     also visits comments now.
     */
    @Deprecated
    @Override
    public Object visit(final AbstractApexNodeBase node, final Object data) {
        node.childrenAccept(this, data);
        return null;
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
