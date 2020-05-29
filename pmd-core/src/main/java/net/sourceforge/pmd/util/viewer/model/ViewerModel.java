/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.util.viewer.model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jaxen.BaseXPath;
import org.jaxen.JaxenException;
import org.jaxen.XPath;

import net.sourceforge.pmd.lang.LanguageVersion;
import net.sourceforge.pmd.lang.LanguageVersionHandler;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.ast.ParseException;
import net.sourceforge.pmd.lang.ast.xpath.DocumentNavigator;

@Deprecated // to be removed with PMD 7.0.0
public class ViewerModel {
    private static final Logger LOGGER = Logger.getLogger(ViewerModel.class.getName());

    private List<ViewerModelListener> listeners;
    private Node rootNode;
    private List<Node> evaluationResults;

    public ViewerModel() {
        listeners = new ArrayList<>(5);
    }

    public Node getRootNode() {
        return rootNode;
    }

    /**
     * Commits source code to the model. all existing source will be replaced.
     */
    public void commitSource(final String source, final LanguageVersion languageVersion) {
        LanguageVersionHandler languageVersionHandler = languageVersion.getLanguageVersionHandler();
        Node node = languageVersionHandler.getParser(languageVersionHandler.getDefaultParserOptions()).parse(null,
                new StringReader(source));
        rootNode = node;
        fireViewerModelEvent(new ViewerModelEvent(this, ViewerModelEvent.CODE_RECOMPILED));
    }

    /**
     * Determines whether the model has a compiled tree at it's disposal.
     *
     * @return true if there is an AST, false otherwise
     */
    public boolean hasCompiledTree() {
        return rootNode != null;
    }

    /**
     * Evaluates the given XPath expression against the current tree.
     *
     * @param xPath
     *            XPath expression to be evaluated
     * @param evaluator
     *            object which requests the evaluation
     */
    public void evaluateXPathExpression(final String xPath, final Object evaluator) throws ParseException, JaxenException {
        try {
            if (LOGGER.isLoggable(Level.FINEST)) {
                LOGGER.finest("xPath=" + xPath);
                LOGGER.finest("evaluator=" + evaluator);
            }
            XPath xpath = new BaseXPath(xPath, new DocumentNavigator());
            if (LOGGER.isLoggable(Level.FINEST)) {
                LOGGER.finest("xpath=" + xpath);
                LOGGER.finest("rootNode=" + rootNode);
            }
            try {
                evaluationResults = xpath.selectNodes(rootNode);
            } catch (Exception e) {
                LOGGER.finest("selectNodes problem:");
                e.printStackTrace(System.err);
            }
            if (LOGGER.isLoggable(Level.FINEST)) {
                LOGGER.finest("evaluationResults=" + evaluationResults);
            }
            fireViewerModelEvent(new ViewerModelEvent(evaluator, ViewerModelEvent.PATH_EXPRESSION_EVALUATED));
        } catch (JaxenException je) {
            je.printStackTrace(System.err);
            throw je;
        }
    }

    /**
     * Retrieves the results of last evaluation.
     *
     * @return a list containing the nodes selected by the last XPath expression
     *         evaluation
     */
    public List<Node> getLastEvaluationResults() {
        return evaluationResults;
    }

    /**
     * Selects the given node in the AST.
     *
     * @param node
     *            node to be selected
     * @param selector
     *            object which requests the selection
     */
    public void selectNode(final Node node, final Object selector) {
        fireViewerModelEvent(new ViewerModelEvent(selector, ViewerModelEvent.NODE_SELECTED, node));
    }

    /**
     * Appends the given fragment to the XPath expression.
     *
     * @param pathFragment
     *            fragment to be added
     * @param appender
     *            object that is trying to append the fragment
     */
    public void appendToXPathExpression(final String pathFragment, final Object appender) {
        fireViewerModelEvent(new ViewerModelEvent(appender, ViewerModelEvent.PATH_EXPRESSION_APPENDED, pathFragment));
    }

    public void addViewerModelListener(final ViewerModelListener l) {
        listeners.add(l);
    }

    public void removeViewerModelListener(final ViewerModelListener l) {
        listeners.remove(l);
    }

    protected void fireViewerModelEvent(final ViewerModelEvent e) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).viewerModelChanged(e);
        }
    }
}
