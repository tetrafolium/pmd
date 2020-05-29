/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.ast;

import net.sourceforge.pmd.annotation.InternalApi;

@Deprecated
@InternalApi
public abstract class AbstractSelectStatement extends AbstractPLSQLNode {

    private boolean distinct;
    private boolean unique;
    private boolean all;

    public AbstractSelectStatement(final int i) {
        super(i);
    }

    public AbstractSelectStatement(final PLSQLParser p, final int i) {
        super(p, i);
    }

    protected void setDistinct(final boolean distinct) {
        this.distinct = true;
    }

    public boolean isDistinct() {
        return distinct;
    }

    protected void setUnique(final boolean unique) {
        this.unique = unique;
    }

    public boolean isUnique() {
        return unique;
    }

    protected void setAll(final boolean all) {
        this.all = all;
    }

    public boolean isAll() {
        return all;
    }

}
