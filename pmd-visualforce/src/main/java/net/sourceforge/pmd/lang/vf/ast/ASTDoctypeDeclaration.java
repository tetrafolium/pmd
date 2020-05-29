/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.vf.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTDoctypeDeclaration extends AbstractVFNode {

    /**
     * Name of the document type. Cannot be null.
     */
    private String name;

    @Deprecated
    @InternalApi
    public ASTDoctypeDeclaration(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTDoctypeDeclaration(final VfParser p, final int id) {
        super(p, id);
    }

    public String getName() {
        return name;
    }

    @Deprecated
    @InternalApi
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public Object jjtAccept(final VfParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
