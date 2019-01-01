package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.Solution;
import LocalSearchs.State;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing extends LocalSearch {
    public SimulatedAnnealing(Problem problem, double alpha) {
        super(problem);
        this.alpha = alpha;
    }

    @Override
    public Solution getAnswer() {
        State current = problem.getInitialState();
        for (int i = 1; ; i++) {
            double T = schedule(i);
//            System.out.println(T);
            if (T < 0.0000000001) {
                return new Solution(current, problem.stateValue(current), expandedStatesNumber, visitedStatesNumber);
            }
            State next = getRandomNeighbor(current);
            visitedStatesNumber += 1;
            double deltaE = problem.stateValue(next) - problem.stateValue(current);
            if (deltaE > 0) {
                expandedStatesNumber++;
                current = next;
            } else {
                double prob = Math.exp(deltaE / (double) T);
                if (Math.random() < prob) {
                    expandedStatesNumber++;
                    current = next;
                }
            }


        }
    }

    private State getRandomNeighbor(State state) {
        //TODO: I can do better
        ArrayList<State> neighbors = problem.getNeighbors(state);

        Random random = new Random(System.currentTimeMillis());
        return neighbors.get(random.nextInt(neighbors.size()));
    }

    private final double t0 = 1;
    private double alpha;

    private double schedule(int i) {
        //TODO: implemet this
        return t0 / (1 + alpha * i * i);
    }


}
