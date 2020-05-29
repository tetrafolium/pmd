/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.vf.ast;

import net.sourceforge.pmd.annotation.InternalApi;
import net.sourceforge.pmd.lang.ast.RootNode;

public class ASTCompilationUnit extends AbstractVFNode implements RootNode {
    @Deprecated
    @InternalApi
    public ASTCompilationUnit(final int id) {
        super(id);
    }

    @Deprecated
    @InternalApi
    public ASTCompilationUnit(final VfParser p, final int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(final VfParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
