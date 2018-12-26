package LocalSearchs.LocalSearchAlgorithms;


import LocalSearchs.Problem;
import LocalSearchs.Solution;
import LocalSearchs.State;

import java.util.ArrayList;

public class SimpleHC extends LocalSearch {
    protected Problem problem;

    public SimpleHC(Problem problem) {
        super(problem);
        this.problem = problem;
    }


    protected State chooseNode(ArrayList<State> neighbors, State now) {
        double maxVal = problem.stateValue(now);
        State maxState = null;
        for (int i = 0; i < neighbors.size(); i++) {
            double val = problem.stateValue(neighbors.get(i));
            if (val > maxVal) {
                maxState = neighbors.get(i);
                maxVal = val;
            }
        }
        return maxState;
    }

    public Solution getAnswer() {
        State current = problem.getInitialState();
        while (true) {
            ArrayList<State> neighbors = problem.getNeighbors(current);
            State next = chooseNode(neighbors, current);
            if (next == null) {
                return new Solution(current, problem.stateValue(current));
            }
            current = next;
        }
    }


}
