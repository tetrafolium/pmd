/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Pat;

/**
 * The ASTPatSeqWildcard node implementation.
 */
public class ASTPatSeqWildcard extends AbstractScalaNode<Pat.SeqWildcard> {

    @Deprecated
    @InternalApi
    public ASTPatSeqWildcard(final Pat.SeqWildcard scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
