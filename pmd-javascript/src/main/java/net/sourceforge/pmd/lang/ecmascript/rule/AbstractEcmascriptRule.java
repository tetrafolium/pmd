/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.rule;

import java.util.List;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ParserOptions;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.ecmascript.EcmascriptLanguageModule;
import net.sourceforge.pmd.lang.ecmascript.EcmascriptParserOptions;
import net.sourceforge.pmd.lang.ecmascript.EcmascriptParserOptions.Version;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTArrayComprehension;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTArrayComprehensionLoop;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTArrayLiteral;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTAssignment;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTAstRoot;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTBlock;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTCatchClause;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTComment;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTConditionalExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTContinueStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTDoLoop;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTElementGet;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTEmptyExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTExpressionStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTForInLoop;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTForLoop;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTFunctionCall;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTFunctionNode;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTIfStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTInfixExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTKeywordLiteral;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTLabel;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTLabeledStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTLetNode;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTName;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTNewExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTNumberLiteral;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTObjectLiteral;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTObjectProperty;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTParenthesizedExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTPropertyGet;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTRegExpLiteral;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTScope;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTStringLiteral;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTSwitchCase;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTSwitchStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTThrowStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTTryStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTUnaryExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTVariableDeclaration;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTVariableInitializer;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTWhileLoop;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTWithStatement;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTXmlDotQuery;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTXmlExpression;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTXmlMemberGet;
import net.sourceforge.pmd.lang.ecmascript.ast.ASTXmlString;
import net.sourceforge.pmd.lang.ecmascript.ast.EcmascriptNode;
import net.sourceforge.pmd.lang.ecmascript.ast.EcmascriptParserVisitor;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.rule.ImmutableLanguage;
import net.sourceforge.pmd.properties.PropertyDescriptor;


public abstract class AbstractEcmascriptRule extends AbstractRule
        implements EcmascriptParserVisitor, ImmutableLanguage {

    private static final PropertyDescriptor<Boolean> RECORDING_COMMENTS_DESCRIPTOR = EcmascriptParserOptions.RECORDING_COMMENTS_DESCRIPTOR;
    private static final PropertyDescriptor<Boolean> RECORDING_LOCAL_JSDOC_COMMENTS_DESCRIPTOR = EcmascriptParserOptions.RECORDING_LOCAL_JSDOC_COMMENTS_DESCRIPTOR;
    private static final PropertyDescriptor<Version> RHINO_LANGUAGE_VERSION = EcmascriptParserOptions.RHINO_LANGUAGE_VERSION;

    public AbstractEcmascriptRule() {
        super.setLanguage(LanguageRegistry.getLanguage(EcmascriptLanguageModule.NAME));
        // Rule-specific parser options are not supported. What do we do?
        definePropertyDescriptor(RECORDING_COMMENTS_DESCRIPTOR);
        definePropertyDescriptor(RECORDING_LOCAL_JSDOC_COMMENTS_DESCRIPTOR);
        definePropertyDescriptor(RHINO_LANGUAGE_VERSION);
    }

    @Override
    public ParserOptions getParserOptions() {
        return new EcmascriptParserOptions(this);
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        visitAll(nodes, ctx);
    }

    protected void visitAll(final List<? extends Node> nodes, final RuleContext ctx) {
        for (Object element : nodes) {
            ASTAstRoot node = (ASTAstRoot) element;
            visit(node, ctx);
        }
    }

    //
    // The following APIs are identical to those in
    // EcmascriptParserVisitorAdapter.
    // Due to Java single inheritance, it preferred to extend from the more
    // complex Rule base class instead of from relatively simple Visitor.
    //

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
