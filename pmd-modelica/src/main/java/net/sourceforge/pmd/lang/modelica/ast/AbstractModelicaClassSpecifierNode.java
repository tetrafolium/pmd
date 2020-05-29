/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.modelica.ast;

import net.sourceforge.pmd.lang.modelica.resolver.InternalModelicaResolverApi;
import net.sourceforge.pmd.lang.modelica.resolver.ModelicaClassType;

/**
 * Common parent for class-specifier nodes, see {@link ModelicaClassSpecifierNode} for public API.
 */
abstract class AbstractModelicaClassSpecifierNode extends AbstractModelicaNode implements ModelicaClassSpecifierNode {
    AbstractModelicaClassSpecifierNode(final int id) {
        super(id);
    }

    AbstractModelicaClassSpecifierNode(final ModelicaParser parser, final int id) {
        super(parser, id);
    }

    @Override
    public void jjtClose() {
        super.jjtClose();
        setImage(getFirstChildOfType(ASTSimpleName.class).getImage());
    }

    /**
     * Fills in the class definition with <code>extends</code> and <code>import</code> clauses contained in this AST node.
     *
     * @param classTypeDeclaration a class declaration object corresponding to this AST node
     */
    void populateExtendsAndImports(final ModelicaClassType classTypeDeclaration) {
        // by default, do nothing
    }

    private void pushExtendsAndImportsFromList(final ModelicaClassType classTypeDeclaration, final ASTElementList listNode) {
        for (int i = 0; i < listNode.getNumChildren(); ++i) {
            AbstractModelicaNode child = (AbstractModelicaNode) listNode.getChild(i);
            if (child instanceof ASTExtendsClause) {
                InternalModelicaResolverApi.addExtendToClass(
                        classTypeDeclaration,
                        listNode.getVisibility(),
                        child.getFirstChildOfType(ASTName.class).getCompositeName()
                );
            }
            if (child instanceof ASTImportClause) {
                InternalModelicaResolverApi.addImportToClass(
                        classTypeDeclaration,
                        listNode.getVisibility(),
                        child.getFirstChildOfType(ModelicaImportClause.class)
                );
            }
        }
    }

    void pushExtendsAndImports(final ModelicaClassType classTypeDeclaration, final ASTComposition composition) {
        for (int i = 0; i < composition.getNumChildren(); ++i) {
            ModelicaNode maybeElementList = composition.getChild(i);
            if (maybeElementList instanceof ASTElementList) {
                pushExtendsAndImportsFromList(classTypeDeclaration, (ASTElementList) maybeElementList);
            }
        }
    }

    @Override
    public String getSimpleClassName() {
        return getImage();
    }
}
