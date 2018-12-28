package ClassicalSearch.ClassicalSearchAlgorithms;

import ClassicalSearch.ProblemSolving.Action;
import ClassicalSearch.ProblemSolving.Node;
import ClassicalSearch.ProblemSolving.Problem;
import ClassicalSearch.ProblemSolving.State;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class UniformCost extends Search {
    public UniformCost(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        frontier =  new PriorityQueue<Node>();
    }

    @Override
    public Node getLeaf() {
//        System.out.println(frontier);
        Node n = (Node) ((PriorityQueue) frontier).poll();
//        System.out.println(n);
        return n;

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
//            System.out.println(pathCost);
            nodes.add(new Node(next, node, pathCost, pathCost));
        }
        return nodes;
    }


}
