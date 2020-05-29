/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Decl;

/**
 * The ASTDeclType node implementation.
 */
public class ASTDeclType extends AbstractScalaNode<Decl.Type> {

    @Deprecated
    @InternalApi
    public ASTDeclType(final Decl.Type scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
