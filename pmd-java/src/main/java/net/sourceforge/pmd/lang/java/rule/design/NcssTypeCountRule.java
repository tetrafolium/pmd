/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.rule.design;

import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTConstructorDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTEnumDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTExplicitConstructorInvocation;
import net.sourceforge.pmd.lang.java.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTInitializer;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTTypeDeclaration;
import net.sourceforge.pmd.stat.DataPoint;
import net.sourceforge.pmd.util.NumericConstants;

/**
 * Non-commented source statement counter for type declarations.
 *
 * @author Jason Bennett
 */
@Deprecated
public class NcssTypeCountRule extends AbstractNcssCountRule {

    /**
     * Count type declarations. This includes classes as well as enums and
     * annotations.
     */
    public NcssTypeCountRule() {
        super(ASTTypeDeclaration.class);
        setProperty(MINIMUM_DESCRIPTOR, 1500d);
    }

    @Override
    public Object visit(final ASTClassOrInterfaceDeclaration node, final Object data) {

        if (!node.isNested()) {
            return super.visit(node, data);
        }

        return countNodeChildren(node, data);
    }

    @Override
    public Object visit(final ASTConstructorDeclaration node, final Object data) {
        return countNodeChildren(node, data);
    }

    @Override
    public Object visit(final ASTExplicitConstructorInvocation node, final Object data) {
        return NumericConstants.ONE;
    }

    @Override
    public Object visit(final ASTEnumDeclaration node, final Object data) {
        /*
         * If the enum is a type in and of itself, don't count its declaration
         * twice.
         */
        if (node.getParent() instanceof ASTTypeDeclaration) {
            Integer nodeCount = countNodeChildren(node, data);
            int count = nodeCount.intValue() - 1;
            return Integer.valueOf(count);
        }
        return countNodeChildren(node, data);
    }

    @Override
    public Object visit(final ASTMethodDeclaration node, final Object data) {
        return countNodeChildren(node, data);
    }

    @Override
    public Object visit(final ASTInitializer node, final Object data) {
        return countNodeChildren(node, data);
    }

    @Override
    public Object visit(final ASTFieldDeclaration node, final Object data) {
        return NumericConstants.ONE;
    }

    @Override
    public Object[] getViolationParameters(final DataPoint point) {
        return new String[] {String.valueOf((int) point.getScore()) };
    }
}
