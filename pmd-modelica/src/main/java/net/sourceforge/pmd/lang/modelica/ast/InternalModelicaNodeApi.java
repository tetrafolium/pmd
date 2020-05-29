/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.modelica.resolver.ModelicaClassType;
import net.sourceforge.pmd.lang.modelica.resolver.ModelicaScope;
import net.sourceforge.pmd.lang.modelica.resolver.ResolutionContext;
import net.sourceforge.pmd.lang.modelica.resolver.Watchdog;

@InternalApi
public final class InternalModelicaNodeApi {
    private InternalModelicaNodeApi() { }

    public static void setNodeOwnScope(final ModelicaNode node, final ModelicaScope scope) {
        ((AbstractModelicaNode) node).setOwnScope(scope);
    }

    public static boolean isQualifiedImport(final ModelicaImportClause importClause) {
        return ((AbstractModelicaImportClause) importClause).isQualified();
    }

    public static void resolveImportedSimpleName(final ModelicaImportClause importClause, final ResolutionContext result, final String simpleName) throws Watchdog.CountdownException {
        ((AbstractModelicaImportClause) importClause).resolveSimpleName(result, simpleName);
    }

    public static void populateExtendsAndImports(final ModelicaClassSpecifierNode classNode, final ModelicaClassType classTypeDeclaration) {
        ((AbstractModelicaClassSpecifierNode) classNode).populateExtendsAndImports(classTypeDeclaration);
    }
}
