/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.multifile;

import java.util.Stack;

import net.sourceforge.pmd.lang.java.ast.ASTAnyTypeDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodOrConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.JavaParserVisitorReducedAdapter;

/**
 * Fills the PackageStats.
 *
 * @author Clément Fournier
 * @since 6.0.0
 */
public class MultifileVisitor extends JavaParserVisitorReducedAdapter {

    private final Stack<ClassStats> stack = new Stack<>();
    private final PackageStats toplevel;


    MultifileVisitor(final PackageStats toplevel) {
        this.toplevel = toplevel;
    }


    @Override
    public Object visit(final ASTAnyTypeDeclaration node, final Object data) {
        stack.push(toplevel.getClassStats(node.getQualifiedName(), true));
        super.visit(node, data);
        stack.pop();

        return data;
    }


    @Override
    public Object visit(final ASTMethodOrConstructorDeclaration node, final Object data) {
        stack.peek().addOperation(node.getQualifiedName().getOperation(), node.getSignature());
        return super.visit(node, data);
    }


    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        stack.peek().addField(node.getVariableName(), node.getSignature());
        return data; // end recursion
    }


}
