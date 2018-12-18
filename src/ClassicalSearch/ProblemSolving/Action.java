package ClassicalSearch.ProblemSolving;

public class Action {

    private int stepCost;
    private State destination;

    public State getDestination() {
        return destination;
    }

    public Action(int stepCost, State destination) {
        this.stepCost = stepCost;
        this.destination = destination;
    }

    public int getStepCost() {
        return stepCost;
    }

}
