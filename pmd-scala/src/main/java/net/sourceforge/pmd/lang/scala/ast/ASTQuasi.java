/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Tree.Quasi;

/**
 * The ASTQuasi node implementation.
 */
public class ASTQuasi extends AbstractScalaNode<Quasi> {

    @Deprecated
    @InternalApi
    public ASTQuasi(final Quasi scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
