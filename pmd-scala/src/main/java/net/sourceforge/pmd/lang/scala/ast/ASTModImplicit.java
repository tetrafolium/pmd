/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Mod;

/**
 * The ASTModImplicit node implementation.
 */
public class ASTModImplicit extends AbstractScalaNode<Mod.Implicit> {

    @Deprecated
    @InternalApi
    public ASTModImplicit(final Mod.Implicit scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
