/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.compilation.ConstructorPreamble;

public class ASTConstructorPreamble extends AbstractApexNode<ConstructorPreamble> {

    @Deprecated
    @InternalApi
    public ASTConstructorPreamble(final ConstructorPreamble node) {
        super(node);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
