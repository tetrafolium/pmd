/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.Block;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTBlock extends AbstractEcmascriptNode<Block> {
    @Deprecated
    @InternalApi
    public ASTBlock(final Block block) {
        super(block);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
