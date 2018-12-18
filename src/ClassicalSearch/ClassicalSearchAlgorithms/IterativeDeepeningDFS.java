package ClassicalSearch.ClassicalSearchAlgorithms;

import ClassicalSearch.ProblemSolving.Problem;
import ClassicalSearch.ProblemSolving.ProblemSolvingAgent;
import ClassicalSearch.ProblemSolving.Solution;

public class IterativeDeepeningDFS extends ProblemSolvingAgent {
    private int expandedNodesNum;
    private int visitedNodesNum;
    private int maxNumberOfStoredNodes;


    @Override
    public Solution search() {
        int depth = 0;

        while (true) {
//            System.out.println("hjdhfjkd");
            LimitedDepthDFS limitedDepthDFS = new LimitedDepthDFS(p, searchMethod, depth);
            Solution s = limitedDepthDFS.search();
            expandedNodesNum += s.getExpandedNodesNum();
            maxNumberOfStoredNodes = Math.max(maxNumberOfStoredNodes, s.getMaxNumberOfStoredNodes());
            visitedNodesNum += s.getVisitedNodesNum();

            if (s.getStates() != null) {
//                System.out.println("ghjk");
                return new Solution(s.getStates(), expandedNodesNum, visitedNodesNum, maxNumberOfStoredNodes, s.getPathCost());
            }
            depth++;
        }

    }

    public IterativeDeepeningDFS(Problem p, Boolean graphSearch) {
        super(p, graphSearch);

    }
}
