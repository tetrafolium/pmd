/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.rule;

import java.util.List;
import java.util.logging.Logger;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.plsql.PLSQLLanguageModule;
import net.sourceforge.pmd.lang.plsql.ast.ASTAccessibleByClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTAdditiveExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTAlterTrigger;
import net.sourceforge.pmd.lang.plsql.ast.ASTAlterTypeSpec;
import net.sourceforge.pmd.lang.plsql.ast.ASTAnalyticClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTArgument;
import net.sourceforge.pmd.lang.plsql.ast.ASTArgumentList;
import net.sourceforge.pmd.lang.plsql.ast.ASTArguments;
import net.sourceforge.pmd.lang.plsql.ast.ASTAssignment;
import net.sourceforge.pmd.lang.plsql.ast.ASTAttribute;
import net.sourceforge.pmd.lang.plsql.ast.ASTAttributeDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTBetweenCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTBlock;
import net.sourceforge.pmd.lang.plsql.ast.ASTBooleanLiteral;
import net.sourceforge.pmd.lang.plsql.ast.ASTBulkCollectIntoClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTCallSpecTail;
import net.sourceforge.pmd.lang.plsql.ast.ASTCaseExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTCaseStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTCaseWhenClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTCloseStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTCollectionDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTCollectionName;
import net.sourceforge.pmd.lang.plsql.ast.ASTCollectionTypeDefinition;
import net.sourceforge.pmd.lang.plsql.ast.ASTCollectionTypeName;
import net.sourceforge.pmd.lang.plsql.ast.ASTColumn;
import net.sourceforge.pmd.lang.plsql.ast.ASTColumnAlias;
import net.sourceforge.pmd.lang.plsql.ast.ASTComment;
import net.sourceforge.pmd.lang.plsql.ast.ASTComparisonCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTCompilationDataType;
import net.sourceforge.pmd.lang.plsql.ast.ASTCompilationDeclarationFragment;
import net.sourceforge.pmd.lang.plsql.ast.ASTCompilationExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTCompoundCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTCompoundTriggerBlock;
import net.sourceforge.pmd.lang.plsql.ast.ASTCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTConditionalAndExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTConditionalCompilationStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTConditionalInsertClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTConditionalOrExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTContinueStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTCrossOuterApplyClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTCursorForLoopStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTCursorSpecification;
import net.sourceforge.pmd.lang.plsql.ast.ASTCursorUnit;
import net.sourceforge.pmd.lang.plsql.ast.ASTDDLCommand;
import net.sourceforge.pmd.lang.plsql.ast.ASTDDLEvent;
import net.sourceforge.pmd.lang.plsql.ast.ASTDMLTableExpressionClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTDatabaseEvent;
import net.sourceforge.pmd.lang.plsql.ast.ASTDatabaseLink;
import net.sourceforge.pmd.lang.plsql.ast.ASTDatatype;
import net.sourceforge.pmd.lang.plsql.ast.ASTDatatypeDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTDateTimeLiteral;
import net.sourceforge.pmd.lang.plsql.ast.ASTDeclarativeSection;
import net.sourceforge.pmd.lang.plsql.ast.ASTDeclarativeUnit;
import net.sourceforge.pmd.lang.plsql.ast.ASTDeleteStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTDirectory;
import net.sourceforge.pmd.lang.plsql.ast.ASTElseClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTElsifClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTEmbeddedSqlStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTEqualityExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTErrorLoggingClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTExceptionDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTExceptionHandler;
import net.sourceforge.pmd.lang.plsql.ast.ASTExistsCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTExitStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTExpressionList;
import net.sourceforge.pmd.lang.plsql.ast.ASTExpressionListMultiple;
import net.sourceforge.pmd.lang.plsql.ast.ASTExpressionListSingle;
import net.sourceforge.pmd.lang.plsql.ast.ASTExtractExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTFetchStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTFloatingPointCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTForAllIndex;
import net.sourceforge.pmd.lang.plsql.ast.ASTForAllStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTForIndex;
import net.sourceforge.pmd.lang.plsql.ast.ASTForStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTForUpdateClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTFormalParameter;
import net.sourceforge.pmd.lang.plsql.ast.ASTFormalParameters;
import net.sourceforge.pmd.lang.plsql.ast.ASTFromClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTFunctionCall;
import net.sourceforge.pmd.lang.plsql.ast.ASTFunctionName;
import net.sourceforge.pmd.lang.plsql.ast.ASTGlobal;
import net.sourceforge.pmd.lang.plsql.ast.ASTGotoStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTGroupByClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTGroupingExpressionList;
import net.sourceforge.pmd.lang.plsql.ast.ASTGroupingSetsClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTHierarchicalQueryClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTHostArrayName;
import net.sourceforge.pmd.lang.plsql.ast.ASTID;
import net.sourceforge.pmd.lang.plsql.ast.ASTIfStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTInCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTInlineConstraint;
import net.sourceforge.pmd.lang.plsql.ast.ASTInlinePragma;
import net.sourceforge.pmd.lang.plsql.ast.ASTInnerCrossJoinClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTInput;
import net.sourceforge.pmd.lang.plsql.ast.ASTInsertIntoClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTInsertStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTIntoClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTIsASetCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTIsEmptyCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTIsNullCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTIsOfTypeCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTJavaInterfaceClass;
import net.sourceforge.pmd.lang.plsql.ast.ASTJoinClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTKEYWORD_UNRESERVED;
import net.sourceforge.pmd.lang.plsql.ast.ASTLabel;
import net.sourceforge.pmd.lang.plsql.ast.ASTLabelledStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTLikeCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTLikeExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTListaggOverflowClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTLiteral;
import net.sourceforge.pmd.lang.plsql.ast.ASTLoopStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTMemberCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTMethodDeclarator;
import net.sourceforge.pmd.lang.plsql.ast.ASTMultiSetCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTMultiTableInsert;
import net.sourceforge.pmd.lang.plsql.ast.ASTMultiplicativeExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTName;
import net.sourceforge.pmd.lang.plsql.ast.ASTNonDMLEvent;
import net.sourceforge.pmd.lang.plsql.ast.ASTNonDMLTrigger;
import net.sourceforge.pmd.lang.plsql.ast.ASTNullLiteral;
import net.sourceforge.pmd.lang.plsql.ast.ASTNumericLiteral;
import net.sourceforge.pmd.lang.plsql.ast.ASTObjectDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTObjectExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTObjectNameDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTOpenStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTOrderByClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTOutOfLineConstraint;
import net.sourceforge.pmd.lang.plsql.ast.ASTOuterJoinClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTOuterJoinExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTOuterJoinType;
import net.sourceforge.pmd.lang.plsql.ast.ASTPackageBody;
import net.sourceforge.pmd.lang.plsql.ast.ASTPackageSpecification;
import net.sourceforge.pmd.lang.plsql.ast.ASTParallelClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTPartitionExtensionClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTPipelineStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTPragma;
import net.sourceforge.pmd.lang.plsql.ast.ASTPragmaClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTPrimaryExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTPrimaryPrefix;
import net.sourceforge.pmd.lang.plsql.ast.ASTPrimarySuffix;
import net.sourceforge.pmd.lang.plsql.ast.ASTProgramUnit;
import net.sourceforge.pmd.lang.plsql.ast.ASTQualifiedID;
import net.sourceforge.pmd.lang.plsql.ast.ASTQualifiedName;
import net.sourceforge.pmd.lang.plsql.ast.ASTQueryBlock;
import net.sourceforge.pmd.lang.plsql.ast.ASTQueryPartitionClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTRaiseStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTRead2NextOccurrence;
import net.sourceforge.pmd.lang.plsql.ast.ASTReadPastNextOccurrence;
import net.sourceforge.pmd.lang.plsql.ast.ASTReferencesClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTRegexpLikeCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTRelationalExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTReturningClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTRollupCubeClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTRowLimitingClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTScalarDataTypeName;
import net.sourceforge.pmd.lang.plsql.ast.ASTSchemaName;
import net.sourceforge.pmd.lang.plsql.ast.ASTSelectIntoStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTSelectList;
import net.sourceforge.pmd.lang.plsql.ast.ASTSelectStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTSimpleExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTSingleTableInsert;
import net.sourceforge.pmd.lang.plsql.ast.ASTSkip2NextOccurrence;
import net.sourceforge.pmd.lang.plsql.ast.ASTSkip2NextTerminator;
import net.sourceforge.pmd.lang.plsql.ast.ASTSkip2NextTokenOccurrence;
import net.sourceforge.pmd.lang.plsql.ast.ASTSkipPastNextOccurrence;
import net.sourceforge.pmd.lang.plsql.ast.ASTSkipPastNextTokenOccurrence;
import net.sourceforge.pmd.lang.plsql.ast.ASTSqlExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTSqlPlusCommand;
import net.sourceforge.pmd.lang.plsql.ast.ASTSqlStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTStringExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTStringLiteral;
import net.sourceforge.pmd.lang.plsql.ast.ASTSubTypeDefinition;
import net.sourceforge.pmd.lang.plsql.ast.ASTSubmultisetCondition;
import net.sourceforge.pmd.lang.plsql.ast.ASTSubqueryOperation;
import net.sourceforge.pmd.lang.plsql.ast.ASTSubqueryRestrictionClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTSynonym;
import net.sourceforge.pmd.lang.plsql.ast.ASTTable;
import net.sourceforge.pmd.lang.plsql.ast.ASTTableAlias;
import net.sourceforge.pmd.lang.plsql.ast.ASTTableCollectionExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTTableColumn;
import net.sourceforge.pmd.lang.plsql.ast.ASTTableName;
import net.sourceforge.pmd.lang.plsql.ast.ASTTableReference;
import net.sourceforge.pmd.lang.plsql.ast.ASTTriggerTimingPointSection;
import net.sourceforge.pmd.lang.plsql.ast.ASTTriggerUnit;
import net.sourceforge.pmd.lang.plsql.ast.ASTTrimExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTTypeKeyword;
import net.sourceforge.pmd.lang.plsql.ast.ASTTypeMethod;
import net.sourceforge.pmd.lang.plsql.ast.ASTTypeSpecification;
import net.sourceforge.pmd.lang.plsql.ast.ASTUnaryExpression;
import net.sourceforge.pmd.lang.plsql.ast.ASTUnaryExpressionNotPlusMinus;
import net.sourceforge.pmd.lang.plsql.ast.ASTUnlabelledStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTUnqualifiedID;
import net.sourceforge.pmd.lang.plsql.ast.ASTUpdateSetClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTUpdateStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTValuesClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTVariableName;
import net.sourceforge.pmd.lang.plsql.ast.ASTVariableOrConstantDeclaration;
import net.sourceforge.pmd.lang.plsql.ast.ASTVariableOrConstantDeclarator;
import net.sourceforge.pmd.lang.plsql.ast.ASTVariableOrConstantDeclaratorId;
import net.sourceforge.pmd.lang.plsql.ast.ASTVariableOrConstantInitializer;
import net.sourceforge.pmd.lang.plsql.ast.ASTView;
import net.sourceforge.pmd.lang.plsql.ast.ASTViewColumn;
import net.sourceforge.pmd.lang.plsql.ast.ASTWhereClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.plsql.ast.ASTWindowingClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTWithClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTWithinClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTWrappedObject;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLAttributesClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLElement;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLExists;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLNamespacesClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLPassingClause;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLTable;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLTableColum;
import net.sourceforge.pmd.lang.plsql.ast.ASTXMLTableOptions;
import net.sourceforge.pmd.lang.plsql.ast.ExecutableCode;
import net.sourceforge.pmd.lang.plsql.ast.PLSQLNode;
import net.sourceforge.pmd.lang.plsql.ast.PLSQLParserVisitor;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.rule.ImmutableLanguage;

