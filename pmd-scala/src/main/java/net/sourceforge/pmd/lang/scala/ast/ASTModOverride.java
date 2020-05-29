/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Mod;

/**
 * The ASTModOverride node implementation.
 */
public class ASTModOverride extends AbstractScalaNode<Mod.Override> {

    @Deprecated
    @InternalApi
    public ASTModOverride(final Mod.Override scalaNode) {
        super(scalaNode);
    }

    // java.lang package is required or else PMD can't see this Override
    @java.lang.Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
