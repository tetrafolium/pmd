/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.expression.ClassRefExpression;

public class ASTClassRefExpression extends AbstractApexNode<ClassRefExpression> {

    @Deprecated
    @InternalApi
    public ASTClassRefExpression(final ClassRefExpression classRefExpression) {
        super(classRefExpression);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
