/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.DmlUndeleteStatement;

public class ASTDmlUndeleteStatement extends AbstractApexNode<DmlUndeleteStatement> {

    @Deprecated
    @InternalApi
    public ASTDmlUndeleteStatement(final DmlUndeleteStatement dmlUndeleteStatement) {
        super(dmlUndeleteStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
