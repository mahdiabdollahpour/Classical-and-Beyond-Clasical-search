package LocalSearchs.LocalSearchAlgorithms;


import LocalSearchs.Problem;
import LocalSearchs.State;

import java.util.ArrayList;

public class HillClimbing extends LocalSearch {
    private Problem problem;

    public HillClimbing(Problem problem) {
        super(problem);
        this.problem = problem;
    }


    private State chooseNode(ArrayList<State> neighbors, State now) {
        int maxVal = problem.stateValue(now);
        State maxState = null;
        for (int i = 0; i < neighbors.size(); i++) {
            int val = problem.stateValue(neighbors.get(i));
            if (val > maxVal) {
                maxState = neighbors.get(i);
                maxVal = val;
            }
        }
        return maxState;
    }
    public State getAnswer() {
        State current = problem.getInitialState();
        while (true) {
            ArrayList<State> neighbors = problem.getNeighbors(current);
            State next = chooseNode(neighbors, current);
            if (current == null) {
                return current;
            }
            current = next;
        }
    }


}
