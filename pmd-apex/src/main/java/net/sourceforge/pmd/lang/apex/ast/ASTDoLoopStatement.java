/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.DoLoopStatement;

public class ASTDoLoopStatement extends AbstractApexNode<DoLoopStatement> {

    @Deprecated
    @InternalApi
    public ASTDoLoopStatement(final DoLoopStatement doLoopStatement) {
        super(doLoopStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
