/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.BreakStatement;

public class ASTBreakStatement extends AbstractApexNode<BreakStatement> {

    @Deprecated
    @InternalApi
    public ASTBreakStatement(final BreakStatement breakStatement) {
        super(breakStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
