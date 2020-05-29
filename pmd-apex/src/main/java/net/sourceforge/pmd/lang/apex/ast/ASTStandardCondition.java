/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.condition.StandardCondition;

public class ASTStandardCondition extends AbstractApexNode<StandardCondition> {

    @Deprecated
    @InternalApi
    public ASTStandardCondition(final StandardCondition standardCondition) {
        super(standardCondition);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
