package ClassicalSearch;

import ClassicalSearch.ProblemSolving.Problem;
import ClassicalSearch.ProblemSolving.ProblemSolvingAgent;
import ClassicalSearch.ProblemSolving.Solution;
import ClassicalSearch.Problems.Problem1;
import ClassicalSearch.ClassicalSearchAlgorithms.IterativeDeepeningDFS;

public class Main {
    public static void main(String[] args) {
        Problem p = new Problem1();
//        BFS bfs = new BFS(p, true);
//        Solution solution = bfs.search();

//        DFS dfs = new DFS(p, true);
//        Solution solution = dfs.search();
//
//        UniformCost uniformCost = new UniformCost(p, true);
//        Solution solution = uniformCost.search();

//        ProblemSolvingAgent problemSolvingAgent = new GreedyBestFirst(p, true);



//        ProblemSolvingAgent problemSolvingAgent = new AStar(p, true);



        ProblemSolvingAgent problemSolvingAgent = new IterativeDeepeningDFS(p, true);




        Solution solution =  ( problemSolvingAgent).search();


        System.out.println(solution);


    }
}
