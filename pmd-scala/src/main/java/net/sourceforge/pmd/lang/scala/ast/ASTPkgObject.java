/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Pkg;

/**
 * The ASTPkgObject node implementation.
 */
public class ASTPkgObject extends AbstractScalaNode<Pkg.Object> {

    @Deprecated
    @InternalApi
    public ASTPkgObject(final Pkg.Object scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
