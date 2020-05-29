/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

import net.sourceforge.pmd.lang.modelica.resolver.InternalModelicaResolverApi;
import net.sourceforge.pmd.lang.modelica.resolver.ModelicaClassType;

public final class ASTSimpleShortClassSpecifier extends AbstractModelicaClassSpecifierNode {
    ASTSimpleShortClassSpecifier(final int id) {
        super(id);
    }

    ASTSimpleShortClassSpecifier(final ModelicaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final ModelicaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void populateExtendsAndImports(final ModelicaClassType classTypeDeclaration) {
        super.populateExtendsAndImports(classTypeDeclaration);
        InternalModelicaResolverApi.addExtendToClass(
                classTypeDeclaration,
                Visibility.UNSPEC,
                getFirstChildOfType(ASTName.class).getCompositeName()
        );
    }
}
