/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.dcd.graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureReader;

import net.sourceforge.pmd.dcd.DCD;
import net.sourceforge.pmd.dcd.asm.PrintVisitor;
import net.sourceforge.pmd.dcd.asm.TypeSignatureVisitor;
import net.sourceforge.pmd.util.filter.Filter;

/**
 * Utility class used to build a UsageGraph.
 * @deprecated See {@link DCD}
 */
@Deprecated
public class UsageGraphBuilder {

    /**
     * Should trace level logging be enabled. This is a development debugging
     * option.
     */
    private static final boolean TRACE = false;
    private static final boolean INDEX = true;

    protected final UsageGraph usageGraph;
    protected final Filter<String> classFilter;

    public UsageGraphBuilder(final Filter<String> classFilter) {
        this.classFilter = classFilter;
        this.usageGraph = new UsageGraph(classFilter);
    }

    public void index(final String name) {
        try {
            String className = getClassName(name);
            String classResourceName = getResourceName(name);
            if (classFilter.filter(className)) {
                if (!usageGraph.isClass(className)) {
                    usageGraph.defineClass(className);
                    try (InputStream inputStream = this.getClass().getClassLoader()
                            .getResourceAsStream(classResourceName + ".class")) {
                        ClassReader classReader = new ClassReader(inputStream);
                        classReader.accept(getNewClassVisitor(), 0);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("For " + name + ": " + e.getMessage(), e);
        }
    }

    public UsageGraph getUsageGraph() {
        return usageGraph;
    }

    private ClassVisitor getNewClassVisitor() {
        return new MyClassVisitor();
    }

    // ASM visitor to on Class files to build a UsageGraph
    class MyClassVisitor extends ClassVisitor {
        private final PrintVisitor p;
        private String className;

        MyClassVisitor() {
            super(Opcodes.ASM5);
            p = new PrintVisitor();
        }

        protected void println(final String s) {
            p.println(s);
        }

        protected void printlnIndent(final String s) {
            p.printlnIndent(s);
        }

        @Override
        public void visit(final int version, final int access, final String name, final String signature, final String superName,
                final String[] interfaces) {
            if (TRACE) {
                println("visit:");
                printlnIndent("version: " + version);
                printlnIndent("access: " + access);
                printlnIndent("name: " + name);
                printlnIndent("signature: " + signature);
                printlnIndent("superName: " + superName);
                printlnIndent("interfaces: " + asList(interfaces));
            }
            this.className = getClassName(name);
        }

        @Override
        public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
            if (TRACE) {
                println("visitAnnotation:");
                printlnIndent("desc: " + desc);
                printlnIndent("visible: " + visible);
            }
            return null;
        }

        @Override
        public void visitAttribute(final Attribute attr) {
            if (TRACE) {
                println("visitAttribute:");
                printlnIndent("attr: " + attr);
            }
        }

        @Override
        public void visitEnd() {
            if (TRACE) {
                println("visitEnd:");
            }
        }

        @Override
        public FieldVisitor visitField(final int access, final String name, final String desc, final String signature, final Object value) {
            if (TRACE) {
                println("visitField:");
                printlnIndent("access: " + access);
                printlnIndent("name: " + name);
                printlnIndent("desc: " + desc);
                printlnIndent("signature: " + signature);
                printlnIndent("value: " + value);
            }
            if (INDEX) {
                SignatureReader signatureReader = new SignatureReader(desc);
                TypeSignatureVisitor visitor = new TypeSignatureVisitor(p);
                signatureReader.acceptType(visitor);
                if (TRACE) {
                    printlnIndent("fieldType: " + visitor.getFieldType());
                }

                usageGraph.defineField(className, name, desc);
            }
            return null;
        }

        @Override
        public void visitInnerClass(final String name, final String outerName, final String innerName, final int access) {
            if (TRACE) {
                println("visitInnerClass:");
                printlnIndent("name: " + name);
                printlnIndent("outerName: " + outerName);
                printlnIndent("innerName: " + innerName);
                printlnIndent("access: " + access);
            }
            index(name);
        }

        @Override
        public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
            MemberNode memberNode = null;
            if (TRACE) {
                println("visitMethod:");
                printlnIndent("access: " + access);
                printlnIndent("name: " + name);
                printlnIndent("desc: " + desc);
                printlnIndent("signature: " + signature);
                printlnIndent("exceptions: " + asList(exceptions));
            }
            if (INDEX) {
                memberNode = usageGraph.defineMethod(className, name, desc);
            }
            return getNewMethodVisitor(p, memberNode);
        }

        @Override
        public void visitOuterClass(final String owner, final String name, final String desc) {
            if (TRACE) {
                println("visitOuterClass:");
                printlnIndent("owner: " + owner);
                printlnIndent("name: " + name);
                printlnIndent("desc: " + desc);
            }
        }

        @Override
        public void visitSource(final String source, final String debug) {
            if (TRACE) {
                println("visitSource:");
                printlnIndent("source: " + source);
                printlnIndent("debug: " + debug);
            }
        }
    }

    protected MethodVisitor getNewMethodVisitor(final PrintVisitor parent, final MemberNode usingMemberNode) {
        return new MyMethodVisitor(parent, usingMemberNode);
    }

    protected class MyMethodVisitor extends MethodVisitor {
        private final PrintVisitor p;

        protected void println(final String s) {
            p.println(s);
        }

        protected void printlnIndent(final String s) {
            p.printlnIndent(s);
        }

        private final MemberNode usingMemberNode;

        public MyMethodVisitor(final PrintVisitor parent, final MemberNode usingMemberNode) {
            super(Opcodes.ASM5);
            p = parent;
            this.usingMemberNode = usingMemberNode;
        }

        @Override
        public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
            if (TRACE) {
                println("visitAnnotation:");
                printlnIndent("desc: " + desc);
                printlnIndent("visible: " + visible);
            }
            return null;
        }

        @Override
        public AnnotationVisitor visitAnnotationDefault() {
            if (TRACE) {
                println("visitAnnotationDefault:");
            }
            return null;
        }

        @Override
        public void visitAttribute(final Attribute attr) {
            if (TRACE) {
                println("visitAttribute:");
                printlnIndent("attr: " + attr);
            }
        }

        @Override
        public void visitCode() {
            if (TRACE) {
                println("visitCode:");
            }
        }

        @Override
        public void visitEnd() {
            if (TRACE) {
                println("visitEnd:");
            }
        }

        @Override
        public void visitFieldInsn(final int opcode, final String owner, final String name, final String desc) {
            if (TRACE) {
                println("visitFieldInsn:");
                printlnIndent("opcode: " + opcode);
                printlnIndent("owner: " + owner);
                printlnIndent("name: " + name);
                printlnIndent("desc: " + desc);
            }
            if (INDEX) {
                String className = getClassName(owner);
                usageGraph.usageField(className, name, desc, usingMemberNode);
            }
        }

        @Override
        public void visitFrame(final int type, final int local, final Object[] local2, final int stack, final Object[] stack2) {
            if (TRACE) {
                println("visitFrame:");
                printlnIndent("type: " + type);
                printlnIndent("local: " + local);
                printlnIndent("local2: " + asList(local2));
                printlnIndent("stack: " + stack);
                printlnIndent("stack2: " + asList(stack2));
            }
        }

        @Override
        public void visitIincInsn(final int var, final int increment) {
            if (TRACE) {
                println("visitIincInsn:");
                printlnIndent("var: " + var);
                printlnIndent("increment: " + increment);
            }
        }

        @Override
        public void visitInsn(final int opcode) {
            if (TRACE) {
                println("visitInsn:");
                printlnIndent("opcode: " + opcode);
            }
        }

        @Override
        public void visitIntInsn(final int opcode, final int operand) {
            if (TRACE) {
                println("visitIntInsn:");
                printlnIndent("opcode: " + opcode);
                printlnIndent("operand: " + operand);
            }
        }

        @Override
        public void visitJumpInsn(final int opcode, final Label label) {
            if (TRACE) {
                println("visitJumpInsn:");
                printlnIndent("opcode: " + opcode);
                printlnIndent("label: " + label);
            }
        }

        @Override
        public void visitLabel(final Label label) {
            if (TRACE) {
                println("visitLabel:");
                printlnIndent("label: " + label);
            }
        }

        @Override
        public void visitLdcInsn(final Object cst) {
            if (TRACE) {
                println("visitLdcInsn:");
                printlnIndent("cst: " + cst);
            }
        }

        @Override
        public void visitLineNumber(final int line, final Label start) {
            if (TRACE) {
                println("visitLineNumber:");
                printlnIndent("line: " + line);
                printlnIndent("start: " + start);
            }
        }

        @Override
        public void visitLocalVariable(final String name, final String desc, final String signature, final Label start, final Label end, final int index) {
            if (TRACE) {
                println("visitLocalVariable:");
                printlnIndent("name: " + name);
                printlnIndent("desc: " + desc);
                printlnIndent("signature: " + signature);
                printlnIndent("start: " + start);
                printlnIndent("end: " + end);
                printlnIndent("index: " + index);
            }
        }

        @Override
        public void visitLookupSwitchInsn(final Label dflt, final int[] keys, final Label[] labels) {
            if (TRACE) {
                println("visitLookupSwitchInsn:");
                printlnIndent("dflt: " + dflt);
                printlnIndent("keys: " + asList(keys));
                printlnIndent("labels: " + asList(labels));
            }
        }

        @Override
        public void visitMaxs(final int maxStack, final int maxLocals) {
            if (TRACE) {
                println("visitMaxs:");
                printlnIndent("maxStack: " + maxStack);
                printlnIndent("maxLocals: " + maxLocals);
            }
        }

        @Override
        public void visitMethodInsn(final int opcode, final String owner, final String name, final String desc, final boolean itf) {
            if (TRACE) {
                println("visitMethodInsn:");
                printlnIndent("opcode: " + opcode);
                printlnIndent("owner: " + owner);
                printlnIndent("name: " + name);
                printlnIndent("desc: " + desc);
                printlnIndent("itf: " + itf);
            }
            if (INDEX) {
                String className = getClassName(owner);
                usageGraph.usageMethod(className, name, desc, usingMemberNode);
            }
        }

        @Override
        public void visitMultiANewArrayInsn(final String desc, final int dims) {
            if (TRACE) {
                println("visitMultiANewArrayInsn:");
                printlnIndent("desc: " + desc);
                printlnIndent("dims: " + dims);
            }
        }

        @Override
        public AnnotationVisitor visitParameterAnnotation(final int parameter, final String desc, final boolean visible) {
            if (TRACE) {
                println("visitParameterAnnotation:");
                printlnIndent("parameter: " + parameter);
                printlnIndent("desc: " + desc);
                printlnIndent("visible: " + visible);
            }
            return null;
        }

        @Override
        public void visitTableSwitchInsn(final int min, final int max, final Label dflt, final Label... labels) {
            if (TRACE) {
                println("visitTableSwitchInsn:");
                printlnIndent("min: " + min);
                printlnIndent("max: " + max);
                printlnIndent("dflt: " + dflt);
                printlnIndent("labels: " + asList(labels));
            }
        }

        @Override
        public void visitTryCatchBlock(final Label start, final Label end, final Label handler, final String type) {
            if (TRACE) {
                println("visitTryCatchBlock:");
                printlnIndent("start: " + start);
                printlnIndent("end: " + end);
                printlnIndent("handler: " + handler);
                printlnIndent("type: " + type);
            }
        }

        @Override
        public void visitTypeInsn(final int opcode, final String desc) {
            if (TRACE) {
                println("visitTypeInsn:");
                printlnIndent("opcode: " + opcode);
                printlnIndent("desc: " + desc);
            }
        }

        @Override
        public void visitVarInsn(final int opcode, final int var) {
            if (TRACE) {
                println("visitVarInsn:");
                printlnIndent("opcode: " + opcode);
                printlnIndent("var: " + var);
            }
        }
    }

    private static String getResourceName(final String name) {
        return name.replace('.', '/');
    }

    static String getClassName(final String name) {
        return name.replace('/', '.');
    }

    private static List<Integer> asList(final int[] array) {
        List<Integer> list = null;
        if (array != null) {
            list = new ArrayList<>(array.length);
            for (int i : array) {
                list.add(i);
            }
        }
        return list;
    }

    private static List<Object> asList(final Object[] array) {
        return array != null ? Arrays.asList(array) : null;
    }
}
