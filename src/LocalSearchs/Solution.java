package LocalSearchs;

import java.util.Arrays;

public class Solution {
    private State state;
    private double score;
    private double[] maxs;
    private double[] mins;
    private double[] avgs;
    private int iterationsTillOptimum;
    private boolean isGa;
    private int visitedStatesNumber, expandedStatesNumber;

    public int getVisitedStatesNumber() {
        return visitedStatesNumber;
    }

    public void setVisitedStatesNumber(int visitedStatesNumber) {
        this.visitedStatesNumber = visitedStatesNumber;
    }

    public int getExpandedStatesNumber() {
        return expandedStatesNumber;
    }

    public void setExpandedStatesNumber(int expandedStatesNumber) {
        this.expandedStatesNumber = expandedStatesNumber;
    }

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

    public Solution(State state, double score, boolean isGa) {
        this.state = state;
        this.score = score;
        this.isGa = isGa;
    }

    public Solution(State state, double score, int expandedStatesNumber, int visitedStatesNumber) {
        this(state, score, false);
        this.expandedStatesNumber = expandedStatesNumber;
        this.visitedStatesNumber = visitedStatesNumber;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("").append("Solution{" +
                "state=" + state + "\n" +
                ", score=" + score + "\n");
        if (isGa) {
            s.append(", maxs=" + Arrays.toString(maxs) + "\n" +
                    ", mins=" + Arrays.toString(mins) + "\n" +
                    ", avgs=" + Arrays.toString(avgs) + "\n" +
                    ", iterationsTillOptimum=" + iterationsTillOptimum + "\n" + '}');
        } else {
            s.append(", expandedStatesNumber=" + expandedStatesNumber + "\n" +
                    ", visitedStatesNumber=" + visitedStatesNumber + "\n" + "}");
        }
        return s.toString();
    }
}
