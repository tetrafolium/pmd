/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.typeresolution.typeinference;

import java.util.List;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.java.typeresolution.typedefinition.JavaTypeDefinition;


@Deprecated
@InternalApi
public class Bound extends BoundOrConstraint {
    public Bound(final JavaTypeDefinition leftProperType, final JavaTypeDefinition rightProperType, final InferenceRuleType ruleType) {
        super(leftProperType, rightProperType, ruleType);
    }

    public Bound(final JavaTypeDefinition leftProperType, final Variable rightTypeVariable, final InferenceRuleType
            ruleType) {
        super(leftProperType, rightTypeVariable, ruleType);
    }

    public Bound(final Variable leftTypeVariable, final JavaTypeDefinition rightProperType, final InferenceRuleType
            ruleType) {
        super(leftTypeVariable, rightProperType, ruleType);
    }

    public Bound(final Variable leftTypeVariable, final Variable rightTypeVariable, final InferenceRuleType
            ruleType) {
        super(leftTypeVariable, rightTypeVariable, ruleType);
    }

    @Override
    public List<BoundOrConstraint> reduce() {
        throw new IllegalStateException("Don't reduce bounds. " + toString());
    }


}
