package ProblemSolving;

import java.util.ArrayList;
import java.util.Objects;

public class State {

    private String name;

    public int getHValue() {
        return hValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id &&
                Objects.equals(name, state.name);
    }


    public State(String name, int id, int hValue) {
        this.name = name;
        this.id = id;
        actions = new ArrayList<>();
        this.hValue = hValue;
    }

    private int hValue;
    private ArrayList<Action> actions;

    public void addAction(Action action) {
        actions.add(action);
    }

    private int id;

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }

    public ArrayList<Action> getActions() {
        return actions;
    }
}
