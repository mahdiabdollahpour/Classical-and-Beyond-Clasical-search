package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.Solution;

public class RandomRestartHC extends LocalSearch {
    private int times;

    public RandomRestartHC(Problem problem, int restartTimes) {
        super(problem);
        this.times = restartTimes;
    }

    @Override
    public Solution getAnswer() {
        SimpleHC hc = new SimpleHC(problem);
        double bestScore = 0;
        Solution best = null;
        // TODO: handel number of visited and ...
        for (int i = 0; i < times; i++) {
            Solution solution = hc.getAnswer();
            if (solution.getScore() > bestScore) {
                bestScore = solution.getScore();
                best = solution;
            }
        }
        return best;

    }
}
