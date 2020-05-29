/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import java.util.List;
import java.util.Map;

import net.sourceforge.pmd.properties.modules.PackagedPropertyModule;


/**
 * Multi-valued property restricting the type of its values to some packages.
 *
 * @param <T> The type of the values
 *
 * @author Brian Remedios
 * @author Clément Fournier
 * @version Refactored June 2017 (6.0.0)
 */
@Deprecated
/* default */ abstract class AbstractMultiPackagedProperty<T> extends AbstractMultiValueProperty<T>
        implements PackagedPropertyDescriptor<List<T>> {


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
    protected AbstractMultiPackagedProperty(final String theName, final String theDescription, final List<T> theDefault,
                                            final float theUIOrder, final boolean isDefinedExternally,
                                            final PackagedPropertyModule<T> module) {
        super(theName, theDescription, theDefault, theUIOrder, MULTI_VALUE_DELIMITER, isDefinedExternally);
        this.module = module;
    }


    @Override
    protected void addAttributesTo(final Map<PropertyDescriptorField, String> attributes) {
        super.addAttributesTo(attributes);
        module.addAttributesTo(attributes);
    }


    @Override
    protected String valueErrorFor(final T value) {
        if (value == null) {
            String err = super.valueErrorFor(null);
            if (err != null) {
                return err;
            }
        }

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
