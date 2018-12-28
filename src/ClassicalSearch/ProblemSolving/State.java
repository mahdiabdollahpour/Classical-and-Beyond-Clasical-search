package ClassicalSearch.ProblemSolving;

import java.util.*;

public class State {

    private String name;
    private int heuristicValue;
    private ArrayList<Action> actions;
    private int id;

    public int getHValue() {
        return heuristicValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name);
    }


    public State(String name, int id, int heuristicValue) {
        this.name = name;
        this.id = id;
        actions = new ArrayList<>();
        this.heuristicValue = heuristicValue;
    }


    public void addAction(Action action) {
        actions.add(action);
    }


    @Override
    public String toString() {
        return  name;
    }

    boolean flag = false;

    public ArrayList<Action> getActions() {
        if (!flag) {
            ArrayList<Action> newList = new ArrayList<>(actions);
            Collections.shuffle(newList);
            actions = newList;
//            System.out.println(actions);
            flag = true;
        }
        return actions;
    }
}
