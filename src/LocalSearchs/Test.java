package LocalSearchs;

import LocalSearchs.LocalSearchAlgorithms.GeneticAlgorithm.GA;
import LocalSearchs.LocalSearchAlgorithms.HillClimbing.FirstChoiceHC;
import LocalSearchs.LocalSearchAlgorithms.HillClimbing.RandomRestartHC;
import LocalSearchs.LocalSearchAlgorithms.HillClimbing.SimpleHC;
import LocalSearchs.LocalSearchAlgorithms.HillClimbing.StochasticHC;
import LocalSearchs.LocalSearchAlgorithms.LocalSearch;
import LocalSearchs.LocalSearchAlgorithms.SimulatedAnnealing;
import LocalSearchs.MapColoringProblem;
import LocalSearchs.Solution;
import LocalSearchs.StarGraphColoring;

public class Test {
    public static void main(String[] args) {

//        Object solver;
        StarGraphColoring p = new StarGraphColoring();
        LocalSearch solver;
        solver = new SimulatedAnnealing(p,1.0);
//        solver = new GA(p, 1000, 0.02,2);
        Solution s =  solver.getAnswer();
//        ((GA) solver).printConf();
        System.out.println(s);
//        s.showCharts();
    }
}
