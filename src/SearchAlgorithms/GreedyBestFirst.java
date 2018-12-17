package SearchAlgorithms;

import ProblemSolving.Problem;
import ProblemSolving.State;

public class GreedyBestFirst extends BestFirstSearch{

    public GreedyBestFirst(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
    }

    @Override
    protected int getH(State state) {
        return p.get;
    }
}
