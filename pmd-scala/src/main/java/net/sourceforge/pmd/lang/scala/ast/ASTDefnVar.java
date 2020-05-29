/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Defn;

/**
 * The ASTDefnVar node implementation.
 */
public class ASTDefnVar extends AbstractScalaNode<Defn.Var> {

    @Deprecated
    @InternalApi
    public ASTDefnVar(final Defn.Var scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
