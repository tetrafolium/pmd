/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Lit;

/**
 * The ASTLitBoolean node implementation.
 */
public class ASTLitBoolean extends AbstractScalaNode<Lit.Boolean> {

    @Deprecated
    @InternalApi
    public ASTLitBoolean(final Lit.Boolean scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }

    @Override
    public String getImage() {
        return String.valueOf(node.value());
    }
}
