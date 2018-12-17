package ProblemSolving;

public class Node {
    public State state;
    Node parent;
    int pathCost;

    public State getState() {
        return state;
    }

    public int getPathCost() {
        return pathCost;
    }

    public Node getParent() {
        return parent;
    }

    public Node(State state, Node parent, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.pathCost = pathCost;
    }

    public Node(State state) {
        this(state,null,0);
    }
}
