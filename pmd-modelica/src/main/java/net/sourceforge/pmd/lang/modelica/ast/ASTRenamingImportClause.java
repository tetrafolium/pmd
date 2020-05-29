/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

import net.sourceforge.pmd.lang.modelica.resolver.ModelicaDeclaration;
import net.sourceforge.pmd.lang.modelica.resolver.ModelicaScope;
import net.sourceforge.pmd.lang.modelica.resolver.ResolutionContext;
import net.sourceforge.pmd.lang.modelica.resolver.ResolutionResult;
import net.sourceforge.pmd.lang.modelica.resolver.ResolutionState;

public final class ASTRenamingImportClause extends AbstractModelicaImportClause {
    private ASTName importWhat;
    private String renamedTo;

    ASTRenamingImportClause(final int id) {
        super(id);
    }

    ASTRenamingImportClause(final ModelicaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final ModelicaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void jjtClose() {
        super.jjtClose();

        importWhat = getFirstChildOfType(ASTName.class);
        renamedTo = getFirstChildOfType(ASTSimpleName.class).getImage();
    }

    @Override
    protected ResolutionResult<ModelicaDeclaration> getCacheableImportSources(final ResolutionState state, final ModelicaScope scope) {
        return scope.safeResolveLexically(ModelicaDeclaration.class, state, importWhat.getCompositeName());
    }

    @Override
    protected void fetchImportedClassesFromSource(final ResolutionContext result, final ModelicaDeclaration source, final String simpleName) {
        if (renamedTo.equals(simpleName)) {
            result.addCandidate(source);
        }
    }

    @Override
    public boolean isQualified() {
        return true;
    }
}
