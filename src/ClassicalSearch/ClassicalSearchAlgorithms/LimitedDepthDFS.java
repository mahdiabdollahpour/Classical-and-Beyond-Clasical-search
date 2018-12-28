package ClassicalSearch.ClassicalSearchAlgorithms;

import ClassicalSearch.ProblemSolving.Action;
import ClassicalSearch.ProblemSolving.Node;
import ClassicalSearch.ProblemSolving.Problem;

import java.util.ArrayList;

public class LimitedDepthDFS extends Search {
    private int limit;

    public LimitedDepthDFS(Problem p, Boolean graphSearch, int limit) {
        super(p, graphSearch);
        frontier = new ArrayList<>();
        this.limit = limit;
    }

    @Override
    public Node getLeaf() {
        if (!frontier.isEmpty()) {
            Node node = ((ArrayList<Node>) frontier).get(frontier.size() - 1);
            frontier.remove(node);
            return node;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Node> expand(Node node) {
        expandedNodesNum++;

        ArrayList<Node> nodes = new ArrayList<>();
        if (node.getCompareValue() < limit) {
            ArrayList<Action> actions = node.getState().getActions();
            for (int i = 0; i < actions.size(); i++) {
                Action action = actions.get(i);
                int pathCost = node.getPathCost() + action.getStepCost();
                nodes.add(new Node(p.transitionModel(node.getState(), action), node, pathCost, node.getCompareValue() + 1));
            }
        }
        return nodes;
    }

}
