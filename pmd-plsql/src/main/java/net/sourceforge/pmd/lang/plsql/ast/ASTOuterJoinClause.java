/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTOuterJoinClause extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    private boolean natural;

    @Deprecated
    @InternalApi
    public ASTOuterJoinClause(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTOuterJoinClause(final PLSQLParser p, final int id) {
        super(p, id);
    }

    public boolean isNatural() {
        return natural;
    }

    void setNatural(final boolean natural) {
        this.natural = natural;
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
