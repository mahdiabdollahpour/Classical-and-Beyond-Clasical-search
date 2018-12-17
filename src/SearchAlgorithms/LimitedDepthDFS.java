package SearchAlgorithms;

import ProblemSolving.Action;
import ProblemSolving.Node;
import ProblemSolving.Problem;

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
            return frontier.get(frontier.size() - 1);
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Node> expand(Node node) {

        ArrayList<Node> nodes = new ArrayList<>();
        if (node.getPathCost() < limit) {
            ArrayList<Action> actions = node.state.getActions();
            for (int i = 0; i < actions.size(); i++) {
                Action action = actions.get(i);

                nodes.add(new Node(p.transitionModel(node.getState(), action), null, node.getPathCost() + 1));
            }
        }
        return nodes;
    }

    @Override
    public void addToFrontier(Node node) {
        frontier.add(node);
    }
}
