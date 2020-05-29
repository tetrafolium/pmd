/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTSelectIntoStatement extends AbstractSelectStatement {
    @Deprecated
    @InternalApi
    public ASTSelectIntoStatement(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTSelectIntoStatement(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
