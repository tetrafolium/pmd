/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.pmd.properties.builders.MultiNumericPropertyBuilder;
import net.sourceforge.pmd.properties.builders.PropertyDescriptorBuilderConversionWrapper;


/**
 * Multi-valued long property.
 *
 * @author Brian Remedios
 * @version Refactored June 2017 (6.0.0)
 *
 * @deprecated Use a {@code PropertyDescriptor<List<Long>>} instead. A builder is available from {@link PropertyFactory#longIntListProperty(String)}.
 *             This class will be removed in 7.0.0.
 */
@Deprecated
public final class LongMultiProperty extends AbstractMultiNumericProperty<Long> {


    /**
     * Constructor using an array of defaults.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param min            Minimum value of the property
     * @param max            Maximum value of the property
     * @param defaultValues  Array of defaults
     * @param theUIOrder     UI order
     *
     * @throws IllegalArgumentException if {@literal min > max} or one of the defaults is not between the bounds
     * @deprecated Use {@link PropertyFactory#longIntListProperty(String)}
     */
    @Deprecated
    public LongMultiProperty(final String theName, final String theDescription, final Long min, final Long max,
                             final Long[] defaultValues, final float theUIOrder) {
        this(theName, theDescription, min, max, Arrays.asList(defaultValues), theUIOrder, false);
    }


    /** Master constructor. */
    private LongMultiProperty(final String theName, final String theDescription, final Long min, final Long max,
                              final List<Long> defaultValues, final float theUIOrder, final boolean isDefinedExternally) {
        super(theName, theDescription, min, max, defaultValues, theUIOrder, isDefinedExternally);
    }


    /**
     * Constructor using a list of defaults.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param min            Minimum value of the property
     * @param max            Maximum value of the property
     * @param defaultValues  List of defaults
     * @param theUIOrder     UI order
     *
     * @throws IllegalArgumentException if {@literal min > max} or one of the defaults is not between the bounds
     * @deprecated Use {@link PropertyFactory#longIntListProperty(String)}
     */
    @Deprecated
    public LongMultiProperty(final String theName, final String theDescription, final Long min, final Long max,
                             final List<Long> defaultValues, final float theUIOrder) {
        this(theName, theDescription, min, max, defaultValues, theUIOrder, false);
    }


    @Override
    public Class<Long> type() {
        return Long.class;
    }


    @Override
    protected Long createFrom(final String value) {
        return Long.valueOf(value);
    }


    static PropertyDescriptorBuilderConversionWrapper.MultiValue.Numeric<Long, LongMultiPBuilder> extractor() {
        return new PropertyDescriptorBuilderConversionWrapper.MultiValue.Numeric<Long, LongMultiPBuilder>(Long.class, ValueParserConstants.LONG_PARSER) {
            @Override
            protected LongMultiPBuilder newBuilder(final String name) {
                return new LongMultiPBuilder(name);
            }
        };
    }


    /** @deprecated Use {@link PropertyFactory#longIntListProperty(String)} */
    @Deprecated
    public static LongMultiPBuilder named(final String name) {
        return new LongMultiPBuilder(name);
    }


    /** @deprecated Use {@link PropertyFactory#longIntListProperty(String)} */
    @Deprecated
    public static final class LongMultiPBuilder
        extends MultiNumericPropertyBuilder<Long, LongMultiPBuilder> {

        protected LongMultiPBuilder(final String name) {
            super(name);
        }


        @Override
        public LongMultiProperty build() {
            return new LongMultiProperty(name, description, lowerLimit, upperLimit,
                defaultValues, uiOrder, isDefinedInXML);
        }
    }


}
