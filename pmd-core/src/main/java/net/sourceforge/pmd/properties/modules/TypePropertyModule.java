/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties.modules;

import java.util.List;


/**
 * Factorises common functionality for type properties.
 *
 * @author Clément Fournier
 */
@Deprecated
public class TypePropertyModule extends PackagedPropertyModule<Class> {

    public TypePropertyModule(final String[] legalPackageNames, final List<Class> defaults) {
        super(legalPackageNames, defaults);
    }


    @Override
    protected String packageNameOf(final Class item) {
        return item.getName();
    }


    @Override
    protected String itemTypeName() {
        return "type";
    }

}
