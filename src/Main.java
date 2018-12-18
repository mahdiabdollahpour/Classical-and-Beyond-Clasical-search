import ProblemSolving.Problem;
import ProblemSolving.Solution;
import Problems.Problem1;
import SearchAlgorithms.BFS;
import SearchAlgorithms.DFS;
import SearchAlgorithms.UniformCost;

public class Main {
    public static void main(String[] args) {
        Problem p = new Problem1();
//        BFS bfs = new BFS(p, true);
//        Solution solution = bfs.search();

//        DFS dfs = new DFS(p, true);
//        Solution solution = dfs.search();
//
        UniformCost uniformCost = new UniformCost(p, true);
        Solution solution = uniformCost.search();





        System.out.println(solution);


    }
}
