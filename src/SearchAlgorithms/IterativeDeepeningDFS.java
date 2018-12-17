package SearchAlgorithms;

import ProblemSolving.Problem;
import ProblemSolving.ProblemSolvingAgent;
import ProblemSolving.Solution;
import ProblemSolving.State;

public class IterativeDeepeningDFS extends ProblemSolvingAgent {

    @Override
    public Solution search() {
        int depth = 0;
        while (true) {

            LimitedDepthDFS limitedDepthDFS = new LimitedDepthDFS(p, searchMethod, depth);
            Solution s = limitedDepthDFS.search();
            if (s != null) {
                return s;
            }
            depth++;
        }

    }

    public IterativeDeepeningDFS(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
    }
}
