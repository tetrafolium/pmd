/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.dfa.DFAGraphMethod;

public class ASTTriggerTimingPointSection extends AbstractPLSQLNode implements ExecutableCode, DFAGraphMethod {
    @Deprecated
    @InternalApi
    public ASTTriggerTimingPointSection(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTTriggerTimingPointSection(final PLSQLParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final PLSQLParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    /**
     * return executable's name.
     *
     * @return
     */
    @Override
    public String getMethodName() {
        return getImage();
    }

    @Override
    public String getName() {
        return getMethodName();
    }
}
