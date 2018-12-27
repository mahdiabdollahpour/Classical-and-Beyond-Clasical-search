package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.Solution;
import LocalSearchs.State;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing extends LocalSearch {
    public SimulatedAnnealing(Problem problem) {
        super(problem);
    }

    @Override
    public Solution getAnswer() {
        State current = problem.getInitialState();
        for (int i = 1; ; i++) {
            double t = schedule(i);
            if (t < Double.MIN_VALUE * 2) {
                return new Solution(current, problem.stateValue(current),expandedStatesNumber,visitedStatesNumber);
            }
            State next = getRandomNeighbor(current);
            expandedStatesNumber++;
            visitedStatesNumber += 1;
            double deltaE = problem.stateValue(next) - problem.stateValue(current);
            if (deltaE > 0) {
                current = next;
            } else {
                double prob = Math.exp(deltaE / (double) t);
                if (Math.random() < prob) {
                    current = next;
                }
            }


        }
    }

    private State getRandomNeighbor(State state) {
        //TODO: I can do better
        ArrayList<State> neighbors = problem.getNeighbors(state);

        Random random = new Random(System.currentTimeMillis());
        return neighbors.get(random.nextInt() % neighbors.size());
    }

    private double t0 = 1;

    private double schedule(int i) {
        //TODO: implemet this
        return t0 / (1 + Math.log(1 + i));
    }


}
