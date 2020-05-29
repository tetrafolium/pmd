/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import static net.sourceforge.pmd.properties.ValueParserConstants.INTEGER_PARSER;

import net.sourceforge.pmd.properties.builders.PropertyDescriptorBuilderConversionWrapper;
import net.sourceforge.pmd.properties.builders.SingleNumericPropertyBuilder;


/**
 * Defines a datatype that supports single Integer property values within an upper and lower boundary.
 *
 * @author Brian Remedios
 *
 * @deprecated Use a {@code PropertyDescriptor<Integer>} instead. A builder is available from {@link PropertyFactory#intProperty(String)}.
 *             This class will be removed in 7.0.0.
 */
@Deprecated
public final class IntegerProperty extends AbstractNumericProperty<Integer> {


    /**
     * Constructor that limits itself to a single value within the specified limits.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param min            Minimum value of the property
     * @param max            Maximum value of the property
     * @param theDefault     Default value
     * @param theUIOrder     UI order
     *
     * @throws IllegalArgumentException if {@literal min > max} or one of the defaults is not between the bounds
     *
     * @deprecated Use {@link PropertyFactory#intProperty(String)}
     */
    @Deprecated
    public IntegerProperty(final String theName, final String theDescription, final Integer min, final Integer max, final Integer theDefault,
                           final float theUIOrder) {
        this(theName, theDescription, min, max, theDefault, theUIOrder, false);
    }


    /** Master constructor. */
    private IntegerProperty(final String theName, final String theDescription, final Integer min, final Integer max, final Integer theDefault,
                            final float theUIOrder, final boolean isDefinedExternally) {
        super(theName, theDescription, min, max, theDefault, theUIOrder, isDefinedExternally);
    }


    @Override
    public Class<Integer> type() {
        return Integer.class;
    }


    @Override
    protected Integer createFrom(final String value) {
        return INTEGER_PARSER.valueOf(value);
    }


    static PropertyDescriptorBuilderConversionWrapper.SingleValue.Numeric<Integer, IntegerPBuilder> extractor() {
        return new PropertyDescriptorBuilderConversionWrapper.SingleValue.Numeric<Integer, IntegerPBuilder>(Integer.class, ValueParserConstants.INTEGER_PARSER) {
            @Override
            protected IntegerPBuilder newBuilder(final String name) {
                return new IntegerPBuilder(name);
            }
        };
    }


    /**
     * @deprecated Use {@link PropertyFactory#intProperty(String)}
     */
    @Deprecated
    public static IntegerPBuilder named(final String name) {
        return new IntegerPBuilder(name);
    }


    /**
     * @deprecated Use {@link PropertyFactory#intProperty(String)}
     */
    @Deprecated
    public static final class IntegerPBuilder extends SingleNumericPropertyBuilder<Integer, IntegerPBuilder> {
        private IntegerPBuilder(final String name) {
            super(name);
        }


        @Override
        public IntegerProperty build() {
            return new IntegerProperty(name, description, lowerLimit, upperLimit, defaultValue, uiOrder, isDefinedInXML);
        }
    }

}
