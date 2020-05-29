/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Mod;

/**
 * The ASTModProtected node implementation.
 */
public class ASTModProtected extends AbstractScalaNode<Mod.Protected> {

    @Deprecated
    @InternalApi
    public ASTModProtected(final Mod.Protected scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
