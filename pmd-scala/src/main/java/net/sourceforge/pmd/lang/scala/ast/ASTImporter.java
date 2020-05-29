/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.scala.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import scala.meta.Importer;

/**
 * The ASTImporter node implementation.
 */
public class ASTImporter extends AbstractScalaNode<Importer> {

    @Deprecated
    @InternalApi
    public ASTImporter(final Importer scalaNode) {
        super(scalaNode);
    }

    @Override
    public <D, R> R accept(final ScalaParserVisitor<D, R> visitor, final D data) {
        return visitor.visit(this, data);
    }
}
