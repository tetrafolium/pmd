/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.symboltable.NameDeclaration;

public class ASTName extends AbstractJavaTypeNode {

    private NameDeclaration nd;

    @InternalApi
    @Deprecated
    public ASTName(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTName(final JavaParser p, final int id) {
        super(p, id);
    }

    @InternalApi
    @Deprecated
    public void setNameDeclaration(final NameDeclaration nd) {
        this.nd = nd;
    }

    public NameDeclaration getNameDeclaration() {
        return this.nd;
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
