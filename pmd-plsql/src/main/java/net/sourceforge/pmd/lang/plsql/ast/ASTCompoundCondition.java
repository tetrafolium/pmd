/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import java.util.Locale;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTCompoundCondition extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    private String type;

    @Deprecated
    @InternalApi
    public ASTCompoundCondition(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTCompoundCondition(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
        if (this.type != null) {
            this.type = this.type.toUpperCase(Locale.ROOT);
        }
    }
}
