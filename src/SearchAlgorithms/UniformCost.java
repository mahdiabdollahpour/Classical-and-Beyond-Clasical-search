package SearchAlgorithms;

import ProblemSolving.Action;
import ProblemSolving.Node;
import ProblemSolving.Problem;
import ProblemSolving.State;

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
        expandedNodesNum++;

        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Action> actions = node.getState().getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            State next = p.transitionModel(node.getState(), action);
            int pathCost = node.getPathCost() + action.getStepCost();
            nodes.add(new Node(next, node, pathCost, pathCost));
        }
        return nodes;
    }

    @Override
    public void addToFrontier(Node node) {
        frontier.add(node);
    }
}
