/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.rule;

import java.util.List;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.modelica.ModelicaLanguageModule;
import net.sourceforge.pmd.lang.modelica.ast.ASTAddOp;
import net.sourceforge.pmd.lang.modelica.ast.ASTAlgorithmSection;
import net.sourceforge.pmd.lang.modelica.ast.ASTAnnotation;
import net.sourceforge.pmd.lang.modelica.ast.ASTArgument;
import net.sourceforge.pmd.lang.modelica.ast.ASTArgumentList;
import net.sourceforge.pmd.lang.modelica.ast.ASTArithmeticExpression;
import net.sourceforge.pmd.lang.modelica.ast.ASTArraySubscripts;
import net.sourceforge.pmd.lang.modelica.ast.ASTAssignmentFromMultiResultFunctionCall;
import net.sourceforge.pmd.lang.modelica.ast.ASTAssignmentModification;
import net.sourceforge.pmd.lang.modelica.ast.ASTAssignmentStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTBasePrefix;
import net.sourceforge.pmd.lang.modelica.ast.ASTBlockClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTClassClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTClassDefinition;
import net.sourceforge.pmd.lang.modelica.ast.ASTClassModification;
import net.sourceforge.pmd.lang.modelica.ast.ASTClassPrefixes;
import net.sourceforge.pmd.lang.modelica.ast.ASTClassSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTColonSubsript;
import net.sourceforge.pmd.lang.modelica.ast.ASTComment;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentClause1;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentDeclaration;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentDeclaration1;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentList;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentReference;
import net.sourceforge.pmd.lang.modelica.ast.ASTComposition;
import net.sourceforge.pmd.lang.modelica.ast.ASTConditionAttribute;
import net.sourceforge.pmd.lang.modelica.ast.ASTConnectClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTConnectorClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTConstantClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTConstrainingClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTDeclaration;
import net.sourceforge.pmd.lang.modelica.ast.ASTDerClassSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTDerClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTDiscreteClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTEachClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTElementList;
import net.sourceforge.pmd.lang.modelica.ast.ASTElementModification;
import net.sourceforge.pmd.lang.modelica.ast.ASTElementModificationOrReplaceable;
import net.sourceforge.pmd.lang.modelica.ast.ASTElementRedeclaration;
import net.sourceforge.pmd.lang.modelica.ast.ASTElementReplaceable;
import net.sourceforge.pmd.lang.modelica.ast.ASTElseClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTElseIfClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTElseWhenClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTEncapsulatedClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTEnumList;
import net.sourceforge.pmd.lang.modelica.ast.ASTEnumerationLiteral;
import net.sourceforge.pmd.lang.modelica.ast.ASTEnumerationShortClassSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTEquation;
import net.sourceforge.pmd.lang.modelica.ast.ASTEquationList;
import net.sourceforge.pmd.lang.modelica.ast.ASTEquationSection;
import net.sourceforge.pmd.lang.modelica.ast.ASTExpandableConnectorClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTExpressionList;
import net.sourceforge.pmd.lang.modelica.ast.ASTExtendingLongClassSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTExtendsClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTExternalClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTExternalFunctionCall;
import net.sourceforge.pmd.lang.modelica.ast.ASTFactor;
import net.sourceforge.pmd.lang.modelica.ast.ASTFalseLiteral;
import net.sourceforge.pmd.lang.modelica.ast.ASTFinalClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTFlowClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTForEquation;
import net.sourceforge.pmd.lang.modelica.ast.ASTForIndex;
import net.sourceforge.pmd.lang.modelica.ast.ASTForIndices;
import net.sourceforge.pmd.lang.modelica.ast.ASTForStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionArgument;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionArguments;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionCallArgs;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionCallEquation;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionCallStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTFunctionInvocation;
import net.sourceforge.pmd.lang.modelica.ast.ASTIfClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTIfEquation;
import net.sourceforge.pmd.lang.modelica.ast.ASTIfExpression;
import net.sourceforge.pmd.lang.modelica.ast.ASTIfStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTImportClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTImportList;
import net.sourceforge.pmd.lang.modelica.ast.ASTImpureClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTInitialClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTInnerClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTInputClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTLanguageSpecification;
import net.sourceforge.pmd.lang.modelica.ast.ASTListOfExpressionLists;
import net.sourceforge.pmd.lang.modelica.ast.ASTLogicalExpression;
import net.sourceforge.pmd.lang.modelica.ast.ASTLogicalTerm;
import net.sourceforge.pmd.lang.modelica.ast.ASTLongModification;
import net.sourceforge.pmd.lang.modelica.ast.ASTModelClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTMulOp;
import net.sourceforge.pmd.lang.modelica.ast.ASTMultipleDefinitionImportClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTName;
import net.sourceforge.pmd.lang.modelica.ast.ASTNamedArgument;
import net.sourceforge.pmd.lang.modelica.ast.ASTNamedArguments;
import net.sourceforge.pmd.lang.modelica.ast.ASTNegated;
import net.sourceforge.pmd.lang.modelica.ast.ASTNumberLiteral;
import net.sourceforge.pmd.lang.modelica.ast.ASTOperator;
import net.sourceforge.pmd.lang.modelica.ast.ASTOperatorClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTOperatorRecordClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTOuterClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTOutputClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTOutputExpressionList;
import net.sourceforge.pmd.lang.modelica.ast.ASTPackageClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTParameterClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTPartialClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTPureClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTRecordClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTRedeclareClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTRegularElement;
import net.sourceforge.pmd.lang.modelica.ast.ASTRegularEquation;
import net.sourceforge.pmd.lang.modelica.ast.ASTRelOp;
import net.sourceforge.pmd.lang.modelica.ast.ASTRelation;
import net.sourceforge.pmd.lang.modelica.ast.ASTRenamingImportClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTReplaceableClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTShortClassDefinition;
import net.sourceforge.pmd.lang.modelica.ast.ASTShortModification;
import net.sourceforge.pmd.lang.modelica.ast.ASTSimpleExpression;
import net.sourceforge.pmd.lang.modelica.ast.ASTSimpleLongClassSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTSimpleName;
import net.sourceforge.pmd.lang.modelica.ast.ASTSimpleShortClassSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTSingleDefinitionImportClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTStatementList;
import net.sourceforge.pmd.lang.modelica.ast.ASTStoredDefinition;
import net.sourceforge.pmd.lang.modelica.ast.ASTStreamClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTStringComment;
import net.sourceforge.pmd.lang.modelica.ast.ASTStringLiteral;
import net.sourceforge.pmd.lang.modelica.ast.ASTSubscript;
import net.sourceforge.pmd.lang.modelica.ast.ASTSubscriptedName;
import net.sourceforge.pmd.lang.modelica.ast.ASTTerm;
import net.sourceforge.pmd.lang.modelica.ast.ASTThenClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTTrueLiteral;
import net.sourceforge.pmd.lang.modelica.ast.ASTTypeClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTTypePrefix;
import net.sourceforge.pmd.lang.modelica.ast.ASTTypeSpecifier;
import net.sourceforge.pmd.lang.modelica.ast.ASTUnqualifiedImportClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTWhenClause;
import net.sourceforge.pmd.lang.modelica.ast.ASTWhenEquation;
import net.sourceforge.pmd.lang.modelica.ast.ASTWhenStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.modelica.ast.ASTWithinClause;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaNode;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaParserVisitor;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.rule.ImmutableLanguage;