public abstract class AbstractPLSQLRule extends AbstractRule implements PLSQLParserVisitor, ImmutableLanguage {
    private static final Logger LOGGER = Logger.getLogger(AbstractPLSQLRule.class.getName());
    private static final String CLASS_NAME = AbstractPLSQLRule.class.getName();

    public AbstractPLSQLRule() {
        super.setLanguage(LanguageRegistry.getLanguage(PLSQLLanguageModule.NAME));
        // Enable Type Resolution on PLSQL Rules by default
        super.setTypeResolution(true);
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        visitAll(nodes, ctx);
    }

    protected void visitAll(final List<? extends Node> nodes, final RuleContext ctx) {
        LOGGER.entering(CLASS_NAME, "visitAll");
        for (Object element : nodes) {
            ASTInput node = (ASTInput) element;
            visit(node, ctx);
        }
        LOGGER.exiting(CLASS_NAME, "visitAll");
    }

    /**
     * Gets the Image of the first parent node of type
     * ASTClassOrInterfaceDeclaration or <code>null</code>
     *
     * @param node
     *            the node which will be searched
     */
    protected final String getDeclaringType(final Node node) {
        Node c;

        /*
         * Choose the Object Type
         */
        c = node.getFirstParentOfType(ASTPackageSpecification.class);
        if (c != null) {
            return c.getImage();
        }

        c = node.getFirstParentOfType(ASTTypeSpecification.class);
        if (c != null) {
            return c.getImage();
        }

        c = node.getFirstParentOfType(ASTPackageBody.class);
        if (c != null) {
            return c.getImage();
        }

        c = node.getFirstParentOfType(ASTTriggerUnit.class);
        if (c != null) {
            return c.getImage();
        }

        // Finally Schema-level Methods
        c = node.getFirstParentOfType(ASTProgramUnit.class);
        if (c != null) {
            return c.getImage();
        }

        return null;
    }

