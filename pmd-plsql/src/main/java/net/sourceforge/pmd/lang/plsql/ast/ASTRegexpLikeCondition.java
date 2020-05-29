/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTRegexpLikeCondition extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    private String matchParam;

    @Deprecated
    @InternalApi
    public ASTRegexpLikeCondition(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTRegexpLikeCondition(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    void setMatchParam(final String matchParam) {
        this.matchParam = matchParam;
    }

    public String getMatchParam() {
        return this.matchParam;
    }

    public ASTSqlExpression getSourceChar() {
        return (ASTSqlExpression) getChild(0);
    }

    public ASTSqlExpression getPattern() {
        return (ASTSqlExpression) getChild(1);
    }
}
