package ClassicalSearch;

import ClassicalSearch.ClassicalSearchAlgorithms.*;
import ClassicalSearch.ProblemSolving.Problem;

import ClassicalSearch.ProblemSolving.Solution;
import ClassicalSearch.Problems.Problem1;

public class Main {
    public static void main(String[] args) {
        Problem p = new Problem1();
        BFS s = new BFS(p, true);
//        Solution solution = bfs.search();

//        DFS s = new DFS(p, true);
//        Solution solution = dfs.search();
//
//        UniformCost s = new UniformCost(p, true);
//        Solution solution = uniformCost.search();

//        ProblemSolvingAgent problemSolvingAgent = new GreedyBestFirst(p, true);
//        IterativeDeepeningDFS s = new IterativeDeepeningDFS(p, true);
//        GreedyBestFirst s = new GreedyBestFirst(p, true);
//        AStar s = new AStar(p, true);
//        ProblemSolvingAgent problemSolvingAgent = new AStar(p, true);


//        ProblemSolvingAgent problemSolvingAgent = new IterativeDeepeningDFS(p, true);


        Solution solution = (s).search();


        System.out.println(solution);


    }
}
