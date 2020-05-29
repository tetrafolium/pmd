/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTDeclaration extends AbstractJspNode {

    private String name;

    @InternalApi
    @Deprecated
    public ASTDeclaration(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTDeclaration(final JspParser p, final int id) {
        super(p, id);
    }

    public String getName() {
        return name;
    }

    @InternalApi
    @Deprecated
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public Object jjtAccept(final JspParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
