/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.java.typeresolution.typedefinition.JavaTypeDefinition;

/**
 * An extension of the SimpleJavaNode which implements the TypeNode interface.
 *
 * @see AbstractJavaNode
 * @see TypeNode
 */
@Deprecated
@InternalApi
public abstract class AbstractJavaTypeNode extends AbstractJavaNode implements TypeNode {

    private JavaTypeDefinition typeDefinition;

    @InternalApi
    @Deprecated
    public AbstractJavaTypeNode(final int i) {
        super(i);
    }

    @InternalApi
    @Deprecated
    public AbstractJavaTypeNode(final JavaParser p, final int i) {
        super(p, i);
    }

    @Override
    public Class<?> getType() {
        return typeDefinition == null ? null : typeDefinition.getType();
    }

    @InternalApi
    @Deprecated
    @Override
    public void setType(final Class<?> type) {
        typeDefinition = JavaTypeDefinition.forClass(type);
    }

    @Override
    public JavaTypeDefinition getTypeDefinition() {
        return typeDefinition;
    }

    @InternalApi
    @Deprecated
    @Override
    public void setTypeDefinition(final JavaTypeDefinition typeDefinition) {
        this.typeDefinition = typeDefinition;
    }
}
