package ClassicalSearch.ClassicalSearchAlgorithms;

import ClassicalSearch.ProblemSolving.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class Search extends ProblemSolvingAgent {
    protected int expandedNodesNum;
    protected int visitedNodesNum;
    protected int maxNumberOfStoredNodes;

    protected Collection<Node> frontier;

    protected ArrayList<Node> explored;


    protected abstract Node getLeaf();

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

    protected void updateMaxNumebrOfStoredNodes() {
        if (searchMethod) {
            maxNumberOfStoredNodes = Math.max(maxNumberOfStoredNodes, frontier.size() + explored.size());

        } else {
            maxNumberOfStoredNodes = Math.max(maxNumberOfStoredNodes, frontier.size());

        }
    }

    protected abstract ArrayList<Node> expand(Node node);

    public void addToFrontier(Node node) {
        frontier.add(node);
        visitedNodesNum++;
    }


    public Search(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
        if (graphSearch) {
            explored = new ArrayList<>();
        }
    }


    private Solution graphSearch() {
        frontier.add(new Node(p.getInitialState(), null, 0, 0));
//        explored = new HashSet<>();
        while (true) {
            if (frontier.isEmpty()) {
                return new Solution(null, expandedNodesNum, visitedNodesNum, maxNumberOfStoredNodes);

            }
//            System.out.println(frontier);
            Node node = getLeaf();
//            System.out.println(node.getState().getName());
//            System.out.println(node.getState().getName());
            if (p.goalTest(node.getState())) {
                return new Solution(node, expandedNodesNum, visitedNodesNum, maxNumberOfStoredNodes);
            }
            explored.add(node);
//            System.out.println(explored);
            ArrayList<Node> newNodes = expand(node);
            for (Node node1 : newNodes) {
                if (!frontier.contains(node1) && !explored.contains(node1)) {
                    addToFrontier(node1);
                }
            }
            updateMaxNumebrOfStoredNodes();

        }

    }

    private Solution treeSearch() {

        frontier.add(new Node(p.getInitialState(), null, 0, 0));
        updateMaxNumebrOfStoredNodes();
        while (true) {
            if (frontier.isEmpty()) {
                return new Solution(null, expandedNodesNum, visitedNodesNum, maxNumberOfStoredNodes);
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
