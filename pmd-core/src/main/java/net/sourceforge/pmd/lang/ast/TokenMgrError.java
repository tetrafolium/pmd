/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.util.StringUtil;

/**
 * An error thrown during lexical analysis of a file.
 */
public final class TokenMgrError extends RuntimeException {

    private final int line;
    private final int column;
    private final String filename;

    // these constants are deprecated because they're useless,
    // they've been removed from 7.0.x

    @Deprecated
    public static final int LEXICAL_ERROR = 0;
    @Deprecated
    public static final int STATIC_LEXER_ERROR = 1;
    @Deprecated
    public static final int INVALID_LEXICAL_STATE = 2;
    @Deprecated
    public static final int LOOP_DETECTED = 3;

    /**
     * @deprecated Use {@link #TokenMgrError(int, int, String, String, Throwable)}
     */
    @Deprecated
    public TokenMgrError() {
        this("NO_MESSAGE", LEXICAL_ERROR);
    }

    /**
     * @deprecated Use {@link #TokenMgrError(int, int, String, String, Throwable)}
     */
    @Deprecated
    public TokenMgrError(final String message, final @SuppressWarnings("PMD.UnusedFormalParameter") int reason) {
        super(message);
        this.line = -1;
        this.column = -1;
        this.filename = null;
    }

    /**
     * Create a new exception.
     *
     * @param line     Line number
     * @param column   Column number
     * @param filename Filename. If unknown, it can be completed with {@link #withFileName(String)} later
     * @param message  Message of the error
     * @param cause    Cause of the error, if any
     */
    public TokenMgrError(final int line, final int column, /*@Nullable*/ final String filename, final String message, /*@Nullable*/ final Throwable cause) {
        super(message, cause);
        this.line = line;
        this.column = column;
        this.filename = filename;
    }

    /**
     * Constructor called by JavaCC.
     *
     * @deprecated This should only be used by the Javacc implementations we maintain, will change in 7.0
     */
    @InternalApi
    @Deprecated
    public TokenMgrError(final boolean eofSeen, final int lexStateName, final int errorLine, final int errorColumn, final String errorAfter, final char curChar, final @SuppressWarnings("PMD.UnusedFormalParameter") int reason) {
        super(makeReason(eofSeen, lexStateName, errorAfter, curChar));
        line = errorLine;
        column = errorColumn;
        filename = null; // may be replaced with #withFileName
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public /*@Nullable*/ String getFilename() {
        return filename;
    }

    /**
     * @deprecated Use {@link StringUtil#escapeJava(String)}
     */
    @Deprecated
    protected static String addEscapes(final String str) {
        return StringUtil.escapeJava(str);
    }


    @Deprecated
    protected static String LexicalError(final boolean eofSeen, final int lexState, final int errorLine, final int errorColumn, final String errorAfter, final char curChar) { // SUPPRESS CHECKSTYLE yes it's ugly, but it's for compatibility
        return makeMessage(null, errorLine, errorColumn, makeReason(eofSeen, lexState, errorAfter, curChar));
    }

    @Override
    public String getMessage() {
        return makeMessage(filename, line, column, super.getMessage());
    }

    private static String makeMessage(final String filename, final int line, final int column, final String message) {
        String leader = filename != null ? "Lexical error in file " + filename : "Lexical error";
        return leader + " at line " + line + ", column " + column + ".  Encountered: " + message;
    }

    /**
     * Replace the file name of this error.
     *
     * @param filename New filename
     *
     * @return A new exception
     */
    public TokenMgrError withFileName(final String filename) {
        return new TokenMgrError(this.line, this.column, filename, this.getMessage(), this.getCause());
    }

    private static String makeReason(final boolean eofseen, final int lexStateName, final String errorAfter, final char curChar) {
        String message;
        if (eofseen) {
            message = "<EOF> ";
        } else {
            message = "\"" + StringUtil.escapeJava(String.valueOf(curChar)) + "\"" + " (" + (int) curChar + "), ";
        }
        message += "after : \"" + StringUtil.escapeJava(errorAfter) + "\" (in lexical state " + lexStateName + ")";

        return message;
    }
}
