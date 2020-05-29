/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTJspDirectiveAttribute extends AbstractJspNode {

    private String name;
    private String value;

    @InternalApi
    @Deprecated
    public ASTJspDirectiveAttribute(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTJspDirectiveAttribute(final JspParser p, final int id) {
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

    public String getValue() {
        return value;
    }

    @InternalApi
    @Deprecated
    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public Object jjtAccept(final JspParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
