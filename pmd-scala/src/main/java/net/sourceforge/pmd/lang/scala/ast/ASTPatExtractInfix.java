/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Pat;

/**
 * The ASTPatExtractInfix node implementation.
 */
public class ASTPatExtractInfix extends AbstractScalaNode<Pat.ExtractInfix> {

    @Deprecated
    @InternalApi
    public ASTPatExtractInfix(final Pat.ExtractInfix scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
