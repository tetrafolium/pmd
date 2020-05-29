/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.io.File;

public class CPDNullListener implements CPDListener {
    @Override
    public void addedFile(final int fileCount, final File file) {
        // does nothing - override it if necessary
    }

    @Override
    public void phaseUpdate(final int phase) {
        // does nothing - override it if necessary
    }
}
