/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.resolver;

import java.util.ArrayDeque;
import java.util.Deque;

import net.sourceforge.pmd.lang.modelica.ast.ASTClassDefinition;
import net.sourceforge.pmd.lang.modelica.ast.ASTComponentDeclaration;
import net.sourceforge.pmd.lang.modelica.ast.ASTStoredDefinition;
import net.sourceforge.pmd.lang.modelica.ast.InternalModelicaNodeApi;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaNode;
import net.sourceforge.pmd.lang.modelica.ast.ModelicaParserVisitorAdapter;

public class ScopeAndDeclarationFinder extends ModelicaParserVisitorAdapter {
    private final Deque<AbstractModelicaScope> scopes = new ArrayDeque<>();

    ScopeAndDeclarationFinder() {
        scopes.push(new RootScope());
    }

    private void pushScope(final ModelicaNode node, final AbstractModelicaScope ownScope) {
        AbstractModelicaScope prevTop = scopes.peek();
        ownScope.setParent(prevTop);
        scopes.push(ownScope);
        InternalModelicaNodeApi.setNodeOwnScope(node, ownScope);
    }

    private void createClassDeclaration(final ASTClassDefinition node) {
        ModelicaScope containingScope = node.getParent().getMostSpecificScope();
        ModelicaClassDeclaration declaration = new ModelicaClassDeclaration(node);
        ((AbstractModelicaScope) containingScope).addDeclaration(declaration);

        pushScope(node, new ModelicaClassScope(declaration));
    }

    private void createFileDeclaration(final ASTStoredDefinition node) {
        RootScope rootScope = (RootScope) scopes.peek();
        ModelicaSourceFileScope scope = new ModelicaSourceFileScope(node);
        rootScope.addSourceFile(scope);
        pushScope(node, scope);
    }

    private void createComponentDeclaration(final ASTComponentDeclaration node) {
        ModelicaComponentDeclaration declaration = new ModelicaComponentDeclaration(node);
        declaration.setContainingScope((ModelicaClassScope) scopes.peek());
        ((AbstractModelicaScope) node.getMostSpecificScope()).addDeclaration(declaration);
    }

    @Override
    public Object visit(final ASTStoredDefinition node, final Object data) {
        createFileDeclaration(node);
        return cont(node);
    }

    @Override
    public Object visit(final ASTClassDefinition node, final Object data) {
        createClassDeclaration(node);
        return cont(node);
    }

    @Override
    public Object visit(final ASTComponentDeclaration node, final Object data) {
        createComponentDeclaration(node);
        return super.visit(node, data);
    }

    private Object cont(final ModelicaNode node) {
        super.visit(node, null);
        scopes.pop();
        return null;
    }
}
