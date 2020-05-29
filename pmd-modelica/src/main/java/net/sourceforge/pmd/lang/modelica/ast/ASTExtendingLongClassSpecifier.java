/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

import net.sourceforge.pmd.lang.modelica.resolver.ModelicaClassType;

public final class ASTExtendingLongClassSpecifier extends AbstractModelicaClassSpecifierNode {
    ASTExtendingLongClassSpecifier(final int id) {
        super(id);
    }

    ASTExtendingLongClassSpecifier(final ModelicaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final ModelicaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void populateExtendsAndImports(final ModelicaClassType classTypeDeclaration) {
        super.populateExtendsAndImports(classTypeDeclaration);
        pushExtendsAndImports(classTypeDeclaration, getFirstChildOfType(ASTComposition.class));
        // TODO
    }
}
