/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.ConstructorPreambleStatement;

public class ASTConstructorPreambleStatement extends AbstractApexNode<ConstructorPreambleStatement> {

    @Deprecated
    @InternalApi
    public ASTConstructorPreambleStatement(final ConstructorPreambleStatement constructorPreambleStatement) {
        super(constructorPreambleStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
