package LocalSearchs.LocalSearchAlgorithms;

import LocalSearchs.Problem;
import LocalSearchs.Solution;

import java.util.ArrayList;
import java.util.Random;

public class GA {
    private Problem problem;
    private double mutationRate;
    private ArrayList<Chromosome> initialPopulation;
    private int stringLength;
    private Random random = new Random(System.currentTimeMillis());

    private double fitnessFunction(Chromosome chromosome) {
        return problem.stateValue(chromosome);

    }

    private Chromosome randomSelection(ArrayList<Chromosome> chromosomes) {
        return chromosomes.get(random.nextInt(populationSize));
    }

    private Chromosome crossOver(Chromosome father, Chromosome mother) {
        int r = random.nextInt(stringLength);
        StringBuilder newS = new StringBuilder("");
        newS.append(father.getGens().substring(0, r));
        newS.append(mother.getGens().substring(r, stringLength));
        return new Chromosome(newS);
    }

    private char getRandomGen() {
        int r = random.nextInt(4);
        return (char) ((int) ('a') + r);
    }

    private Chromosome mutate(Chromosome chromosome) {
        int idx = random.nextInt(stringLength);
        chromosome.getGens().deleteCharAt(idx);
        chromosome.getGens().insert(idx, getRandomGen());
        return chromosome;
    }

    private int populationSize;

    private Chromosome getRandomChor() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(getRandomGen());
        }
        Chromosome chromosome = new Chromosome(stringBuilder);
        return chromosome;
    }

    public GA(Problem problem, int populationSize, double mutationRate, int stringLength) {
        this.problem = problem;
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.stringLength = stringLength;
        initialPopulation = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            initialPopulation.add(getRandomChor());
        }
    }

    public Solution getAnswer(int t) {
        ArrayList<Chromosome> population = initialPopulation;
        for (int i = 0; i < t; i++) {
            ArrayList<Chromosome> newPopulation = new ArrayList<>();
            for (int j = 0; j < populationSize; j++) {
                Chromosome x = randomSelection(population);
                Chromosome y = randomSelection(population);
                Chromosome child = crossOver(x, y);
//                if (Math.random() < mutationRate) {
//                    child = mutate(child);
//                }
                newPopulation.add(child);
            }

            int mutateNum = (int) (mutationRate * populationSize * stringLength);
            for (int j = 0; j < mutateNum; j++) {
                Chromosome x = newPopulation.remove(random.nextInt(populationSize));
                Chromosome newc = mutate(x);
                newPopulation.add(newc);
            }
            population = newPopulation;

        }
        return getBest(population);
    }

    private Solution getBest(ArrayList<Chromosome> population) {
        double maxVal = Integer.MIN_VALUE;
        Chromosome maxState = null;
        for (int i = 0; i < population.size(); i++) {
            double val = fitnessFunction(population.get(i));
            if (val > maxVal) {
                maxState = population.get(i);
                maxVal = val;
            }
        }
        return new Solution(maxState,maxVal);
    }


}
