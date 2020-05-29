/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.IfElseBlockStatement;

public class ASTIfElseBlockStatement extends AbstractApexNode<IfElseBlockStatement> {

    @Deprecated
    @InternalApi
    public ASTIfElseBlockStatement(final IfElseBlockStatement ifElseBlockStatement) {
        super(ifElseBlockStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public boolean hasElseStatement() {
        return node.hasElseStatement();
    }
}
