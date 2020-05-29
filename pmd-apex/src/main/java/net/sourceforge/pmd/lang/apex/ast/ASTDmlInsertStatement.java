/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.DmlInsertStatement;

public class ASTDmlInsertStatement extends AbstractApexNode<DmlInsertStatement> {

    @Deprecated
    @InternalApi
    public ASTDmlInsertStatement(final DmlInsertStatement dmlInsertStatement) {
        super(dmlInsertStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
