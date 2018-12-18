package ProblemSolving;

import java.util.ArrayList;

public class Solution {
    private ArrayList<State> states;
    private int expandedNodesNum;
    private int visitedNodesNum;
    private int maxNumberOfStoredNodes;
    private int pathCost;

    public Solution(Node node, int expandedNodesNum, int visitedNodesNum, int maxNumberOfStoredNodes) {
        this.expandedNodesNum = expandedNodesNum;
        this.visitedNodesNum = visitedNodesNum;
        this.maxNumberOfStoredNodes = maxNumberOfStoredNodes;
        states = makeSolution(node);

    }

    public ArrayList<State> makeSolution(Node node) {
        ArrayList<State> pathStates = new ArrayList<>();

        pathCost = node.getPathCost();
        while (node != null) {
            pathStates.add(0, node.getState());
            node = node.getParent();
        }
//        System.out.println(pathStates.size());
        return pathStates;
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
