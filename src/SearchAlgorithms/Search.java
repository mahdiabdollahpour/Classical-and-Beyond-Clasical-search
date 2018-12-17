package SearchAlgorithms;

import ProblemSolving.Node;
import ProblemSolving.Problem;
import ProblemSolving.ProblemSolvingAgent;
import ProblemSolving.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Search extends ProblemSolvingAgent {
    protected List<Node> frontier;

    protected HashSet<Node> explored;

    public abstract Node getLeaf();

    public State search() {
        if (searchMethod) {
            return graphSearch();
        } else {
            return treeSearch();
        }
    }

    public abstract ArrayList<Node> expand(Node node);

    public abstract void addToFrontier(Node node);


    public Search(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        if (graphSearch) {
            explored = new HashSet<>();
        }
    }

    public State graphSearch() {
        frontier.add(new Node(p.getInitialState()));
        explored = new HashSet<>();
        while (true) {
            if (frontier.isEmpty()) {
                return null;
            }
            Node node = getLeaf();
            if (p.goalTest(node.state)) {
                return node.state;
            }
            explored.add(node);
            ArrayList<Node> newNodes = expand(node);
            newNodes.forEach(node1 -> {
                if (!frontier.contains(node1) && !explored.contains(node1)) {
                    addToFrontier(node1);
                }
            });

        }

    }

    public State treeSearch() {
        frontier = new ArrayList<>();
        frontier.add(new Node(p.getInitialState()));
        while (true) {
            if (frontier.isEmpty()) {
                return null;
            }
            Node node = getLeaf();
            if (p.goalTest(node.state)) {
                return node.state;
            }
            ArrayList<Node> newNodes = expand(node);
            newNodes.forEach(node1 -> {
                if (!frontier.contains(node1)) {
                    addToFrontier(node1);
                }
            });
        }

    }
}
