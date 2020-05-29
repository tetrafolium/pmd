/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.rule;

import java.util.List;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.modelica.ast.ASTStoredDefinition;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaNode;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaParserVisitor;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaParserVisitorAdapter;
import net.sourceforge.pmd.lang.rule.AbstractRuleChainVisitor;
import net.sourceforge.pmd.lang.rule.XPathRule;

public class ModelicaRuleChainVisitor extends AbstractRuleChainVisitor {
    @Override
    protected void visit(final Rule rule, final Node node, final RuleContext ctx) {
        if (rule instanceof ModelicaParserVisitor) {
            ((ModelicaNode) node).jjtAccept((ModelicaParserVisitor) rule, ctx);
        } else {
            ((XPathRule) rule).evaluate(node, ctx);
        }
    }

    @Override
    protected void indexNodes(final List<Node> nodes, final RuleContext ctx) {
        ModelicaParserVisitorAdapter modelicaParserVisitor = new ModelicaParserVisitorAdapter() {
            @Override
            public Object visit(final ModelicaNode node, final Object data) {
                indexNode((Node) node);
                return super.visit(node, data);
            }
        };
        for (int i = 0; i < nodes.size(); ++i) {
            modelicaParserVisitor.visit((ASTStoredDefinition) nodes.get(i), ctx);
        }
    }
}
