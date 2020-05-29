/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.benchmark;

/**
 * A wrapped StringBuilder that appends a variable number of text segments
 * efficiently and always appends the specified carriage return terminator.
 *
 * @author Brian Remedios
 */
@Deprecated
public class StringBuilderCR {

    private final String cr;
    private final StringBuilder sb = new StringBuilder();

    public StringBuilderCR(final String theCR) {
        cr = theCR;
    }

    public StringBuilderCR(final String initialText, final String theCR) {
        this(theCR);
        appendLn(initialText);
    }

    public void appendLn(final String... chunks) {

        for (String chunk : chunks) {
            sb.append(chunk);
        }
        sb.append(cr);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