    public static boolean isQualifiedName(final Node node) {
        return node.getImage().indexOf('.') != -1;
    }

    public static boolean importsPackage(final ASTInput node, final String packageName) {
        return false;
    }

    /*
     * Duplicate PLSQLParserVisitor API
     */
    @Override
    public Object visit(final PLSQLNode node, final Object data) {
        for (PLSQLNode child : node.children()) {
            child.jjtAccept(this, data);
        }
        return null;
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
        LOGGER.entering(CLASS_NAME, "visit(ASTPackageSpecification)");
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTPackageBody node, final Object data) {
        LOGGER.entering(CLASS_NAME, "visit(ASTPackageBody)");
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
        LOGGER.entering(CLASS_NAME, "visit(ASTProgramUnit)");
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
    public Object visit(final ASTInlineConstraint node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTableColumn node, final Object data) {
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
        LOGGER.entering(CLASS_NAME, "visit(ASTTypeMethod)");
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTypeSpecification node, final Object data) {
        LOGGER.entering(CLASS_NAME, "visit(ASTTypeSpecification)");
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
    public Object visit(final ASTInlinePragma node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTriggerUnit node, final Object data) {
        LOGGER.entering(CLASS_NAME, "visit(ASTTriggerUnit)");
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTTriggerTimingPointSection node, final Object data) {
        LOGGER.entering(CLASS_NAME, "visit(ASTTriggerTimingPointSection)");
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
    public Object visit(final ASTIsOfTypeCondition node, final Object data) {
        return visit((PLSQLNode) node, data);
    }

    @Override
    public Object visit(final ASTIsNullCondition node, final Object data) {
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

    /*
     * Treat all Executable Code
     */
    public Object visit(final ExecutableCode node, final Object data) {
        LOGGER.entering(CLASS_NAME, "visit(ExecutableCode)");
        return visit((PLSQLNode) node, data);
    }
}
