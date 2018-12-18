package SearchAlgorithms;

import ProblemSolving.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class Search extends ProblemSolvingAgent {
    protected int expandedNodesNum;
    protected int visitedNodesNum;
    protected int maxNumberOfStoredNodes;

    protected Collection<Node> frontier;

    protected HashSet<Node> explored;


    public abstract Node getLeaf();

    public Solution search() {
        expandedNodesNum = 0;
        visitedNodesNum = 0;
        maxNumberOfStoredNodes = 0;
        if (searchMethod) {
            return graphSearch();
        } else {
            return treeSearch();
        }
    }

    public void updateMaxNumebrOfStoredNodes() {
        maxNumberOfStoredNodes = Math.max(maxNumberOfStoredNodes, frontier.size() + explored.size());
    }

    public abstract ArrayList<Node> expand(Node node);

    public abstract void addToFrontier(Node node);


    public Search(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        if (graphSearch) {
            explored = new HashSet<>();
        }
    }


    private Solution graphSearch() {
        frontier.add(new Node(p.getInitialState(), null, 0,0));
        explored = new HashSet<>();
        while (true) {
//            System.out.println("hdjkfhkdjfhkjd");
            if (frontier.isEmpty()) {
                return null;
            }
            Node node = getLeaf();
//            System.out.println(node.getState().getName());
            if (p.goalTest(node.getState())) {
                return new Solution(node, expandedNodesNum, visitedNodesNum, maxNumberOfStoredNodes);
            }
            explored.add(node);
            ArrayList<Node> newNodes = expand(node);
            newNodes.forEach(node1 -> {
                if (!frontier.contains(node1) && !explored.contains(node1)) {
                    addToFrontier(node1);
                }
            });
            updateMaxNumebrOfStoredNodes();

        }

    }

    private Solution treeSearch() {
        frontier = new ArrayList<>();
        frontier.add(new Node(p.getInitialState(), null, 0,0));
        updateMaxNumebrOfStoredNodes();
        while (true) {
            if (frontier.isEmpty()) {
                return null;
            }
            Node node = getLeaf();
            if (p.goalTest(node.getState())) {
                return new Solution(node, expandedNodesNum, visitedNodesNum, maxNumberOfStoredNodes);
            }
            ArrayList<Node> newNodes = expand(node);
            newNodes.forEach(node1 -> {
                if (!frontier.contains(node1)) {
                    addToFrontier(node1);
                }
            });
            updateMaxNumebrOfStoredNodes();
        }

    }


}
