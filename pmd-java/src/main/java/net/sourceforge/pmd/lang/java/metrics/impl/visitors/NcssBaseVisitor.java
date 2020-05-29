/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.metrics.impl.visitors;

import org.apache.commons.lang3.mutable.MutableInt;

import net.sourceforge.pmd.lang.java.ast.ASTAnnotationTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTAssertStatement;
import net.sourceforge.pmd.lang.java.ast.ASTBreakStatement;
import net.sourceforge.pmd.lang.java.ast.ASTCatchStatement;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTContinueStatement;
import net.sourceforge.pmd.lang.java.ast.ASTDoStatement;
import net.sourceforge.pmd.lang.java.ast.ASTEnumDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTExplicitConstructorInvocation;
import net.sourceforge.pmd.lang.java.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTFinallyStatement;
import net.sourceforge.pmd.lang.java.ast.ASTForInit;
import net.sourceforge.pmd.lang.java.ast.ASTForStatement;
import net.sourceforge.pmd.lang.java.ast.ASTForUpdate;
import net.sourceforge.pmd.lang.java.ast.ASTIfStatement;
import net.sourceforge.pmd.lang.java.ast.ASTInitializer;
import net.sourceforge.pmd.lang.java.ast.ASTLabeledStatement;
import net.sourceforge.pmd.lang.java.ast.ASTLocalVariableDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.java.ast.ASTStatementExpression;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchLabel;
import net.sourceforge.pmd.lang.java.ast.ASTSwitchStatement;
import net.sourceforge.pmd.lang.java.ast.ASTSynchronizedStatement;
import net.sourceforge.pmd.lang.java.ast.ASTThrowStatement;
import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.ast.JavaParserControllessVisitorAdapter;


/**
 * Default visitor for the calculation of Ncss.
 *
 * @author Clément Fournier
 * @see net.sourceforge.pmd.lang.java.metrics.impl.NcssMetric
 *
 * @deprecated Visitor decorators are deprecated because they lead to fragile code.
 *
 */
@Deprecated
public class NcssBaseVisitor extends JavaParserControllessVisitorAdapter {

    /** Instance. */
    public static final NcssBaseVisitor INSTANCE = new NcssBaseVisitor();

    @Override
    public Object visit(final ASTClassOrInterfaceDeclaration node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTEnumDeclaration node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTAnnotationTypeDeclaration node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        ((MutableInt) data).increment();
        return data;
    }


    @Override
    public Object visit(final ASTMethodDeclaration node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTConstructorDeclaration node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTLocalVariableDeclaration node, final Object data) {

        // doesn't count variable declared inside a for initializer
        if (!(node.getParent() instanceof ASTForInit)) {
            ((MutableInt) data).increment();
        }
        return data;
    }


    @Override
    public Object visit(final ASTIfStatement node, final Object data) {
        ((MutableInt) data).increment();
        if (node.hasElse()) {
            ((MutableInt) data).increment();
        }

        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTWhileStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTSwitchStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTStatementExpression node, final Object data) {
        if (!(node.getParent().getParent() instanceof ASTForUpdate)) {
            ((MutableInt) data).increment();
        }
        return data;
    }


    @Override
    public Object visit(final ASTExplicitConstructorInvocation node, final Object data) {
        ((MutableInt) data).increment();
        return data;
    }


    @Override
    public Object visit(final ASTContinueStatement node, final Object data) {
        ((MutableInt) data).increment();
        return data;
    }


    @Override
    public Object visit(final ASTBreakStatement node, final Object data) {
        ((MutableInt) data).increment();
        return data;
    }


    @Override
    public Object visit(final ASTReturnStatement node, final Object data) {
        ((MutableInt) data).increment();
        return data;
    }


    @Override
    public Object visit(final ASTDoStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTForStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTSynchronizedStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTCatchStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTThrowStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTFinallyStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTLabeledStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTSwitchLabel node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTInitializer node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTAssertStatement node, final Object data) {
        ((MutableInt) data).increment();
        return super.visit(node, data);
    }

}
