/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTAttributeValue extends AbstractJspNode {
    @InternalApi
    @Deprecated
    public ASTAttributeValue(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTAttributeValue(final JspParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JspParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
