/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Enumerator;

/**
 * The ASTEnumeratorGenerator node implementation.
 */
public class ASTEnumeratorGenerator extends AbstractScalaNode<Enumerator.Generator> {

    @Deprecated
    @InternalApi
    public ASTEnumeratorGenerator(final Enumerator.Generator scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
