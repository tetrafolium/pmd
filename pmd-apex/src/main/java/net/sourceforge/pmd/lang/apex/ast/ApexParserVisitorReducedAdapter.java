/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.apex.ast;

/**
 * @author Clément Fournier
 */
public class ApexParserVisitorReducedAdapter extends ApexParserVisitorAdapter {


    @Override
    public final Object visit(final ASTUserInterface node, final Object data) {
        return visit((ASTUserClassOrInterface<?>) node, data);
    }


    @Override
    public final Object visit(final ASTUserClass node, final Object data) {
        return visit((ASTUserClassOrInterface<?>) node, data);
    }


    public Object visit(final ASTUserClassOrInterface<?> node, final Object data) {
        return visit((ApexNode<?>) node, data);
    }

}
