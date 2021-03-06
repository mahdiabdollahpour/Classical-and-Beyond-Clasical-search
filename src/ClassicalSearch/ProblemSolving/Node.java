package ClassicalSearch.ProblemSolving;

import java.util.Objects;

public class Node implements Comparable {
    private State state;
    private Node parent;
    private int pathCost;
    private int compareValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return state.getName().equals(node.getState().getName()) && compareValue == node.compareValue;
    }

    public int getCompareValue() {
        return compareValue;
    }

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

    @Override
    public int compareTo(Object o) {
//        System.out.println("jhhj");
        return Integer.compare(compareValue, ((Node) o).getCompareValue());
    }

//    public Node(State state) {
//        this(state,null,0);
//    }


    @Override
    public String toString() {
        return "Node{" +
                "state=" + state + " = " + compareValue +
                '}';
    }
}
