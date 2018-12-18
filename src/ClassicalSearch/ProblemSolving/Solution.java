package ClassicalSearch.ProblemSolving;

import java.util.ArrayList;

public class Solution {
    private ArrayList<State> states;
    private int expandedNodesNum;
    private int visitedNodesNum;
    private int maxNumberOfStoredNodes;
    private int pathCost;

    public Solution(ArrayList<State> states, int expandedNodesNum, int visitedNodesNum, int maxNumberOfStoredNodes, int pathCost) {
        this.states = states;
        this.expandedNodesNum = expandedNodesNum;
        this.visitedNodesNum = visitedNodesNum;
        this.maxNumberOfStoredNodes = maxNumberOfStoredNodes;
        this.pathCost = pathCost;
    }

    public int getExpandedNodesNum() {
        return expandedNodesNum;
    }

    public int getVisitedNodesNum() {
        return visitedNodesNum;
    }

    public int getMaxNumberOfStoredNodes() {
        return maxNumberOfStoredNodes;
    }

    public int getPathCost() {
        return pathCost;
    }

    public Solution(Node node, int expandedNodesNum, int visitedNodesNum, int maxNumberOfStoredNodes) {
        this.expandedNodesNum = expandedNodesNum;
        this.visitedNodesNum = visitedNodesNum;
        this.maxNumberOfStoredNodes = maxNumberOfStoredNodes;
        states = makeSolution(node);

    }

    public ArrayList<State> getStates() {
        return states;
    }

    public ArrayList<State> makeSolution(Node node) {
        if (node != null) {
            ArrayList<State> pathStates = new ArrayList<>();

            pathCost = node.getPathCost();
            while (node != null) {
                pathStates.add(0, node.getState());
                node = node.getParent();
            }
//        System.out.println(pathStates.size());
            return pathStates;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "states=" + states +
                ", expandedNodesNum=" + expandedNodesNum +
                ", visitedNodesNum=" + visitedNodesNum +
                ", maxNumberOfStoredNodes=" + maxNumberOfStoredNodes +
                ", pathCost=" + pathCost +
                '}';
    }
}
