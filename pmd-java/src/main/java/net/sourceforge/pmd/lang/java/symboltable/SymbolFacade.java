/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.symboltable;

import net.sourceforge.pmd.lang.java.ast.ASTCompilationUnit;

public class SymbolFacade {
    public void initializeWith(final ASTCompilationUnit node) {
        initializeWith(SymbolFacade.class.getClassLoader(), node);
    }

    public void initializeWith(final ClassLoader classLoader, final ASTCompilationUnit node) {
        ScopeAndDeclarationFinder sc = new ScopeAndDeclarationFinder(classLoader);
        node.jjtAccept(sc, null);
        OccurrenceFinder of = new OccurrenceFinder();
        node.jjtAccept(of, null);
    }
}
