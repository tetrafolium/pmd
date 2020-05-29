/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.java.qname.JavaOperationQualifiedName;

@Deprecated
@InternalApi
public abstract class AbstractMethodLikeNode extends AbstractJavaAccessNode implements MethodLikeNode {

    private JavaOperationQualifiedName qualifiedName;


    AbstractMethodLikeNode(final int i) {
        super(i);
    }


    AbstractMethodLikeNode(final JavaParser parser, final int i) {
        super(parser, i);
    }


    @InternalApi
    @Deprecated
    public void setQualifiedName(final JavaOperationQualifiedName qualifiedName) {
        this.qualifiedName = qualifiedName;
    }


    @Override
    @Deprecated
    public JavaOperationQualifiedName getQualifiedName() {
        return qualifiedName;
    }

}
