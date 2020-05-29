/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Importee;

/**
 * The ASTImporteeWildcard node implementation.
 */
public class ASTImporteeWildcard extends AbstractScalaNode<Importee.Wildcard> {

    @Deprecated
    @InternalApi
    public ASTImporteeWildcard(final Importee.Wildcard scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
