/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.typeresolution.typeinference;


import java.util.List;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.java.typeresolution.typedefinition.JavaTypeDefinition;


@Deprecated
@InternalApi
public class Constraint extends BoundOrConstraint {
    public Constraint(final JavaTypeDefinition leftProperType, final JavaTypeDefinition rightProperType, final InferenceRuleType
            ruleType) {
        super(leftProperType, rightProperType, ruleType);
    }

    public Constraint(final JavaTypeDefinition leftProperType, final Variable rightTypeVariable, final InferenceRuleType
            ruleType) {
        super(leftProperType, rightTypeVariable, ruleType);
    }

    public Constraint(final Variable leftTypeVariable, final JavaTypeDefinition rightProperType, final InferenceRuleType
            ruleType) {
        super(leftTypeVariable, rightProperType, ruleType);
    }

    public Constraint(final Variable leftTypeVariable, final Variable rightTypeVariable, final InferenceRuleType
            ruleType) {
        super(leftTypeVariable, rightTypeVariable, ruleType);
    }

    @Override
    public List<BoundOrConstraint> reduce() {
        return ruleType.reduce(this);
    }
}
