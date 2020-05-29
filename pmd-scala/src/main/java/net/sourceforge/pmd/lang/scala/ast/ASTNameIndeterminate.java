/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Name;

/**
 * The ASTNameIndeterminate node implementation.
 */
public class ASTNameIndeterminate extends AbstractScalaNode<Name.Indeterminate> {

    @Deprecated
    @InternalApi
    public ASTNameIndeterminate(final Name.Indeterminate scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }

    @Override
    public String getImage() {
        return node.value();
    }
}
