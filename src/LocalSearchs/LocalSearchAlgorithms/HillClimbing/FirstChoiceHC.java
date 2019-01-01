package LocalSearchs.LocalSearchAlgorithms.HillClimbing;

import LocalSearchs.LocalSearchAlgorithms.HillClimbing.SimpleHC;
import LocalSearchs.Problem;
import LocalSearchs.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstChoiceHC extends SimpleHC {
    public FirstChoiceHC(Problem problem) {
        super(problem);
    }

    protected State chooseNode(ArrayList<State> neighbors, State now) {
        double nowVal = problem.stateValue(now);

        //TODO: I can do better than this
        List<State> newList = new ArrayList<>(neighbors);
        Collections.shuffle(newList);
        for (int i = 0; i < neighbors.size(); i++) {
            visitedStatesNumber++;
            double val = problem.stateValue(newList.get(i));
            if (val > nowVal) {
                return newList.get(i);

            }
        }
        return null;
    }

}
