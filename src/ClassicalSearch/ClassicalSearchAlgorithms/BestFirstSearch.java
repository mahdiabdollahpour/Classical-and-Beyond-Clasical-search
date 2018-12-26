package ClassicalSearch.ClassicalSearchAlgorithms;
import ClassicalSearch.ProblemSolving.Node;
import ClassicalSearch.ProblemSolving.Problem;
import java.util.PriorityQueue;

public abstract class BestFirstSearch extends Search{
    public BestFirstSearch(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
    }

    @Override
    public Node getLeaf() {
        return (Node) ((PriorityQueue) frontier).poll();
    }



}
