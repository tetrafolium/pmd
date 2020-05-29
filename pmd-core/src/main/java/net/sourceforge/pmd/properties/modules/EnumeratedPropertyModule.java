/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.properties.modules;

import java.util.Collections;
import java.util.Map;

import net.sourceforge.pmd.util.CollectionUtil;


/**
 * Factorises common functionality for enumerated properties.
 *
 * @author Clément Fournier
 */
@Deprecated
public class EnumeratedPropertyModule<E> {

    private final Map<String, E> choicesByLabel;
    private final Map<E, String> labelsByChoice;
    private final Class<E> valueType;


    public EnumeratedPropertyModule(final Map<String, E> choicesByLabel, final Class<E> valueType) {
        this.valueType = valueType;
        this.choicesByLabel = Collections.unmodifiableMap(choicesByLabel);
        this.labelsByChoice = Collections.unmodifiableMap(CollectionUtil.invertedMapFrom(choicesByLabel));
    }


    public Class<E> getValueType() {
        return valueType;
    }


    public Map<E, String> getLabelsByChoice() {
        return labelsByChoice;
    }


    public Map<String, E> getChoicesByLabel() {
        return choicesByLabel;
    }


    private String nonLegalValueMsgFor(final E value) {
        return value + " is not a legal value";
    }


    public String errorFor(final E value) {
        return labelsByChoice.containsKey(value) ? null : nonLegalValueMsgFor(value);
    }


    public E choiceFrom(final String label) {
        E result = choicesByLabel.get(label);
        if (result != null) {
            return result;
        }
        throw new IllegalArgumentException(label);
    }


    public void checkValue(final E value) {
        if (!choicesByLabel.containsValue(value)) {
            throw new IllegalArgumentException("Invalid default value: no mapping to this value");
        }
    }

}
