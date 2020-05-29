/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTInnerCrossJoinClause extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    private boolean cross;
    private boolean natural;

    @Deprecated
    @InternalApi
    public ASTInnerCrossJoinClause(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTInnerCrossJoinClause(final PLSQLParser p, final int id) {
        super(p, id);
    }

    public boolean isCross() {
        return cross;
    }

    public boolean isNatural() {
        return natural;
    }

    void setCross(final boolean cross) {
        this.cross = cross;
    }

    void setNatural(final boolean natural) {
        this.natural = natural;
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
