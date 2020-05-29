/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.dfa.DFAGraphMethod;

public class ASTTypeMethod extends AbstractPLSQLNode implements ExecutableCode, DFAGraphMethod {
    @Deprecated
    @InternalApi
    public ASTTypeMethod(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTTypeMethod(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    /**
     * Gets the name of the method.
     *
     * @return a String representing the name of the method
     */
    @Override
    public String getMethodName() {
        ASTMethodDeclarator md = getFirstChildOfType(ASTMethodDeclarator.class);
        if (md != null) {
            return md.getImage();
        }
        return null;
    }

    @Override
    public String getName() {
        return getMethodName();
    }
}
