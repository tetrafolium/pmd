/*
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.jsp.ast;

import net.sourceforge.pmd.annotation.InternalApi;

public class ASTDoctypeExternalId extends AbstractJspNode {

    /**
     * URI of the external entity. Cannot be null.
     */
    private String uri;

    /**
     * Public ID of the external entity. This is optional.
     */
    private String publicId;

    @InternalApi
    @Deprecated
    public ASTDoctypeExternalId(final int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTDoctypeExternalId(final JspParser p, final int id) {
        super(p, id);
    }

    public boolean isHasPublicId() {
        return null != publicId;
    }

    public String getUri() {
        return uri;
    }

    @InternalApi
    @Deprecated
    public void setUri(final String uri) {
        this.uri = uri;
    }

    /**
     * @return Returns the publicId (or an empty string if there is none for
     *         this external entity id).
     */
    public String getPublicId() {
        return null == publicId ? "" : publicId;
    }

    @InternalApi
    @Deprecated
    public void setPublicId(final String publicId) {
        this.publicId = publicId;
    }

    @Override
    public Object jjtAccept(final JspParserVisitor visitor, final Object data) {
        return visitor.visit(this, data);
    }
}
