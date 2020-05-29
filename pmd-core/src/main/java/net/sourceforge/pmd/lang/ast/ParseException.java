/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast;

public class ParseException extends RuntimeException {

    public ParseException() {
        super();
    }

    public ParseException(final String message) {
        super(message);
    }

    public ParseException(final Throwable cause) {
        super(cause);
    }

    public ParseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
