package LocalSearchs;


import java.util.Arrays;

public class State {
    private int[] colors;

    public int[] getColors() {
        return colors;
    }

    public State(int[] colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "State{" +
                "colors=" + Arrays.toString(colors) +
                '}';
    }
}
