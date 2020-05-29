/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.dfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sourceforge.pmd.lang.DataFlowHandler;
import net.sourceforge.pmd.lang.ast.Node;

/**
 * Structure contains only raw data. A set of nodes which represent a
 * data flow and 2 stacks to link the nodes to each other.
 *
 * @author raik
 */
public class Structure {
    private static final Logger LOGGER = Logger.getLogger(Structure.class.getName());

    private final DataFlowHandler dataFlowHandler;
    private List<DataFlowNode> dataFlow = new ArrayList<>();
    private Stack<StackObject> braceStack = new Stack<>();
    private Stack<StackObject> continueBreakReturnStack = new Stack<>();

    public Structure(final DataFlowHandler dataFlowHandler) {
        this.dataFlowHandler = dataFlowHandler;
    }

    /**
     * This class encapsulates the access to the DataFlowNode class. Is this
     * worthwhile? TODO I think it's too confusing to have the DataFlowNode
     * constructor add the created instance to the List. I think it'd be clearer
     * if we did that more "procedurally", i.e., create the object, then add it
     * to the list.
     */
    public DataFlowNode createNewNode(final Node node) {
        return dataFlowHandler.createDataFlowNode(dataFlow, node);
    }

    public DataFlowNode createStartNode(final int line) {
        return new StartOrEndDataFlowNode(this.dataFlow, line, true);
    }

    public DataFlowNode createEndNode(final int line) {
        return new StartOrEndDataFlowNode(this.dataFlow, line, false);
    }

    public DataFlowNode getLast() {
        return this.dataFlow.get(this.dataFlow.size() - 1);
    }

    public DataFlowNode getFirst() {
        return this.dataFlow.get(0);
    }

    // ----------------------------------------------------------------------------
    // STACK FUNCTIONS

    /**
     * The braceStack contains all nodes which are important to link the data
     * flow nodes. The cbrStack contains continue, break, and return nodes.
     * There are 2 Stacks because the have to process differently.
     */
    public void pushOnStack(final NodeType type, final DataFlowNode node) {
        StackObject obj = new StackObject(type, node);
        if (type == NodeType.RETURN_STATEMENT || type == NodeType.BREAK_STATEMENT || type == NodeType.CONTINUE_STATEMENT
            || type == NodeType.THROW_STATEMENT) {
            // ugly solution - stores the type information in two ways
            continueBreakReturnStack.push(obj);
            tryToLog("continueBreakReturnStack", node);
        } else {
            braceStack.push(obj);
            tryToLog("braceStack", node);
        }
        node.setType(type);
    }

    protected void tryToLog(final String tag, final DataFlowNode node) {
        if (LOGGER.isLoggable(Level.FINEST)) {
            LOGGER.finest(tag + ": line" + node.getNode().getBeginLine() + ", column "
                + node.getNode().getBeginColumn() + " - " + node.toString());
        }
    }

    public List<StackObject> getBraceStack() {
        return braceStack;
    }

    public List<StackObject> getContinueBreakReturnStack() {
        return continueBreakReturnStack;
    }

    /**
     * @return formatted dump of the DFA Structure's
     */
    public String dump() {
        StringBuilder stringDump = new StringBuilder(120).append("Data Flow Analysis Structure:\n")
            .append("    Edge Nodes (ContinueBraceReturn) :");
        for (StackObject stackObject : continueBreakReturnStack) {
            stringDump.append("\nCBR => ").append(stackObject.toString());
        }
        stringDump.append("\n    Scope Nodes:");
        for (StackObject stackObject : braceStack) {
            stringDump.append("\nBraces => ").append(stackObject.toString());
        }
        return stringDump.toString();
    }

}
