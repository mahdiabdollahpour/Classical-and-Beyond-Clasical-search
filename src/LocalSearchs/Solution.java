package LocalSearchs;

public class Solution {
    private State state;
    private double score;

    public State getState() {
        return state;
    }

    public double getScore() {
        return score;
    }

    public Solution(State state, double score) {
        this.state = state;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "state=" + state +
                ", score=" + score +
                '}';
    }
}
