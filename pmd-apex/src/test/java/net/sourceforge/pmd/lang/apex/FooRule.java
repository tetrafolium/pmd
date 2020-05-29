/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex;

import net.sourceforge.pmd.lang.apex.ast.ASTField;
import net.sourceforge.pmd.lang.apex.ast.ASTParameter;
import net.sourceforge.pmd.lang.apex.ast.ASTUserClass;
import net.sourceforge.pmd.lang.apex.ast.ASTVariableDeclaration;
import net.sourceforge.pmd.lang.apex.rule.AbstractApexRule;

/**
 * Sample rule that detect any node with an image of "Foo". Used for testing.
 */
public class FooRule extends AbstractApexRule {

    public FooRule() {
        setMessage("No Foo allowed");
    }

    @Override
    public Object visit(final ASTUserClass c, final Object ctx) {
        if (c.getImage().equalsIgnoreCase("Foo")) {
            addViolation(ctx, c);
        }
        return super.visit(c, ctx);
    }

    @Override
    public Object visit(final ASTVariableDeclaration c, final Object ctx) {
        if (c.getImage().equalsIgnoreCase("Foo")) {
            addViolation(ctx, c);
        }
        return super.visit(c, ctx);
    }

    @Override
    public Object visit(final ASTField c, final Object ctx) {
        if (c.getImage().equalsIgnoreCase("Foo")) {
            addViolation(ctx, c);
        }
        return super.visit(c, ctx);
    }

    @Override
    public Object visit(final ASTParameter c, final Object ctx) {
        if (c.getImage().equalsIgnoreCase("Foo")) {
            addViolation(ctx, c);
        }
        return super.visit(c, ctx);
    }

    @Override
    public String getName() {
        return "NoFoo";
    }
}
