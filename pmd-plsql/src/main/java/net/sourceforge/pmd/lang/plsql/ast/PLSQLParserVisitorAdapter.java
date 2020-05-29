/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

public class PLSQLParserVisitorAdapter implements PLSQLParserVisitor {

    @Override
    public Object visit(final PLSQLNode node, final Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(final ASTInput node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDDLCommand node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSqlPlusCommand node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTGlobal node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTBlock node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPackageSpecification node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPackageBody node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDeclarativeUnit node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDeclarativeSection node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCompilationDeclarationFragment node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTProgramUnit node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTObjectNameDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFormalParameter node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTMethodDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTMethodDeclarator node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFormalParameters node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableOrConstantDeclarator node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableOrConstantDeclaratorId node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableOrConstantInitializer node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDatatype node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCompilationDataType node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCollectionTypeName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTScalarDataTypeName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDateTimeLiteral node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExceptionHandler node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSkip2NextTerminator node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSkip2NextOccurrence node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSkipPastNextOccurrence node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSkip2NextTokenOccurrence node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSkipPastNextTokenOccurrence node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTRead2NextOccurrence node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTReadPastNextOccurrence node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSqlStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTWrappedObject node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTUnlabelledStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTLabelledStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCaseStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCaseWhenClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTElseClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTElsifClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTLoopStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTForStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTWhileStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIfStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTForIndex node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTForAllIndex node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTForAllStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTGotoStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTContinueStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExitStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTRaiseStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCloseStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTOpenStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFetchStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTEmbeddedSqlStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPipelineStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalCompilationStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSubTypeDefinition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCollectionTypeDefinition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCollectionDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTObjectDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCallSpecTail node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCursorUnit node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCompilationExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAssignment node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCaseExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTLikeExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTrimExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTObjectExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalOrExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalAndExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTEqualityExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTRelationalExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAdditiveExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTStringExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTMultiplicativeExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTUnaryExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExtractExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTUnaryExpressionNotPlusMinus node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimaryExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimaryPrefix node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPrimarySuffix node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTLiteral node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTStringLiteral node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTBooleanLiteral node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTNullLiteral node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTMultiSetCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTNumericLiteral node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTLabel node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTQualifiedName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTArguments node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTArgumentList node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTArgument node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableOrConstantDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDatatypeDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPragma node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTInlinePragma node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExceptionDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTParallelClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTable node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTableColumn node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTInlineConstraint node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTView node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSynonym node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDirectory node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDatabaseLink node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTViewColumn node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTComment node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeMethod node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeSpecification node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAlterTypeSpec node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAttributeDeclaration node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAttribute node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPragmaClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTriggerUnit node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTriggerTimingPointSection node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCompoundTriggerBlock node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTNonDMLTrigger node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDDLEvent node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDatabaseEvent node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTNonDMLEvent node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAlterTrigger node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTKEYWORD_UNRESERVED node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTID node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTUnqualifiedID node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTQualifiedID node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeKeyword node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTJavaInterfaceClass node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAccessibleByClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIsNullCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIsOfTypeCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override

    public Object visit(final ASTOutOfLineConstraint node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSelectIntoStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTReferencesClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCrossOuterApplyClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCursorForLoopStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTInnerCrossJoinClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTJoinClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTOuterJoinClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTOuterJoinType node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTableReference node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSelectList node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTBulkCollectIntoClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIntoClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTColumnAlias node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTableAlias node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCollectionName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTHostArrayName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTQueryBlock node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSchemaName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTableName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTComparisonCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExpressionList node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTWhereClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSqlExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTInCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExpressionListMultiple node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExpressionListSingle node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCompoundCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTColumn node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTOrderByClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTRowLimitingClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTVariableName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFromClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSubqueryOperation node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTQueryPartitionClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTGroupByClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTGroupingExpressionList node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTGroupingSetsClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTRollupCubeClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSelectStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTLikeCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTBetweenCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFloatingPointCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionCall node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTUpdateStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTUpdateSetClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDeleteStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSubqueryRestrictionClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTableCollectionExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTDMLTableExpressionClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTConditionalInsertClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTInsertIntoClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTInsertStatement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTMultiTableInsert node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSingleTableInsert node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTValuesClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTExistsCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTHierarchicalQueryClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIsASetCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIsEmptyCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTMemberCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSubmultisetCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTRegexpLikeCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTFunctionName node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTAnalyticClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTWindowingClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTWithinClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTListaggOverflowClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPartitionExtensionClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTReturningClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTErrorLoggingClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTSimpleExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLTable node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLNamespacesClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLTableOptions node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLPassingClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLTableColum node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLExists node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLAttributesClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTXMLElement node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTOuterJoinExpression node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTForUpdateClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTWithClause node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTCursorSpecification node, final Object data) {
        return visit((PLSQLNode) node, data);
    }
}
