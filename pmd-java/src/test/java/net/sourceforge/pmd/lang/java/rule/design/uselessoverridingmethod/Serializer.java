/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.design.uselessoverridingmethod;

import java.io.IOException;
import java.io.OutputStream;

import org.w3c.dom.Node;

public class Serializer {

    public Serializer(final OutputStream out, final String encoding) {
    }

    protected void writeChild(final Node node) throws IOException {
    }

}
