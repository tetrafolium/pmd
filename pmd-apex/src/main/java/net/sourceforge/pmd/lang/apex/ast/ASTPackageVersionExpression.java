/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.PackageVersionExpression;

public class ASTPackageVersionExpression extends AbstractApexNode<PackageVersionExpression> {

    @Deprecated
    @InternalApi
    public ASTPackageVersionExpression(final PackageVersionExpression packageVersionExpression) {
        super(packageVersionExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
