package LocalSearchs;

import java.util.ArrayList;

public abstract class Problem {
    public abstract State getInitialState();

    public abstract ArrayList<State> getNeighbors(State state);

    public abstract int stateValue(State state);

}