/**
 * Base class for rules for Modelica language.
 */
public abstract class AbstractModelicaRule extends AbstractRule implements ModelicaParserVisitor, ImmutableLanguage {
    public AbstractModelicaRule() {
        super.setLanguage(LanguageRegistry.getLanguage(ModelicaLanguageModule.NAME));
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        visitAll(nodes, ctx);
    }

    protected void visitAll(final List<? extends Node> nodes, final RuleContext ctx) {
        for (final Object element : nodes) {
            final ASTStoredDefinition node = (ASTStoredDefinition) element;
            visit(node, ctx);
        }
    }

    @Override
    public Object visit(final ModelicaNode node, final Object data) {
        for (ModelicaNode child : node.children()) {
            child.jjtAccept(this, data);
        }
        return data;
    }

    @Override
    public Object visit(final ASTNegated node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTStoredDefinition node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTWithinClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassDefinition node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEncapsulatedClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassPrefixes node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTPartialClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTModelClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRecordClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTOperatorRecordClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTBlockClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTConnectorClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTExpandableConnectorClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTPackageClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTPureClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTImpureClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTOperatorClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTOperator node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSimpleLongClassSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTExtendingLongClassSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSimpleShortClassSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEnumerationShortClassSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTDerClassSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTDerClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTBasePrefix node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEnumList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEnumerationLiteral node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComposition node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTExternalClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTLanguageSpecification node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTExternalFunctionCall node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElementList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRedeclareClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFinalClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTInnerClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTOuterClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTReplaceableClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRegularElement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTImportClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRenamingImportClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTUnqualifiedImportClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTMultipleDefinitionImportClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSingleDefinitionImportClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTImportList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTExtendsClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTConstrainingClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComponentClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypePrefix node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFlowClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTStreamClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTDiscreteClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTParameterClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTConstantClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTInputClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTOutputClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeSpecifier node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComponentList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComponentDeclaration node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionAttribute node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTDeclaration node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTLongModification node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTShortModification node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTAssignmentModification node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTClassModification node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTArgumentList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTArgument node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElementModificationOrReplaceable node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEachClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElementModification node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElementRedeclaration node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElementReplaceable node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComponentClause1 node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComponentDeclaration1 node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTShortClassDefinition node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEquationSection node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTInitialClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTAlgorithmSection node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEquation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRegularEquation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionCallEquation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTAssignmentStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionCallStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTAssignmentFromMultiResultFunctionCall node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTBreakStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTIfEquation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTIfClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTThenClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElseIfClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElseClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTIfStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTForEquation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTEquationList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTStatementList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTForStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTForIndices node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTForIndex node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTWhileStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTWhenEquation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTWhenClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTElseWhenClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTWhenStatement node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTConnectClause node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTIfExpression node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSimpleExpression node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTLogicalExpression node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTLogicalTerm node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRelation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTRelOp node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTArithmeticExpression node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTAddOp node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTTerm node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTMulOp node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFactor node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFalseLiteral node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTTrueLiteral node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionInvocation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTListOfExpressionLists node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTNumberLiteral node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTStringLiteral node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTName node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSimpleName node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSubscriptedName node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComponentReference node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionCallArgs node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionArguments node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTNamedArguments node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTNamedArgument node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionArgument node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTOutputExpressionList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTExpressionList node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTArraySubscripts node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTSubscript node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTColonSubsript node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTComment node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTStringComment node, final Object data) {
        return visit((ModelicaNode) node, data);
    }

    @Override
    public Object visit(final ASTAnnotation node, final Object data) {
        return visit((ModelicaNode) node, data);
    }
}
