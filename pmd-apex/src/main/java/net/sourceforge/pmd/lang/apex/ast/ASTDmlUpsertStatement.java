/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.DmlUpsertStatement;

public class ASTDmlUpsertStatement extends AbstractApexNode<DmlUpsertStatement> {

    @Deprecated
    @InternalApi
    public ASTDmlUpsertStatement(final DmlUpsertStatement dmlUpsertStatement) {
        super(dmlUpsertStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
