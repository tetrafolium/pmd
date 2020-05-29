/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.filter;

/**
 * A logical NEGATION of a Filter.
 *
 * @param <T>
 *            The underlying type on which the filter applies.
 * @deprecated See {@link Filter}
 */
@Deprecated
public class NotFilter<T> extends AbstractDelegateFilter<T> {
    public NotFilter() {
        super();
    }

    public NotFilter(final Filter<T> filter) {
        super(filter);
    }

    @Override
    public boolean filter(final T obj) {
        return !filter.filter(obj);
    }

    @Override
    public String toString() {
        return "not (" + filter + ")";
    }
}
