package SearchAlgorithms;

import ProblemSolving.Action;
import ProblemSolving.Node;
import ProblemSolving.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCost extends Search {
    public UniformCost(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        frontier = (List<Node>) new PriorityQueue<Node>();
    }

    @Override
    public Node getLeaf() {
        return (Node) ((PriorityQueue) frontier).poll();
    }

    @Override
    public ArrayList<Node> expand(Node node) {
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Action> actions = node.state.getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            nodes.add(new Node(p.transitionModel(node.getState(), action), null, node.getPathCost() + action.getStepCost()));
        }
        return nodes;
    }

    @Override
    public void addToFrontier(Node node) {
        frontier.add(node);
    }
}
