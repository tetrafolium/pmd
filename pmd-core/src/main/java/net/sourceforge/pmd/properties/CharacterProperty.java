/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties;

import static net.sourceforge.pmd.properties.ValueParserConstants.CHARACTER_PARSER;

import net.sourceforge.pmd.properties.builders.PropertyDescriptorBuilderConversionWrapper;
import net.sourceforge.pmd.properties.builders.SingleValuePropertyBuilder;


/**
 * Defines a property type that supports single Character values.
 *
 * @author Brian Remedios
 * @version Refactored June 2017 (6.0.0)
 * @deprecated Use a {@code PropertyDescriptor<Character>}. A builder is available from {@link PropertyFactory#charProperty(String)}.
 * This class will be removed in 7.0.0.
 */
@Deprecated
public final class CharacterProperty extends AbstractSingleValueProperty<Character> {

    /**
     * Constructor for CharacterProperty.
     *
     * @param theName        String
     * @param theDescription String
     * @param defaultStr     String
     * @param theUIOrder     float
     *
     * @throws IllegalArgumentException
     * @deprecated Use {@link PropertyFactory#charProperty(String)}
     */
    @Deprecated
    public CharacterProperty(final String theName, final String theDescription, final String defaultStr, final float theUIOrder) {
        this(theName, theDescription, charFrom(defaultStr), theUIOrder, false);
    }


    /** Master constructor. */
    private CharacterProperty(final String theName, final String theDescription, final Character theDefault, final float theUIOrder, final boolean isDefinedExternally) {
        super(theName, theDescription, theDefault, theUIOrder, isDefinedExternally);
    }


    /**
     * Constructor.
     *
     * @param theName        Name
     * @param theDescription Description
     * @param theDefault     Default value
     * @param theUIOrder     UI order
     * @deprecated Use {@link PropertyFactory#charProperty(String)}
     */
    @Deprecated
    public CharacterProperty(final String theName, final String theDescription, final Character theDefault, final float theUIOrder) {
        this(theName, theDescription, theDefault, theUIOrder, false);
    }


    @Override
    public Class<Character> type() {
        return Character.class;
    }


    @Override
    public Character createFrom(final String valueString) throws IllegalArgumentException {
        return charFrom(valueString);
    }


    /**
     * Parses a String into a Character.
     *
     * @param charStr String to parse
     *
     * @return Parsed Character
     * @throws IllegalArgumentException if the String doesn't have length 1
     */
    public static Character charFrom(final String charStr) {
        return CHARACTER_PARSER.valueOf(charStr);
    }


    static PropertyDescriptorBuilderConversionWrapper.SingleValue<Character, CharacterPBuilder> extractor() {
        return new PropertyDescriptorBuilderConversionWrapper.SingleValue<Character, CharacterPBuilder>(Character.class, ValueParserConstants.CHARACTER_PARSER) {
            @Override
            protected CharacterPBuilder newBuilder(final String name) {
                return new CharacterPBuilder(name);
            }
        };
    }


    /**
     * @deprecated Use {@link PropertyFactory#charProperty(String)}
     */
    @Deprecated
    public static CharacterPBuilder named(final String name) {
        return new CharacterPBuilder(name);
    }


    /**
     * @deprecated Use {@link PropertyFactory#charProperty(String)}
     */
    @Deprecated
    public static final class CharacterPBuilder extends SingleValuePropertyBuilder<Character, CharacterPBuilder> {
        private CharacterPBuilder(final String name) {
            super(name);
        }


        @Override
        public CharacterProperty build() {
            return new CharacterProperty(this.name, this.description, this.defaultValue, this.uiOrder, isDefinedInXML);
        }
    }

}
