package SearchAlgorithms;

import java.util.ArrayList;

public class DFS extends Search {

    public DFS(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        frontier = new ArrayList<>();

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
        ArrayList<Action> actions = node.state.getActions();
        for (int i = 0; i < actions.size(); i++) {
            nodes.add(new Node(p.transitionModel(node.getState(), actions.get(i))));
        }
        return nodes;
    }

    @Override
    public void addToFrontier(Node node) {
        frontier.add(node);
    }
}
