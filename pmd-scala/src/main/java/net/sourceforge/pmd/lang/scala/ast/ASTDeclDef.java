/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Decl;

/**
 * The ASTDeclDef node implementation.
 */
public class ASTDeclDef extends AbstractScalaNode<Decl.Def> {

    @Deprecated
    @InternalApi
    public ASTDeclDef(final Decl.Def scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
