package LocalSearchs.LocalSearchAlgorithms.GeneticAlgorithm;

import LocalSearchs.Problem;
import LocalSearchs.Solution;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class GA {
    private Problem problem;
    private double mutationRate;
    private ArrayList<Chromosome> initialPopulation;
    private int stringLength;
    private Random random = new Random(System.currentTimeMillis());
    private int k = 0;

    private double fitnessFunction(Chromosome chromosome) {
        return problem.stateValue(chromosome);

    }

    private Chromosome tornumentSelection(ArrayList<Chromosome> chromosomes) {
        ArrayList<Chromosome> gp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Chromosome chromosome = null;
            do {
                int r = random.nextInt(chromosomes.size());
                chromosome = chromosomes.get(r);
            } while (gp.contains(chromosome));
            gp.add(chromosome);
        }
        return (Chromosome) getBest(gp).getState();
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
        return new Chromosome(stringBuilder);
    }

    public GA(Problem problem, int populationSize, double mutationRate, int stringLength, int k) {
        this.problem = problem;
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.stringLength = stringLength;
        this.k = k;
        initialPopulation = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            initialPopulation.add(getRandomChor());
        }
    }

    public Solution getAnswer(int t) {
        ArrayList<Chromosome> population = initialPopulation;
        double[] mins = new double[t];
        double[] maxs = new double[t];
        double[] avgs = new double[t];
        int tillOp = -1;
        for (int i = 0; i < t; i++) {
            ArrayList<Chromosome> newPopulation = new ArrayList<>();
            for (int j = 0; j < populationSize; j++) {
                Chromosome x = tornumentSelection(population);
                Chromosome y = tornumentSelection(population);
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

            Double[] numbers = getNumbers(population);

            Supplier<DoubleStream> supplier = () -> Stream.of(numbers).mapToDouble(Double::valueOf);
            mins[i] = supplier.get().min().getAsDouble();
            maxs[i] = supplier.get().max().getAsDouble();
            avgs[i] = supplier.get().average().getAsDouble();
            if (maxs[i] == 1) {
                tillOp = i;
                break;
            }

        }
        Solution solution = getBest(population);
        solution.setAvgs(avgs);
        solution.setMins(mins);
        solution.setMaxs(maxs);
        solution.setIterationsTillOptimum(tillOp);
        return solution;
    }

    private Double[] getNumbers(ArrayList<Chromosome> population) {
        Double[] vals = new Double[population.size()];
        for (int i = 0; i < population.size(); i++) {
            double val = fitnessFunction(population.get(i));
            vals[i] = val;
        }
        return vals;
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
        return new Solution(maxState, maxVal, true);
    }


}
