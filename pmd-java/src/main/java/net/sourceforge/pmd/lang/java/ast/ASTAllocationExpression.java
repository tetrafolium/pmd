/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.java.qname.JavaTypeQualifiedName;


public class ASTAllocationExpression extends AbstractJavaTypeNode implements JavaQualifiableNode {

    private JavaTypeQualifiedName qualifiedName;

    @InternalApi
    @Deprecated
    public ASTAllocationExpression(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTAllocationExpression(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    /**
     * Returns true if this expression defines a body,
     * which is compiled to an anonymous class. If this
     * method returns false, then {@link #getQualifiedName()}
     * returns {@code null}.
     */
    public boolean isAnonymousClass() {
        if (getNumChildren() > 1) {
            // check the last child
            return getChild(getNumChildren() - 1) instanceof ASTClassOrInterfaceBody;
        }
        return false;
    }

    /**
     * Gets the qualified name of the anonymous class
     * declared by this node, or null if this node
     * doesn't declare any.
     *
     * @see #isAnonymousClass()
     */
    @Override
    public JavaTypeQualifiedName getQualifiedName() {
        return qualifiedName;
    }

    @InternalApi
    @Deprecated
    public void setQualifiedName(final JavaTypeQualifiedName qname) {
        this.qualifiedName = qname;
    }

}
