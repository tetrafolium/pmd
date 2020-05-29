/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.dcd.graph;

import java.util.List;

import net.sourceforge.pmd.dcd.DCD;

/**
 * Adapter class for easy implementation of a NodeVisitor. Subclasses need only
 * override methods to add behavior, and call <code>super</code> to continue the
 * visitation.
 * @deprecated See {@link DCD}
 */
@Deprecated
public class NodeVisitorAdapter implements NodeVisitor {

    @Override
    public Object visit(final UsageGraph usageGraph, final Object data) {
        return usageGraph.accept(this, data);
    }

    @Override
    public Object visit(final ClassNode classNode, final Object data) {
        return classNode.accept(this, data);
    }

    @Override
    public Object visitFields(final ClassNode classNode, final Object data) {
        for (FieldNode fieldNode : classNode.getFieldNodes()) {
            visit(fieldNode, data);
        }
        return data;
    }

    @Override
    public Object visit(final FieldNode fieldNode, final Object data) {
        return fieldNode.accept(this, data);
    }

    @Override
    public Object visitConstructors(final ClassNode classNode, final Object data) {
        for (ConstructorNode constructorNode : classNode.getConstructorNodes()) {
            visit(constructorNode, data);
        }
        return data;
    }

    @Override
    public Object visit(final ConstructorNode constructorNode, final Object data) {
        return constructorNode.accept(this, data);
    }

    @Override
    public Object visitMethods(final ClassNode classNode, final Object data) {
        for (MethodNode methodNode : classNode.getMethodNodes()) {
            visit(methodNode, data);
        }
        return data;
    }

    @Override
    public Object visit(final MethodNode methodNode, final Object data) {
        return methodNode.accept(this, data);
    }

    @Override
    public Object visitUses(final MemberNode memberNode, final Object data) {
        for (MemberNode use : (List<MemberNode>) memberNode.getUses()) {
            this.visitUse(use, data);
        }
        return data;
    }

    @Override
    public Object visitUse(final MemberNode memberNode, final Object data) {
        return data;
    }

    @Override
    public Object visitUsers(final MemberNode memberNode, final Object data) {
        for (MemberNode user : (List<MemberNode>) memberNode.getUsers()) {
            this.visitUser(user, data);
        }
        return data;
    }

    @Override
    public Object visitUser(final MemberNode memberNode, final Object data) {
        return data;
    }
}
