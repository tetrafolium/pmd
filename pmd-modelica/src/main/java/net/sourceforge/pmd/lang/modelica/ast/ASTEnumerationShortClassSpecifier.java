/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

public final class ASTEnumerationShortClassSpecifier extends AbstractModelicaClassSpecifierNode {
    ASTEnumerationShortClassSpecifier(final int id) {
        super(id);
    }

    ASTEnumerationShortClassSpecifier(final ModelicaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final ModelicaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
