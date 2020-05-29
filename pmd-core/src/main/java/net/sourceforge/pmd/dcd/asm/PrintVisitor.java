/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.dcd.asm;

import net.sourceforge.pmd.dcd.DCD;

/**
 * @deprecated See {@link DCD}
 */
@Deprecated
public class PrintVisitor {

    private static final String INDENT = "\t";

    private final int level;

    public PrintVisitor() {
        this(0);
    }

    public PrintVisitor(final PrintVisitor parent) {
        this(parent.level + 2);
    }

    public PrintVisitor(final int level) {
        this.level = level;
    }

    public void println(final String s) {
        println(this.level, s);
    }

    public void printlnIndent(final String s) {
        println(this.level + 1, s);
    }

    private void println(final int level, final String s) {
        for (int i = 0; i < level; i++) {
            System.out.print(INDENT);
        }
        System.out.println(s);
    }
}
