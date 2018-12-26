package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.State;

import java.util.Objects;

public class Chromosome extends State {
    private StringBuilder gens;

    public Chromosome(StringBuilder gens) {
        super(null);
        this.gens = gens;
    }

    public StringBuilder getGens() {
        return gens;
    }

    @Override
    public String toString() {
        return gens.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chromosome that = (Chromosome) o;
        return Objects.equals(gens.toString(), that.gens.toString());
    }

}
