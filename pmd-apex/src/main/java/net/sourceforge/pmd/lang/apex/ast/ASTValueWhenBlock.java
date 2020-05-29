/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import apex.jorje.semantic.ast.statement.ValueWhenBlock;

public final class ASTValueWhenBlock extends AbstractApexNode<ValueWhenBlock> {


    ASTValueWhenBlock(final ValueWhenBlock node) {
        super(node);
    }


    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
