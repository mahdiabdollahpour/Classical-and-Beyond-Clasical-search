package ClassicalSearch.ProblemSolving;

public abstract class ProblemSolvingAgent {
    public abstract Solution search();

    protected Boolean searchMethod;
    protected Problem p;

    public ProblemSolvingAgent(Problem p, Boolean graphSearch) {
        this.p = p;
        this.searchMethod = graphSearch;

    }
}
