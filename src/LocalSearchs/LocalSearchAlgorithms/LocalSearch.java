package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.Solution;
import LocalSearchs.State;

public abstract class LocalSearch {
    protected Problem problem;

    public abstract Solution getAnswer();

    public int visitedStatesNumber, expandedStatesNumber;

    public LocalSearch(Problem problem) {
        this.problem = problem;
        visitedStatesNumber = 0;
        expandedStatesNumber = 0;
    }
}
