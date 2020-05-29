/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTPrimaryPrefix extends AbstractJavaTypeNode {

    private boolean usesThisModifier;
    private boolean usesSuperModifier;

    @InternalApi
    @Deprecated
    public ASTPrimaryPrefix(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTPrimaryPrefix(final JavaParser p, final int id) {
        super(p, id);
    }

    @InternalApi
    @Deprecated
    public void setUsesThisModifier() {
        usesThisModifier = true;
    }

    public boolean usesThisModifier() {
        return this.usesThisModifier;
    }

    @InternalApi
    @Deprecated
    public void setUsesSuperModifier() {
        usesSuperModifier = true;
    }

    public boolean usesSuperModifier() {
        return this.usesSuperModifier;
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
