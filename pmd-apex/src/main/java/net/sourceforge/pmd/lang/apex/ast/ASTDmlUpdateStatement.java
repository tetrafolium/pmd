/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.DmlUpdateStatement;

public class ASTDmlUpdateStatement extends AbstractApexNode<DmlUpdateStatement> {

    @Deprecated
    @InternalApi
    public ASTDmlUpdateStatement(final DmlUpdateStatement dmlUpdateStatement) {
        super(dmlUpdateStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
