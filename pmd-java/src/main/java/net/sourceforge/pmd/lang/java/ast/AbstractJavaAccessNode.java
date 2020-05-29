/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

@Deprecated
@InternalApi
public abstract class AbstractJavaAccessNode extends AbstractJavaAnnotatableNode implements AccessNode {

    private int modifiers;

    @Deprecated
    @InternalApi
    public AbstractJavaAccessNode(final int i) {
        super(i);
    }

    @Deprecated
    @InternalApi
    public AbstractJavaAccessNode(final JavaParser parser, final int i) {
        super(parser, i);
    }

    @Override
    public int getModifiers() {
        return this.modifiers;
    }

    @InternalApi
    @Deprecated
    @Override
    public void setModifiers(final int modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public boolean isPublic() {
        return isModifier(PUBLIC);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setPublic(final boolean isPublic) {
        setModifier(isPublic, PUBLIC);
    }

    @Override
    public boolean isProtected() {
        return isModifier(PROTECTED);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setProtected(final boolean isProtected) {
        setModifier(isProtected, PROTECTED);
    }

    @Override
    public boolean isPrivate() {
        return isModifier(PRIVATE);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setPrivate(final boolean isPrivate) {
        setModifier(isPrivate, PRIVATE);
    }

    @Override
    public boolean isAbstract() {
        return isModifier(ABSTRACT);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setAbstract(final boolean isAbstract) {
        setModifier(isAbstract, ABSTRACT);
    }

    @Override
    public boolean isStatic() {
        return isModifier(STATIC);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setStatic(final boolean isStatic) {
        setModifier(isStatic, STATIC);
    }

    @Override
    public boolean isFinal() {
        return isModifier(FINAL);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setFinal(final boolean isFinal) {
        setModifier(isFinal, FINAL);
    }

    @Override
    public boolean isSynchronized() {
        return isModifier(SYNCHRONIZED);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setSynchronized(final boolean isSynchronized) {
        setModifier(isSynchronized, SYNCHRONIZED);
    }

    @Override
    public boolean isNative() {
        return isModifier(NATIVE);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setNative(final boolean isNative) {
        setModifier(isNative, NATIVE);
    }

    @Override
    public boolean isTransient() {
        return isModifier(TRANSIENT);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setTransient(final boolean isTransient) {
        setModifier(isTransient, TRANSIENT);
    }

    @Override
    public boolean isVolatile() {
        return isModifier(VOLATILE);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setVolatile(final boolean isVolative) {
        setModifier(isVolative, VOLATILE);
    }

    @Override
    public boolean isStrictfp() {
        return isModifier(STRICTFP);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setStrictfp(final boolean isStrictfp) {
        setModifier(isStrictfp, STRICTFP);
    }

    @Override
    public boolean isDefault() {
        return isModifier(DEFAULT);
    }

    @InternalApi
    @Deprecated
    @Override
    public void setDefault(final boolean isDefault) {
        setModifier(isDefault, DEFAULT);
    }

    private boolean isModifier(final int mask) {
        return (modifiers & mask) == mask;
    }

    @InternalApi
    @Deprecated
    private void setModifier(final boolean enable, final int mask) {
        if (enable) {
            this.modifiers |= mask;
        } else {
            this.modifiers &= ~mask;
        }
    }

    @Override
    public boolean isPackagePrivate() {
        return !isPrivate() && !isPublic() && !isProtected();
    }
}

