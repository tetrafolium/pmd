/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.plsql.symboltable;

import net.sourceforge.pmd.lang.plsql.ast.ASTPackageBody;
import net.sourceforge.pmd.lang.plsql.ast.ASTPackageSpecification;
import net.sourceforge.pmd.lang.plsql.ast.ASTQualifiedName;
import net.sourceforge.pmd.lang.plsql.ast.ASTTriggerUnit;
import net.sourceforge.pmd.lang.plsql.ast.ASTTypeSpecification;
import net.sourceforge.pmd.lang.symboltable.AbstractNameDeclaration;

public class ClassNameDeclaration extends AbstractNameDeclaration {

    public ClassNameDeclaration(final ASTQualifiedName node) {
        super(node);
    }

    public ClassNameDeclaration(final ASTPackageSpecification node) {
        super(node);
    }

    public ClassNameDeclaration(final ASTPackageBody node) {
        super(node);
    }

    public ClassNameDeclaration(final ASTTriggerUnit node) {
        super(node);
    }

    public ClassNameDeclaration(final ASTTypeSpecification node) {
        super(node);
    }

    @Override
    public String toString() {
        return "Object " + node.getImage();
    }

}
