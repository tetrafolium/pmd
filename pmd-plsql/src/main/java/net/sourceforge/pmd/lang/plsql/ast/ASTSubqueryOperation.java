/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTSubqueryOperation extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    private boolean union;
    private boolean all;
    private boolean intersect;
    private boolean minus;

    @Deprecated
    @InternalApi
    public ASTSubqueryOperation(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTSubqueryOperation(final PLSQLParser p, final int id) {
        super(p, id);
    }

    public boolean isAll() {
        return all;
    }

    void setAll(final boolean all) {
        this.all = all;
    }

    public boolean isIntersect() {
        return intersect;
    }

    void setIntersect(final boolean intersect) {
        this.intersect = intersect;
    }

    public boolean isMinus() {
        return minus;
    }

    void setMinus(final boolean minus) {
        this.minus = minus;
    }

    public boolean isUnion() {
        return union;
    }

    void setUnion(final boolean union) {
        this.union = union;
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
