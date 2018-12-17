package SearchAlgorithms;

import ProblemSolving.Node;
import ProblemSolving.Problem;
import ProblemSolving.State;

import java.util.ArrayList;

public abstract class BestFirstSearch extends Search{
    public BestFirstSearch(Problem p, Boolean graphSearch) {
        super(p, graphSearch);
    }

    @Override
    public Node getLeaf() {
        return null;
    }

    @Override
    public ArrayList<Node> expand(Node node) {
        return null;
    }

    @Override
    public void addToFrontier(Node node) {

    }
    protected abstract int getH(State state);
}
