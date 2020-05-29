/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import static net.sourceforge.pmd.properties.ValueParserConstants.FLOAT_PARSER;

import net.sourceforge.pmd.properties.builders.PropertyDescriptorBuilderConversionWrapper;
import net.sourceforge.pmd.properties.builders.SingleNumericPropertyBuilder;


/**
 * Defines a property type that supports single float property values within an upper and lower boundary.
 *
 *
 * @deprecated Use {@link PropertyFactory#doubleProperty(String)} instead. This class will be removed with 7.0.0.
 * @author Brian Remedios
 */
@Deprecated
public final class FloatProperty extends AbstractNumericProperty<Float> {


    /**
     * Constructor for FloatProperty that limits itself to a single value within the specified limits. Converts string
     * arguments into the Float values.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param minStr         Minimum value of the property
     * @param maxStr         Maximum value of the property
     * @param defaultStr     Default value
     * @param theUIOrder     UI order
     *
     * @throws IllegalArgumentException if {@literal min > max} or one of the defaults is not between the bounds
     * @deprecated Use {@link PropertyFactory#doubleProperty(String)} instead.
     */
    @Deprecated
    public FloatProperty(final String theName, final String theDescription, final String minStr, final String maxStr, final String defaultStr,
                         final float theUIOrder) {
        this(theName, theDescription, FLOAT_PARSER.valueOf(minStr),
                FLOAT_PARSER.valueOf(maxStr), FLOAT_PARSER.valueOf(defaultStr), theUIOrder, false);
    }


    /** Master constructor. */
    private FloatProperty(final String theName, final String theDescription, final Float min, final Float max, final Float theDefault,
                          final float theUIOrder, final boolean isDefinedExternally) {
        super(theName, theDescription, min, max, theDefault, theUIOrder, isDefinedExternally);
    }


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
     * @deprecated Use {@link PropertyFactory#doubleProperty(String)} instead.
     */
    @Deprecated
    public FloatProperty(final String theName, final String theDescription, final Float min, final Float max, final Float theDefault,
                         final float theUIOrder) {
        this(theName, theDescription, min, max, theDefault, theUIOrder, false);
    }


    @Override
    public Class<Float> type() {
        return Float.class;
    }


    @Override
    protected Float createFrom(final String value) {
        return FLOAT_PARSER.valueOf(value);
    }


    static PropertyDescriptorBuilderConversionWrapper.SingleValue.Numeric<Float, FloatPBuilder> extractor() {
        return new PropertyDescriptorBuilderConversionWrapper.SingleValue.Numeric<Float, FloatPBuilder>(Float.class, ValueParserConstants.FLOAT_PARSER) {
            @Override
            protected FloatPBuilder newBuilder(final String name) {
                return new FloatPBuilder(name);
            }
        };
    }

    /** @deprecated Use {@link PropertyFactory#doubleProperty(String)} instead. */
    @Deprecated
    public static FloatPBuilder named(final String name) {
        return new FloatPBuilder(name);
    }


    /**
     * @deprecated Use {@link PropertyFactory#doubleProperty(String)} instead.
     */
    @Deprecated
    public static final class FloatPBuilder extends SingleNumericPropertyBuilder<Float, FloatPBuilder> {
        private FloatPBuilder(final String name) {
            super(name);
        }


        @Override
        public FloatProperty build() {
            return new FloatProperty(name, description, lowerLimit, upperLimit, defaultValue, uiOrder, isDefinedInXML);
        }
    }


}
