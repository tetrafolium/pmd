/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Ctor;

/**
 * The ASTCtorSecondary node implementation.
 */
public class ASTCtorSecondary extends AbstractScalaNode<Ctor.Secondary> {

    @Deprecated
    @InternalApi
    public ASTCtorSecondary(final Ctor.Secondary scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
