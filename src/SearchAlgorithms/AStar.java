package SearchAlgorithms;

import ProblemSolving.Action;
import ProblemSolving.Node;
import ProblemSolving.Problem;
import ProblemSolving.State;

import java.util.ArrayList;

public class AStar extends BestFirstSearch {
    public AStar(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
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

            nodes.add(new Node(next, node, pathCost, node.getPathCost() + action.getStepCost() + p.getH(next)));
        }
        return nodes;
    }


}
