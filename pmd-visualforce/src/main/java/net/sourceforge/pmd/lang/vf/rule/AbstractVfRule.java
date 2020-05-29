/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.vf.rule;

import java.util.List;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.rule.ImmutableLanguage;
import net.sourceforge.pmd.lang.vf.VfLanguageModule;
import net.sourceforge.pmd.lang.vf.ast.ASTArguments;
import net.sourceforge.pmd.lang.vf.ast.ASTAttribute;
import net.sourceforge.pmd.lang.vf.ast.ASTAttributeValue;
import net.sourceforge.pmd.lang.vf.ast.ASTCData;
import net.sourceforge.pmd.lang.vf.ast.ASTCompilationUnit;
import net.sourceforge.pmd.lang.vf.ast.ASTContent;
import net.sourceforge.pmd.lang.vf.ast.ASTDeclaration;
import net.sourceforge.pmd.lang.vf.ast.ASTDoctypeDeclaration;
import net.sourceforge.pmd.lang.vf.ast.ASTDoctypeExternalId;
import net.sourceforge.pmd.lang.vf.ast.ASTDotExpression;
import net.sourceforge.pmd.lang.vf.ast.ASTElExpression;
import net.sourceforge.pmd.lang.vf.ast.ASTElement;
import net.sourceforge.pmd.lang.vf.ast.ASTExpression;
import net.sourceforge.pmd.lang.vf.ast.ASTHtmlScript;
import net.sourceforge.pmd.lang.vf.ast.ASTIdentifier;
import net.sourceforge.pmd.lang.vf.ast.ASTLiteral;
import net.sourceforge.pmd.lang.vf.ast.ASTNegationExpression;
import net.sourceforge.pmd.lang.vf.ast.ASTText;
import net.sourceforge.pmd.lang.vf.ast.VfNode;
import net.sourceforge.pmd.lang.vf.ast.VfParserVisitor;

public abstract class AbstractVfRule extends AbstractRule implements VfParserVisitor, ImmutableLanguage {

    public AbstractVfRule() {
        super.setLanguage(LanguageRegistry.getLanguage(VfLanguageModule.NAME));
    }

    @Override
    public void apply(final List<? extends Node> nodes, final RuleContext ctx) {
        visitAll(nodes, ctx);
    }

    protected void visitAll(final List<? extends Node> nodes, final RuleContext ctx) {
        for (Object element : nodes) {
            if (element instanceof ASTCompilationUnit) {
                ASTCompilationUnit node = (ASTCompilationUnit) element;
                visit(node, ctx);
            } else {
                VfNode node = (VfNode) element;
                visit(node, ctx);
            }
        }
    }

    @Override
    public Object visit(final VfNode node, final Object data) {
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(final ASTCompilationUnit node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTText node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTAttributeValue node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTElExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTCData node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTElement node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTAttribute node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDeclaration node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDoctypeDeclaration node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDoctypeExternalId node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTHtmlScript node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTLiteral node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTIdentifier node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTArguments node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTDotExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTContent node, final Object data) {
        return visit((VfNode) node, data);
    }

    @Override
    public Object visit(final ASTNegationExpression node, final Object data) {
        return visit((VfNode) node, data);
    }

}
