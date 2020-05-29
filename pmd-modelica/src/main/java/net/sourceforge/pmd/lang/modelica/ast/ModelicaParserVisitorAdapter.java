/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

public class ModelicaParserVisitorAdapter implements ModelicaParserVisitor {

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
