/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import java.util.Map;

import net.sourceforge.pmd.properties.modules.PackagedPropertyModule;


/**
 * Property which restricts the type of its values to some packages. If the legalPackageNames value is set to null then
 * no restrictions are made.
 *
 * @param <T> The type of the values
 *
 * @author Brian Remedios
 * @author Clément Fournier
 * @version Refactored June 2017 (6.0.0)
 */
@Deprecated
/* default */ abstract class AbstractPackagedProperty<T> extends AbstractSingleValueProperty<T>
        implements PackagedPropertyDescriptor<T> {

    protected final PackagedPropertyModule<T> module;


    /**
     * Create a packaged property.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param theDefault     Default value
     * @param theUIOrder     UI order
     * @param module
     *
     * @throws IllegalArgumentException
     */
    protected AbstractPackagedProperty(final String theName, final String theDescription, final T theDefault,
                                       final float theUIOrder, final boolean isDefinedExternally,
                                       final PackagedPropertyModule<T> module) {
        super(theName, theDescription, theDefault, theUIOrder, isDefinedExternally);
        this.module = module;
    }


    @Override
    protected void addAttributesTo(final Map<PropertyDescriptorField, String> attributes) {
        super.addAttributesTo(attributes);
        module.addAttributesTo(attributes);
    }


    @Override
    protected String valueErrorFor(final T value) {
        return module.valueErrorFor(value);
    }


    @Override
    public String[] legalPackageNames() {
        return module.legalPackageNames();
    }


    protected String[] packageNamesIn(final Map<PropertyDescriptorField, String> params) {
        return module.packageNamesIn(params);
    }

}
