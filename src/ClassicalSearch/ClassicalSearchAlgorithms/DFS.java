package ClassicalSearch.ClassicalSearchAlgorithms;

import ClassicalSearch.ProblemSolving.Action;
import ClassicalSearch.ProblemSolving.Node;
import ClassicalSearch.ProblemSolving.Problem;

import java.util.ArrayList;

public class DFS extends Search {

    public DFS(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        frontier = new ArrayList<>();

    }

    @Override
    public Node getLeaf() {
        if (!frontier.isEmpty()) {
            return ((ArrayList<Node>) frontier).remove(frontier.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Node> expand(Node node) {

        expandedNodesNum++;

        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Action> actions = node.getState().getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            int pathCost = node.getPathCost() + action.getStepCost();

            nodes.add(new Node(p.transitionModel(node.getState(), action), node, pathCost, node.getPathCost() + 1));
        }
        return nodes;
    }


}
