package ProblemSolving;

public abstract class ProblemSolvingAgent {
    abstract State search();

    protected Boolean searchMethod;
    protected Problem p;

    public ProblemSolvingAgent(Problem p, Boolean graphSearch) {
        this.p = p;
        this.searchMethod = graphSearch;

    }
}
