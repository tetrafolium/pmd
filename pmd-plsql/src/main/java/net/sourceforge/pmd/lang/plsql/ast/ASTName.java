/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.symboltable.NameDeclaration;

public class ASTName extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    @Deprecated
    @InternalApi
    public ASTName(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTName(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    private NameDeclaration nd;

    @Deprecated
    @InternalApi
    public void setNameDeclaration(final NameDeclaration nd) {
        this.nd = nd;
    }

    public NameDeclaration getNameDeclaration() {
        return this.nd;
    }
}
