package SearchAlgorithms;

import ProblemSolving.Action;
import ProblemSolving.Node;
import ProblemSolving.Problem;
import ProblemSolving.State;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirst extends BestFirstSearch {

    public GreedyBestFirst(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        frontier = (List<Node>) new PriorityQueue<Node>();
    }


    @Override
    public ArrayList<Node> expand(Node node) {
        expandedNodesNum++;

        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Action> actions = node.getState().getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action action = actions.get(i);
            State next = p.transitionModel(node.getState(), action);
            nodes.add(new Node(next, node, node.getPathCost() + action.getStepCost(), p.getH(next)));
        }
        return nodes;
    }


}
