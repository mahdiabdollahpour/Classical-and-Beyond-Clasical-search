package LocalSearchs.LocalSearchAlgorithms.HillClimbing;

import LocalSearchs.LocalSearchAlgorithms.LocalSearch;
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
        double bestScore = 0;
        Solution best = null;
        SimpleHC hc = new SimpleHC(problem);

        // TODO: handel number of visited and ... -> done
        for (int i = 0; i < times; i++) {
            problem.initToRandom();
            Solution solution = hc.getAnswer();

            visitedStatesNumber += solution.getVisitedStatesNumber();
            expandedStatesNumber += solution.getExpandedStatesNumber();

            if (solution.getScore() > bestScore) {
                bestScore = solution.getScore();
                best = solution;
            }
        }
        if (best != null) {

            best.setExpandedStatesNumber(expandedStatesNumber);
            best.setVisitedStatesNumber(visitedStatesNumber);
        }
        return best;

    }
}
