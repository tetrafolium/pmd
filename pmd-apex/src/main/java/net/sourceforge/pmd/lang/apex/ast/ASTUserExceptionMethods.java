/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.compilation.UserExceptionMethods;

public class ASTUserExceptionMethods extends AbstractApexNode<UserExceptionMethods> {

    @Deprecated
    @InternalApi
    public ASTUserExceptionMethods(final UserExceptionMethods userExceptionMethods) {
        super(userExceptionMethods);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
