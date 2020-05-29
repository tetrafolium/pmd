/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTFormalParameter extends net.sourceforge.pmd.lang.plsql.ast.AbstractPLSQLNode {
    private boolean in;
    private boolean out;
    private boolean nocopy;

    @Deprecated
    @InternalApi
    public ASTFormalParameter(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTFormalParameter(final PLSQLParser p, final int id) {
        super(p, id);
    }

    public boolean isIn() {
        return this.in;
    }

    void setIn(final boolean in) {
        this.in = in;
    }

    public boolean isOut() {
        return this.out;
    }

    void setOut(final boolean out) {
        this.out = out;
    }

    public boolean isNoCopy() {
        return this.nocopy;
    }

    void setNoCopy(final boolean nocopy) {
        this.nocopy = nocopy;
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public ASTDatatype getTypeNode() {
        for (int i = 0; i < getNumChildren(); i++) {
            if (getChild(i) instanceof ASTDatatype) {
                return (ASTDatatype) getChild(i);
            }
        }
        throw new IllegalStateException("ASTType not found");
    }
}
