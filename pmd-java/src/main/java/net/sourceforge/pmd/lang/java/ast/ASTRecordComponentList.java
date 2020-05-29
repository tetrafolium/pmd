/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */


package net.sourceforge.pmd.lang.java.ast;

import java.util.Iterator;

import net.sourceforge.pmd.annotation.Experimental;

/**
 * Defines the state description of a {@linkplain ASTRecordDeclaration RecordDeclaration} (JDK 14 preview feature).
 *
 * <pre class="grammar">
 *
 * RecordComponentList ::= "(" ( {@linkplain ASTRecordComponent RecordComponent} ( "," {@linkplain ASTRecordComponent RecordComponent} )* )? ")"
 *
 * </pre>
 */
@Experimental
public final class ASTRecordComponentList extends AbstractJavaNode implements Iterable<ASTRecordComponent> {
    ASTRecordComponentList(final int id) {
        super(id);
    }

    ASTRecordComponentList(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }

    public int size() {
        return getNumChildren();
    }

    @Override
    public Iterator<ASTRecordComponent> iterator() {
        return new NodeChildrenIterator<>(this, ASTRecordComponent.class);
    }
}
