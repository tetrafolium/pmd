/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Term;

/**
 * The ASTTermTryWithHandler node implementation.
 */
public class ASTTermTryWithHandler extends AbstractScalaNode<Term.TryWithHandler> {

    @Deprecated
    @InternalApi
    public ASTTermTryWithHandler(final Term.TryWithHandler scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
