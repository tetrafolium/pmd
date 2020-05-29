/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.filter;

/**
 * A logical OR of a list of Filters. This implementation is short circuiting.
 *
 * @param <T>
 *            The underlying type on which the filter applies.
 * @deprecated See {@link Filter}
 */
@Deprecated
public class OrFilter<T> extends AbstractCompoundFilter<T> {

    public OrFilter() {
        super();
    }

    public OrFilter(final Filter<T>... filters) {
        super(filters);
    }

    @Override
    public boolean filter(final T obj) {
        boolean match = false;
        for (Filter<T> filter : filters) {
            if (filter.filter(obj)) {
                match = true;
                break;
            }
        }
        return match;
    }

    @Override
    protected String getOperator() {
        return "or";
    }
}
