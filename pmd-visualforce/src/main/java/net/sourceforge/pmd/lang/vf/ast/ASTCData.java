/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.vf.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTCData extends AbstractVFNode {
    @Deprecated
    @InternalApi
    public ASTCData(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTCData(final VfParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final VfParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
