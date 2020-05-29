/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.dcd.graph;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.pmd.dcd.ClassLoaderUtil;
import net.sourceforge.pmd.dcd.DCD;

/**
 * Represents a Class in a UsageGraph. Contains lists of FieldNodes,
 * ConstructorNodes, and MethodNodes.
 * @deprecated See {@link DCD}
 */
@Deprecated
public class ClassNode implements NodeVisitorAcceptor, Comparable<ClassNode> {

    private final String name;

    private WeakReference<Class<?>> typeReference;

    private List<FieldNode> fieldNodes;

    private List<ConstructorNode> constructorNodes;

    private List<MethodNode> methodNodes;

    public ClassNode(final String name) {
        this.name = name;
    }

    @Override
    public Object accept(final NodeVisitor visitor, final Object data) {
        visitor.visitFields(this, data);
        visitor.visitConstructors(this, data);
        visitor.visitMethods(this, data);
        return data;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        Class<?> type = typeReference == null ? null : typeReference.get();
        if (type == null) {
            type = ClassLoaderUtil.getClass(ClassLoaderUtil.fromInternalForm(name));
            typeReference = new WeakReference<Class<?>>(type);
        }
        return type;
    }

    public FieldNode defineField(final String name, final String desc) {
        if (fieldNodes == null) {
            fieldNodes = new ArrayList<>(1);
        }
        for (FieldNode fieldNode : fieldNodes) {
            if (fieldNode.equals(name, desc)) {
                return fieldNode;
            }
        }
        FieldNode fieldNode = new FieldNode(this, name, desc);
        fieldNodes.add(fieldNode);
        return fieldNode;
    }

    public ConstructorNode defineConstructor(final String name, final String desc) {
        if (constructorNodes == null) {
            constructorNodes = new ArrayList<>(1);
        }
        for (ConstructorNode constructorNode : constructorNodes) {
            if (constructorNode.equals(name, desc)) {
                return constructorNode;
            }
        }

        ConstructorNode constructorNode = new ConstructorNode(this, name, desc);
        constructorNodes.add(constructorNode);
        return constructorNode;
    }

    public MethodNode defineMethod(final String name, final String desc) {
        if (methodNodes == null) {
            methodNodes = new ArrayList<>(1);
        }
        for (MethodNode methodNode : methodNodes) {
            if (methodNode.equals(name, desc)) {
                return methodNode;
            }
        }

        MethodNode methodNode = new MethodNode(this, name, desc);
        methodNodes.add(methodNode);
        return methodNode;
    }

    public List<FieldNode> getFieldNodes() {
        return fieldNodes != null ? fieldNodes : Collections.<FieldNode>emptyList();
    }

    public List<ConstructorNode> getConstructorNodes() {
        return constructorNodes != null ? constructorNodes : Collections.<ConstructorNode>emptyList();
    }

    public List<MethodNode> getMethodNodes() {
        return methodNodes != null ? methodNodes : Collections.<MethodNode>emptyList();
    }

    @Override
    public int compareTo(final ClassNode that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof ClassNode) {
            return this.name.equals(((ClassNode) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
