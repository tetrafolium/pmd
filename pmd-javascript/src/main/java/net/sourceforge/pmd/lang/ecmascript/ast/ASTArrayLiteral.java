/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.ArrayLiteral;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTArrayLiteral extends AbstractEcmascriptNode<ArrayLiteral>
        implements DestructuringNode, TrailingCommaNode {
    private boolean trailingComma;

    @Deprecated
    @InternalApi
    public ASTArrayLiteral(final ArrayLiteral arrayLiteral) {
        super(arrayLiteral);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public boolean isDestructuring() {
        return node.isDestructuring();
    }

    @Override
    public boolean isTrailingComma() {
        return trailingComma;
    }

    @Override
    @Deprecated
    @InternalApi
    public void setTrailingComma(final boolean trailingComma) {
        setTrailingCommaExists(trailingComma);
    }

    @Override
    protected void setTrailingCommaExists(final boolean b) {
        this.trailingComma = b;
    }
}
