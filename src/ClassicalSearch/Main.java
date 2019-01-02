package ClassicalSearch;

import ClassicalSearch.ClassicalSearchAlgorithms.*;
import ClassicalSearch.ProblemSolving.Problem;

import ClassicalSearch.ProblemSolving.ProblemSolvingAgent;
import ClassicalSearch.ProblemSolving.Solution;
import ClassicalSearch.Problems.Problem1;

public class Main {
    public static void main(String[] args) {
        boolean mode = true;
        Problem p = new Problem1();
        Solution solution;
        ProblemSolvingAgent s;
//        s = new BFS(p, mode);
//        solution = (s).search();
//        System.out.println("BFS");
//        System.out.println(solution);

//        s = new DFS(p, mode);
//        System.out.println("DFS");
//        solution = (s).search();
//        System.out.println(solution);

        s = new UniformCost(p, mode);
        solution = (s).search();
        System.out.println("Unifrom Cost");
        System.out.println(solution);

//
//        s = new IterativeDeepeningDFS(p, mode);
//        solution = (s).search();
//        System.out.println("Iterative");
//        System.out.println(solution);
//        s = new GreedyBestFirst(p, mode);
//        solution = (s).search();
//        System.out.println("Greedy");
//        System.out.println(solution);
//        s = new AStar(p, mode);
//        solution = (s).search();
//        System.out.println("A*");
//        System.out.println(solution);


    }
}
