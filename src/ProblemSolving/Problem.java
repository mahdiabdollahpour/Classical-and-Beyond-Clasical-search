package ProblemSolving;

import java.util.ArrayList;

public abstract class Problem {
    private ArrayList<State> finalStates;

    public boolean goalTest(State state) {
        return finalStates.contains(state);
    }

    public abstract State getInitialState();

    public abstract State transitionModel(State state, Action action);


}
