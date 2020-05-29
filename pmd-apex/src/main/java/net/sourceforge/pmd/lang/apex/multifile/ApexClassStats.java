/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.multifile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sourceforge.pmd.lang.apex.metrics.signature.ApexOperationSigMask;
import net.sourceforge.pmd.lang.apex.metrics.signature.ApexOperationSignature;

/**
 * Stores info about a class.
 *
 * @author Clément Fournier
 */
class ApexClassStats {

    private Map<ApexOperationSignature, Set<String>> operations = new HashMap<>();


    void addOperation(final String name, final ApexOperationSignature sig) {
        if (!operations.containsKey(sig)) {
            operations.put(sig, new HashSet<>());
        }
        operations.get(sig).add(name);
    }


    public boolean hasMatchingSig(final String operation, final ApexOperationSigMask mask) {
        for (Entry<ApexOperationSignature, Set<String>> entry : operations.entrySet()) {
            if (mask.covers(entry.getKey())) {
                if (entry.getValue().contains(operation)) {
                    return true;
                }
            }
        }
        return false;
    }
}
