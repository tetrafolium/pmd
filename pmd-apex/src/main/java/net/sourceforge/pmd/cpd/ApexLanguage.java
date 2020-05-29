/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.cpd;

import java.util.Properties;

public class ApexLanguage extends AbstractLanguage {

    public ApexLanguage() {
        this(new Properties());
    }

    public ApexLanguage(final Properties properties) {
        super("Apex", "apex", new ApexTokenizer(), ".cls");
        setProperties(properties);
    }

    @Override
    public final void setProperties(final Properties properties) {
        ApexTokenizer tokenizer = (ApexTokenizer) getTokenizer();
        tokenizer.setProperties(properties);
    }
}
