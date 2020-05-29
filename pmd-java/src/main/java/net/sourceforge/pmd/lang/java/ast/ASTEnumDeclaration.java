/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import java.util.List;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTEnumDeclaration extends AbstractAnyTypeDeclaration {


    @InternalApi
    @Deprecated
    public ASTEnumDeclaration(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTEnumDeclaration(final JavaParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final JavaParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public TypeKind getTypeKind() {
        return TypeKind.ENUM;
    }


    @Override
    public List<ASTAnyTypeBodyDeclaration> getDeclarations() {
        return getFirstChildOfType(ASTEnumBody.class)
            .findChildrenOfType(ASTAnyTypeBodyDeclaration.class);
    }
}
