/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import java.util.List;

import net.sourceforge.pmd.properties.builders.MultiPackagedPropertyBuilder;
import net.sourceforge.pmd.properties.builders.PropertyDescriptorBuilderConversionWrapper;
import net.sourceforge.pmd.properties.modules.TypePropertyModule;


/**
 * Defines a property that supports multiple class types, even for primitive values!
 *
 * TODO - untested for array types
 * @deprecated Will be removed with 7.0.0 with no scheduled replacement yet
 * @author Brian Remedios
 */
@Deprecated
public final class TypeMultiProperty extends AbstractMultiPackagedProperty<Class> {


    /**
     * Constructor for TypeProperty.
     *
     * @param theName           String
     * @param theDescription    String
     * @param theDefaults       Class[]
     * @param legalPackageNames String[]
     * @param theUIOrder        float
     *
     * @throws IllegalArgumentException
     */
    public TypeMultiProperty(final String theName, final String theDescription, final List<Class> theDefaults,
                             final String[] legalPackageNames, final float theUIOrder) {
        this(theName, theDescription, theDefaults, legalPackageNames, theUIOrder, false);

    }


    /** Master constructor. */
    private TypeMultiProperty(final String theName, final String theDescription, final List<Class> theTypeDefaults,
                              final String[] legalPackageNames, final float theUIOrder, final boolean isDefinedExternally) {
        super(theName, theDescription, theTypeDefaults, theUIOrder, isDefinedExternally,
            new TypePropertyModule(legalPackageNames, theTypeDefaults));
    }


    /**
     * Constructor for TypeProperty.
     *
     * @param theName           String
     * @param theDescription    String
     * @param theTypeDefaults   String
     * @param legalPackageNames String[]
     * @param theUIOrder        float
     *
     * @throws IllegalArgumentException
     */
    public TypeMultiProperty(final String theName, final String theDescription, final String theTypeDefaults,
                             final String[] legalPackageNames, final float theUIOrder) {
        this(theName, theDescription, typesFrom(theTypeDefaults),
            legalPackageNames,
            theUIOrder, false);

    }


    @Override
    public Class<Class> type() {
        return Class.class;
    }


    @Override
    public String asString(final Class value) {
        return value == null ? "" : value.getName();
    }


    @Override
    protected Class createFrom(final String toParse) {
        return ValueParserConstants.CLASS_PARSER.valueOf(toParse);
    }


    @Override
    public List<Class> valueFrom(final String valueString) {
        return typesFrom(valueString);
    }


    private static List<Class> typesFrom(final String valueString) {
        return ValueParserConstants.parsePrimitives(valueString, MULTI_VALUE_DELIMITER, ValueParserConstants.CLASS_PARSER);
    }


    public static PropertyDescriptorBuilderConversionWrapper.MultiValue.Packaged<Class, TypeMultiPBuilder> extractor() {
        return new PropertyDescriptorBuilderConversionWrapper.MultiValue.Packaged<Class, TypeMultiPBuilder>(Class.class, ValueParserConstants.CLASS_PARSER) {
            @Override
            protected TypeMultiPBuilder newBuilder(final String name) {
                return new TypeMultiPBuilder(name);
            }
        };
    }


    public static TypeMultiPBuilder named(final String name) {
        return new TypeMultiPBuilder(name);
    }


    public static final class TypeMultiPBuilder extends MultiPackagedPropertyBuilder<Class, TypeMultiPBuilder> {

        private TypeMultiPBuilder(final String name) {
            super(name);
        }


        @Override
        public TypeMultiProperty build() {
            return new TypeMultiProperty(name, description, defaultValues, legalPackageNames, uiOrder, isDefinedInXML);
        }
    }
}
