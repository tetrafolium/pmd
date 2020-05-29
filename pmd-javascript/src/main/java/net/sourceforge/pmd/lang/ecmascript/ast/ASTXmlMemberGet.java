/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.ecmascript.ast;

import org.mozilla.javascript.ast.XmlMemberGet;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTXmlMemberGet extends AbstractInfixEcmascriptNode<XmlMemberGet> {
    @Deprecated
    @InternalApi
    public ASTXmlMemberGet(final XmlMemberGet xmlMemberGet) {
        super(xmlMemberGet);
    }

    @Override
    public Object jjtAccept(final EcmascriptParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
