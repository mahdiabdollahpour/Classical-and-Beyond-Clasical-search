package LocalSearchs;

public class Solution {
    private State state;
    private double score;
    private double[] maxs;
    private double[] mins;
    private double[] avgs;
    private int iterationsTillOptimum;

    public int getIterationsTillOptimum() {
        return iterationsTillOptimum;
    }

    public void setIterationsTillOptimum(int iterationsTillOptimum) {
        this.iterationsTillOptimum = iterationsTillOptimum;
    }

    public double[] getMaxs() {
        return maxs;
    }

    public void setMaxs(double[] maxs) {
        this.maxs = maxs;
    }

    public double[] getMins() {
        return mins;
    }

    public void setMins(double[] mins) {
        this.mins = mins;
    }

    public double[] getAvgs() {
        return avgs;
    }

    public void setAvgs(double[] avgs) {
        this.avgs = avgs;
    }

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
