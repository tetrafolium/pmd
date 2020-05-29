/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast.xpath;

import org.jaxen.Navigator;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.Language;
import net.sourceforge.pmd.lang.XPathHandler;

import net.sf.saxon.sxpath.IndependentContext;


@Deprecated
@InternalApi
public abstract class AbstractASTXPathHandler implements XPathHandler {

    @Override
    public Navigator getNavigator() {
        return new DocumentNavigator();
    }

    public void initialize(final IndependentContext context, final Language language, final Class<?> functionsClass) {
        context.declareNamespace("pmd-" + language.getTerseName(), "java:" + functionsClass.getName());
    }

    @Override
    public void initialize() {
        // override if needed
    }

    @Override
    public void initialize(final IndependentContext context) {
        // override if needed
    }
}
