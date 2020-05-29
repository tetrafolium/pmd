/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.JavaMethodCallExpression;

public class ASTJavaMethodCallExpression extends AbstractApexNode<JavaMethodCallExpression> {

    @Deprecated
    @InternalApi
    public ASTJavaMethodCallExpression(final JavaMethodCallExpression javaMethodCallExpression) {
        super(javaMethodCallExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
