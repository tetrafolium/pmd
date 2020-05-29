/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.ContinueStatement;

public class ASTContinueStatement extends AbstractApexNode<ContinueStatement> {

    @Deprecated
    @InternalApi
    public ASTContinueStatement(final ContinueStatement continueStatement) {
        super(continueStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
