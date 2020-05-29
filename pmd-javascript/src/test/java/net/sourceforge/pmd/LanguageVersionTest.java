/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.LanguageVersion;
import net.sourceforge.pmd.lang.ecmascript.EcmascriptLanguageModule;

public class LanguageVersionTest extends AbstractLanguageVersionTest {

    public LanguageVersionTest(final String name, final String terseName, final String version, final LanguageVersion expected) {
        super(name, terseName, version, expected);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{EcmascriptLanguageModule.NAME, EcmascriptLanguageModule.TERSE_NAME, "3",
            LanguageRegistry.getLanguage(EcmascriptLanguageModule.NAME).getDefaultVersion(), }, });
    }
}
