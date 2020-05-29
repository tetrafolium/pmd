/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ast;

public class DummyNode extends AbstractNode {
    private final boolean findBoundary;
    private final String xpathName;

    public DummyNode(final int id) {
        this(id, false);
    }

    public DummyNode() {
        this(0, false);
    }

    public DummyNode(final int id, final boolean findBoundary) {
        this(id, findBoundary, "dummyNode");
    }

    public DummyNode(final int id, final boolean findBoundary, final String xpathName) {
        super(id);
        this.findBoundary = findBoundary;
        this.xpathName = xpathName;
    }

    public void setBeginColumn(final int i) {
        beginColumn = i;
    }

    public void setBeginLine(final int i) {
        beginLine = i;
    }

    public void setCoords(final int bline, final int bcol, final int eline, final int ecol) {
        beginLine = bline;
        beginColumn = bcol;
        endLine = eline;
        endColumn = ecol;
    }

    @Override
    public String toString() {
        return xpathName;
    }

    @Override
    public String getXPathNodeName() {
        return xpathName;
    }

    @Override
    public boolean isFindBoundary() {
        return findBoundary;
    }
}
