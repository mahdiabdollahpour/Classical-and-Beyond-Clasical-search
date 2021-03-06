package LocalSearchs;

import LocalSearchs.LocalSearchAlgorithms.GeneticAlgorithm.Chromosome;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Problem {
    protected ArrayList<GraphNode> nodes;


    protected State initialState;


    protected int numberOfColors;

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public Problem(int numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    protected static class GraphNode {
        private String name;
        private int idx;

        public int getIdx() {
            return idx;
        }

        public GraphNode(String name,int idx) {
            this.name = name;
            this.idx = idx;
            adjs = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public ArrayList<GraphNode> getAdjs() {
            return adjs;
        }

        public void addAdjNode(GraphNode... nodes) {
            adjs.addAll(Arrays.asList(nodes));
        }

        private ArrayList<GraphNode> adjs;
    }


    public State getInitialState() {
        return initialState;
    }


    public ArrayList<State> getNeighbors(State state) {
        ArrayList<State> neightbors = new ArrayList<>();
        for (int i = 0; i < state.getColors().length; i++) {
            for (int j = 0; j < state.getColors().length; j++) {
                for (int i1 = 1; i1 < numberOfColors; i1++) {
                    int[] newColors = state.getColors().clone();
                    newColors[j] += i1;
                    newColors[j] = newColors[j] % numberOfColors;
                    State s = new State(newColors);
                    neightbors.add(s);
                }

            }
        }
        return neightbors;


    }


    public double stateValue(State state) {

        double val = 0;
        int[] cols = state.getColors();
        boolean flag = state instanceof Chromosome;
        double m = 0;
        for (int i = 0; i < nodes.size(); i++) {
            ArrayList<GraphNode> neighbors = nodes.get(i).getAdjs();
            for (int i1 = 0; i1 < neighbors.size(); i1++) {
                int otherIdx = neighbors.get(i1).getIdx();
                m++;
                if (flag) {
                    Chromosome chromosome = (Chromosome) state;

                    if (chromosome.getGens().charAt(i) != chromosome.getGens().charAt(otherIdx)) {
                        val++;
                    }
                } else {
                    if (cols[i] != cols[otherIdx]) {
//                        System.out.println(i + "," + i1);
                        val++;
                    }
                }
            }

        }

//        System.out.println(m);
//        System.out.println(val);
        return val / m;
    }

    public ArrayList<GraphNode> getNodes() {
        return nodes;
    }
    public abstract void initToRandom();


}
