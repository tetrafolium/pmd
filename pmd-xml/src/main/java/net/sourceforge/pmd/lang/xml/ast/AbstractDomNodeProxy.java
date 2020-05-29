/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.xml.ast;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import net.sourceforge.pmd.lang.ast.AbstractNode;


/**
 * Moves boilerplate out of {@link XmlNodeWrapper}.
 *
 * @author Clément Fournier
 * @since 6.1.0
 */
public abstract class AbstractDomNodeProxy extends AbstractNode implements org.w3c.dom.Node {

    protected final org.w3c.dom.Node node;


    protected AbstractDomNodeProxy(final Node node) {
        super(0);
        this.node = node;
    }


    @Override
    public String getNodeName() {
        return node.getNodeName();
    }


    @Override
    public String getNodeValue() throws DOMException {
        return node.getNodeValue();
    }


    @Override
    public void setNodeValue(final String nodeValue) throws DOMException {
        node.setNodeValue(nodeValue);
    }


    @SuppressWarnings("PMD.AvoidUsingShortType")
    @Override
    public short getNodeType() {
        return node.getNodeType();
    }


    @Override
    public org.w3c.dom.Node getParentNode() {
        return node.getParentNode();
    }


    @Override
    public NodeList getChildNodes() {
        return node.getChildNodes();
    }


    @Override
    public org.w3c.dom.Node getFirstChild() {
        return node.getFirstChild();
    }


    @Override
    public org.w3c.dom.Node getLastChild() {
        return node.getLastChild();
    }


    @Override
    public org.w3c.dom.Node getPreviousSibling() {
        return node.getPreviousSibling();
    }


    @Override
    public org.w3c.dom.Node getNextSibling() {
        return node.getNextSibling();
    }


    @Override
    public NamedNodeMap getAttributes() {
        return node.getAttributes();
    }


    @Override
    public Document getOwnerDocument() {
        return node.getOwnerDocument();
    }


    @Override
    public org.w3c.dom.Node insertBefore(final org.w3c.dom.Node newChild, final org.w3c.dom.Node refChild) throws DOMException {
        return node.insertBefore(newChild, refChild);
    }


    @Override
    public org.w3c.dom.Node replaceChild(final org.w3c.dom.Node newChild, final org.w3c.dom.Node oldChild) throws DOMException {
        return node.replaceChild(newChild, oldChild);
    }


    @Override
    public org.w3c.dom.Node removeChild(final org.w3c.dom.Node oldChild) throws DOMException {
        return node.removeChild(oldChild);
    }


    @Override
    public org.w3c.dom.Node appendChild(final org.w3c.dom.Node newChild) throws DOMException {
        return node.appendChild(newChild);
    }


    @Override
    public boolean hasChildNodes() {
        return node.hasChildNodes();
    }


    @Override
    public org.w3c.dom.Node cloneNode(final boolean deep) {
        return node.cloneNode(deep);
    }


    @Override
    public void normalize() {
        node.normalize();
    }


    @Override
    public boolean isSupported(final String feature, final String version) {
        return node.isSupported(feature, version);
    }


    @Override
    public String getNamespaceURI() {
        return node.getNamespaceURI();
    }


    @Override
    public String getPrefix() {
        return node.getPrefix();
    }


    @Override
    public void setPrefix(final String prefix) throws DOMException {
        node.setPrefix(prefix);
    }


    @Override
    public String getLocalName() {
        return node.getLocalName();
    }


    @Override
    public boolean hasAttributes() {
        return node.hasAttributes();
    }


    @Override
    public String getBaseURI() {
        return node.getBaseURI();
    }


    @SuppressWarnings("PMD.AvoidUsingShortType")
    @Override
    public short compareDocumentPosition(final org.w3c.dom.Node other) throws DOMException {
        return node.compareDocumentPosition(other);
    }


    @Override
    public String getTextContent() throws DOMException {
        return node.getTextContent();
    }


    @Override
    public void setTextContent(final String textContent) throws DOMException {
        node.setTextContent(textContent);
    }


    @Override
    public boolean isSameNode(final org.w3c.dom.Node other) {
        return node.isSameNode(other);
    }


    @Override
    public String lookupPrefix(final String namespaceURI) {
        return node.lookupPrefix(namespaceURI);
    }


    @Override
    public boolean isDefaultNamespace(final String namespaceURI) {
        return node.isDefaultNamespace(namespaceURI);
    }


    @Override
    public String lookupNamespaceURI(final String prefix) {
        return node.lookupNamespaceURI(prefix);
    }


    @Override
    public boolean isEqualNode(final org.w3c.dom.Node arg) {
        return node.isEqualNode(arg);
    }


    @Override
    public Object getFeature(final String feature, final String version) {
        return node.getFeature(feature, version);
    }


    @Override
    public Object setUserData(final String key, final Object data, final UserDataHandler handler) {
        return node.setUserData(key, data, handler);
    }


    @Override
    public Object getUserData(final String key) {
        return node.getUserData(key);
    }

}
