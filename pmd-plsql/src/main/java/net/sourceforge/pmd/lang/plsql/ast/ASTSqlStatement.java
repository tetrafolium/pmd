/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTSqlStatement extends AbstractPLSQLNode {

    private Type type;

    public enum Type { COMMIT, ROLLBACK, SAVEPOINT, SET_TRANSACTION, LOCK_TABLE, MERGE }

    @Deprecated
    @InternalApi
    public ASTSqlStatement(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTSqlStatement(final PLSQLParser p, final int id) {
        super(p, id);
    }

    void setType(final Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
