/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import apex.jorje.semantic.ast.statement.SwitchStatement;

public final class ASTSwitchStatement extends AbstractApexNode<SwitchStatement> {


    ASTSwitchStatement(final SwitchStatement node) {
        super(node);
    }


    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
