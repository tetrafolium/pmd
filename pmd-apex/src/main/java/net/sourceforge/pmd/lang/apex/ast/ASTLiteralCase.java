/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import apex.jorje.semantic.ast.statement.WhenCases.LiteralCase;

public final class ASTLiteralCase extends AbstractApexNode<LiteralCase> {


    ASTLiteralCase(final LiteralCase node) {
        super(node);
    }


    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
