/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.ast.RootNode;

public class ASTInput extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode implements RootNode {
    private String sourcecode;

    @Deprecated
    @InternalApi
    public ASTInput(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTInput(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    void setSourcecode(final String sourcecode) {
        this.sourcecode = sourcecode;
    }

    public String getSourcecode() {
        return sourcecode;
    }
}
