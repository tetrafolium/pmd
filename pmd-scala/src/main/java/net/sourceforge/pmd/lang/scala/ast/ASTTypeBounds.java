/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Type;

/**
 * The ASTTypeBounds node implementation.
 */
public class ASTTypeBounds extends AbstractScalaNode<Type.Bounds> {

    @Deprecated
    @InternalApi
    public ASTTypeBounds(final Type.Bounds scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
