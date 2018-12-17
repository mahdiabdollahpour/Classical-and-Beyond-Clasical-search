package SearchAlgorithms;

public class IterativeDeepeningDFS extends ProblemSolvingAgent {

    @Override
    public State search() {
        int depth = 0;
        while (true) {

            LimitedDepthDFS limitedDepthDFS = new LimitedDepthDFS(p,searchMethod,0);
            State s = limitedDepthDFS.search();
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
