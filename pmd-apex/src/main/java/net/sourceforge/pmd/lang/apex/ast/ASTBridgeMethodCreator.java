/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.member.bridge.BridgeMethodCreator;

public class ASTBridgeMethodCreator extends AbstractApexNode<BridgeMethodCreator> {

    @Deprecated
    @InternalApi
    public ASTBridgeMethodCreator(final BridgeMethodCreator bridgeMethodCreator) {
        super(bridgeMethodCreator);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
