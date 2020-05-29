/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

import net.sourceforge.pmd.annotation.InternalApi;

import apex.jorje.semantic.ast.statement.RunAsBlockStatement;

public class ASTRunAsBlockStatement extends AbstractApexNode<RunAsBlockStatement> {

    @Deprecated
    @InternalApi
    public ASTRunAsBlockStatement(final RunAsBlockStatement runAsBlockStatement) {
        super(runAsBlockStatement);
    }

    @Override
    public Object jjtAccept(final ApexParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
