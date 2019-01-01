package LocalSearchs;

import org.knowm.xchart.Histogram;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;

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

    public void showCharts() {
        if (isGa) {
            double XAxis[] = new double[maxs.length];
            for (int i = 0; i < XAxis.length; i++) {
                XAxis[i] = i + 1;
            }

            new SwingWrapper(QuickChart.getChart("Best Fitness", "n", "fitness", "best fitness", XAxis, maxs)).displayChart();
            new SwingWrapper(QuickChart.getChart("Avg Fitness", "n", "fitness", "avg fitness", XAxis, avgs)).displayChart();
            new SwingWrapper(QuickChart.getChart("Worst Fitness", "n", "fitness", "worst fitness", XAxis, mins)).displayChart();
        } else {
            System.out.println("This Option is for GA answer");
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("").append(
                "state=" + state + "\n" +
                        "score=" + score + "\n");
        if (isGa) {
            s.append(
//                    "maxs=" + Arrays.toString(maxs) + "\n" +
//                    "mins=" + Arrays.toString(mins) + "\n" +
//                    "avgs=" + Arrays.toString(avgs) + "\n" +
                    "iterationsTillOptimum=" + iterationsTillOptimum + "\n");
        } else {
            s.append("expandedStatesNumber=" + expandedStatesNumber + "\n" +
                    "visitedStatesNumber=" + visitedStatesNumber + "\n");
        }
        return s.toString();
    }
}
