package ClassicalSearch.ClassicalSearchAlgorithms;

import ClassicalSearch.ProblemSolving.Action;
import ClassicalSearch.ProblemSolving.Node;
import ClassicalSearch.ProblemSolving.Problem;

import java.util.ArrayList;

public class BFS extends Search {


    public BFS(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        frontier = new ArrayList<>();

    }

    @Override
    public Node getLeaf() {
        if (!frontier.isEmpty()) {

            Node node = ((ArrayList<Node>) frontier).remove(0);
            frontier.remove(0);
            return node;
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

            int pathCost = node.getPathCost() + actions.get(i).getStepCost();
            nodes.add(new Node(p.transitionModel(node.getState(), actions.get(i)), node, pathCost, 0));
        }
        return nodes;
    }


}
