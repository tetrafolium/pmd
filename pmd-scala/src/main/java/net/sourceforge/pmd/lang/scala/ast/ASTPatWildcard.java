/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Pat;

/**
 * The ASTPatWildcard node implementation.
 */
public class ASTPatWildcard extends AbstractScalaNode<Pat.Wildcard> {

    @Deprecated
    @InternalApi
    public ASTPatWildcard(final Pat.Wildcard scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
