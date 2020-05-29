/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import static net.sourceforge.pmd.properties.ValueParserConstants.BOOLEAN_PARSER;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.pmd.properties.builders.MultiValuePropertyBuilder;
import net.sourceforge.pmd.properties.builders.PropertyDescriptorBuilderConversionWrapper;


/**
 * Defines a property type that supports multiple Boolean values.
 *
 * @author Brian Remedios
 * @deprecated Not useful, will be removed with 7.0.0
 */
@Deprecated
public final class BooleanMultiProperty extends AbstractMultiValueProperty<Boolean> {


    /**
     * Constructor using an array of defaults.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param defaultValues  List of defaults
     * @param theUIOrder     UI order
     *
     * @deprecated Not useful, will be removed with 7.0.0
     */
    @Deprecated
    public BooleanMultiProperty(final String theName, final String theDescription, final Boolean[] defaultValues, final float theUIOrder) {
        this(theName, theDescription, Arrays.asList(defaultValues), theUIOrder, false);
    }


    /** Master constructor. */
    private BooleanMultiProperty(final String theName, final String theDescription, final List<Boolean> defaultValues,
                                 final float theUIOrder, final boolean isDefinedExternally) {
        super(theName, theDescription, defaultValues, theUIOrder, isDefinedExternally);
    }


    /**
     * Constructor using a list of defaults.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param defaultValues  List of defaults
     * @param theUIOrder     UI order
     *
     * @deprecated Not useful, will be removed with 7.0.0
     */
    @Deprecated
    public BooleanMultiProperty(final String theName, final String theDescription, final List<Boolean> defaultValues, final float theUIOrder) {
        this(theName, theDescription, defaultValues, theUIOrder, false);
    }


    @Override
    protected Boolean createFrom(final String toParse) {
        return BOOLEAN_PARSER.valueOf(toParse);
    }


    @Override
    public Class<Boolean> type() {
        return Boolean.class;
    }


    static PropertyDescriptorBuilderConversionWrapper.MultiValue<Boolean, BooleanMultiPBuilder> extractor() {
        return new PropertyDescriptorBuilderConversionWrapper.MultiValue<Boolean, BooleanMultiPBuilder>(Boolean.class, ValueParserConstants.BOOLEAN_PARSER) {
            @Override
            protected BooleanMultiPBuilder newBuilder(final String name) {
                return new BooleanMultiPBuilder(name);
            }
        };
    }


    /**
     * @deprecated Not useful, will be removed with 7.0.0
     */
    @Deprecated
    public static BooleanMultiPBuilder named(final String name) {
        return new BooleanMultiPBuilder(name);
    }


    /**
     * @deprecated Not useful, will be removed with 7.0.0
     */
    @Deprecated
    public static final class BooleanMultiPBuilder extends MultiValuePropertyBuilder<Boolean, BooleanMultiPBuilder> {
        private BooleanMultiPBuilder(final String name) {
            super(name);
        }


        @Override
        public BooleanMultiProperty build() {
            return new BooleanMultiProperty(this.name, this.description, this.defaultValues, this.uiOrder, isDefinedInXML);
        }
    }

}
