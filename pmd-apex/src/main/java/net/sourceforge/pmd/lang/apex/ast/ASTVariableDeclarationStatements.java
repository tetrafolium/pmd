/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.VariableDeclarationStatements;

public class ASTVariableDeclarationStatements extends AbstractApexNode<VariableDeclarationStatements> {

    @Deprecated
    @InternalApi
    public ASTVariableDeclarationStatements(final VariableDeclarationStatements variableDeclarationStatements) {
        super(variableDeclarationStatements);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public ASTModifierNode getModifiers() {
        return getFirstChildOfType(ASTModifierNode.class);
    }
}
