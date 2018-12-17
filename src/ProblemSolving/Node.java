package ProblemSolving;

public class Node {
    private State state;
    private Node parent;
    private int pathCost;
    private int compareValue;

    public State getState() {
        return state;
    }

    public int getPathCost() {
        return pathCost;
    }

    public Node getParent() {
        return parent;
    }

    public Node(State state, Node parent, int pathCost, int compareValue) {
        this.state = state;
        this.parent = parent;
        this.pathCost = pathCost;
        this.compareValue = compareValue;
    }

//    public Node(State state) {
//        this(state,null,0);
//    }
}
