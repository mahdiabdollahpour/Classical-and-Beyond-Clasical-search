package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.State;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing extends LocalSearch {
    public SimulatedAnnealing(Problem problem) {
        super(problem);
    }

    @Override
    public State getAnswer() {
        State current = problem.getInitialState();
        for (int i = 1; ; i++) {
            long t = schedule(i);
            if (t == 0) {
                return current;
            }
            State next = getRandomNeighbor(current);
            int deltaE = problem.stateValue(next) - problem.stateValue(current);
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
        ArrayList<State> neighbors = problem.getNeighbors(state);
        Random random = new Random(System.currentTimeMillis());
        return neighbors.get(random.nextInt() % neighbors.size());
    }

    private int schedule(int i) {
        return 0;
    }


}
