package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.State;

public abstract class LocalSearch {
    protected Problem problem;

    public abstract State getAnswer();

    public int visitedStatesNumber, expandedStatesNumber;

    public LocalSearch(Problem problem) {
        this.problem = problem;
        visitedStatesNumber = 0;
        expandedStatesNumber = 0;
    }
}
