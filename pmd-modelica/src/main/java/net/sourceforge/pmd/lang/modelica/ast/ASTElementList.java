/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

public class ASTElementList extends AbstractModelicaNode {
    private Visibility visibility;

    ASTElementList(final int id) {
        super(id);
    }

    ASTElementList(final ModelicaParser p, final int id) {
        super(p, id);
    }

    void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    @Override
    public Object jjtAccept(final ModelicaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
