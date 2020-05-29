/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.IfBlockStatement;

public class ASTIfBlockStatement extends AbstractApexNode<IfBlockStatement> {

    @Deprecated
    @InternalApi
    public ASTIfBlockStatement(final IfBlockStatement ifBlockStatement) {
        super(ifBlockStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
