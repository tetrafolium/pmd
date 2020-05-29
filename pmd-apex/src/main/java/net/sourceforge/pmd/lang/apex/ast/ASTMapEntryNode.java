/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.MapEntryNode;

public class ASTMapEntryNode extends AbstractApexNode<MapEntryNode> {

    @Deprecated
    @InternalApi
    public ASTMapEntryNode(final MapEntryNode mapEntryNode) {
        super(mapEntryNode);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
