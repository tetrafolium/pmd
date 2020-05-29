/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Type;

/**
 * The ASTTypeApplyInfix node implementation.
 */
public class ASTTypeApplyInfix extends AbstractScalaNode<Type.ApplyInfix> {

    @Deprecated
    @InternalApi
    public ASTTypeApplyInfix(final Type.ApplyInfix scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
