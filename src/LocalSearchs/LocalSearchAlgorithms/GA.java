package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;

import java.util.ArrayList;

public class GA {
    private Problem problem;
    private double mutateProb;
    private ArrayList<Individual> initialPopulation;

    private int fitnessFunction(Individual individual) {
        return 0;
    }

    private Individual randomSelection(ArrayList<Individual> individuals) {
        return null;
    }

    private Individual crossOver(Individual father, Individual mother) {
        return null;
    }

    private Individual mutate(Individual individual) {
        return null;
    }

    private int populationSize;

    public GA(Problem problem, int populationSize, int mutateProb) {
        this.problem = problem;
        this.populationSize = populationSize;
        this.mutateProb = mutateProb;
    }

    public Individual getAnswer(int t) {
        ArrayList<Individual> population = initialPopulation;
        for (int i = 0; i < t; i++) {
            ArrayList<Individual> newPopulation = new ArrayList<>();
            for (int j = 0; j < populationSize; j++) {
                Individual x = randomSelection(population);
                Individual y = randomSelection(population);
                Individual child = crossOver(x, y);
                if (Math.random() < mutateProb) {
                    child = mutate(child);
                }
                newPopulation.add(child);
            }
            population = newPopulation;

        }
        return getBest(population);
    }

    private Individual getBest(ArrayList<Individual> population) {
        int maxVal = Integer.MIN_VALUE;
        Individual maxState = null;
        for (int i = 0; i < population.size(); i++) {
            int val = fitnessFunction(population.get(i));
            if (val > maxVal) {
                maxState = population.get(i);
                maxVal = val;
            }
        }
        return maxState;
    }


}
