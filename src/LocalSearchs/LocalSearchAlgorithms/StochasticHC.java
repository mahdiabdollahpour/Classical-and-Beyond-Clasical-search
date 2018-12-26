package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.State;

import java.util.ArrayList;
import java.util.Random;

public class StochasticHC extends SimpleHC {
    public StochasticHC(Problem problem) {
        super(problem);
    }

    protected State chooseNode(ArrayList<State> neighbors, State now) {
        double nowVal = problem.stateValue(now);
        ArrayList<State> goodStates = new ArrayList<>();
        for (int i = 0; i < neighbors.size(); i++) {
            double val = problem.stateValue(neighbors.get(i));
            if (val > nowVal) {
                goodStates.add(neighbors.get(i));

            }
        }
        if (goodStates.size() > 0) {
            return goodStates.get(new Random(System.currentTimeMillis()).nextInt(goodStates.size()));
        } else {
            return null;
        }
    }
}
