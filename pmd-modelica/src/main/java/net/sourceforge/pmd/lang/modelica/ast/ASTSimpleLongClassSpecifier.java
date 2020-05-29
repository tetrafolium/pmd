/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

import net.sourceforge.pmd.lang.modelica.resolver.ModelicaClassType;

public final class ASTSimpleLongClassSpecifier extends AbstractModelicaClassSpecifierNode {
    ASTSimpleLongClassSpecifier(final int id) {
        super(id);
    }

    ASTSimpleLongClassSpecifier(final ModelicaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final ModelicaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    void populateExtendsAndImports(final ModelicaClassType classTypeDeclaration) {
        super.populateExtendsAndImports(classTypeDeclaration);
        pushExtendsAndImports(classTypeDeclaration, getFirstChildOfType(ASTComposition.class));
    }
}
