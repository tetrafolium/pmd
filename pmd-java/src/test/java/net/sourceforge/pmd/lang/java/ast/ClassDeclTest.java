/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClassDeclTest extends BaseParserTest {

    @Test
    public void testPublic() {
        String[] access = {"public"};
        ASTClassOrInterfaceDeclaration acd = getClassDecl(access);
        verifyFlags(acd, true, false, false, false);
    }

    @Test
    public void testAbstract() {
        String[] access = {"abstract" };
        ASTClassOrInterfaceDeclaration acd = getClassDecl(access);
        verifyFlags(acd, false, true, false, false);
    }

    @Test
    public void testFinal() {
        String[] access = {"final" };
        ASTClassOrInterfaceDeclaration acd = getClassDecl(access);
        verifyFlags(acd, false, false, true, false);
    }

    @Test
    public void testStrict() {
        String[] access = {"strictfp" };
        ASTClassOrInterfaceDeclaration acd = getClassDecl(access);
        verifyFlags(acd, false, false, false, true);
    }

    @Test
    public void testPublicFinal() {
        String[] access = {"public", "final" };
        ASTClassOrInterfaceDeclaration acd = getClassDecl(access);
        verifyFlags(acd, true, false, true, false);
    }

    public void verifyFlags(final ASTClassOrInterfaceDeclaration acd, final boolean bPublic, final boolean bAbstract, final boolean bFinal,
            final boolean bStrict) {
        assertEquals("Public: ", bPublic, acd.isPublic());
        assertEquals("Abstract: ", bAbstract, acd.isAbstract());
        assertEquals("Final: ", bFinal, acd.isFinal());
        assertEquals("Strict: ", bStrict, acd.isStrictfp());
    }

    public ASTClassOrInterfaceDeclaration getClassDecl(final String[] access) {
        return AccessNodeTest.getDeclWithModifiers(access, ASTClassOrInterfaceDeclaration.class, "class Test {}");
    }
}
