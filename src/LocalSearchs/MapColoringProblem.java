package LocalSearchs;

import LocalSearchs.LocalSearchAlgorithms.GeneticAlgorithm.Chromosome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MapColoringProblem extends Problem {
    private ArrayList<City> cities;
    private State initialState;

    private static class City {
        private String name;

        public City(String name) {
            this.name = name;
            hamsye = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public ArrayList<City> getHamsye() {
            return hamsye;
        }

        public void addHamsaye(City... cities) {
            hamsye.addAll(Arrays.asList(cities));
        }

        private ArrayList<City> hamsye;
    }

    public MapColoringProblem() {
        cities = new ArrayList<>();
        City azerbaijanSharghi = new City("azarbaijansharghi");
        cities.add(azerbaijanSharghi);
        City ardabil = new City("ardabil");
        cities.add(ardabil);
        City azarGharbi = new City("azarGharbi");
        cities.add(azarGharbi);
        City gilan = new City("gilan");
        cities.add(gilan);
        City zanjan = new City("zanjan");
        cities.add(zanjan);
        City kurdistan = new City("kurdistan");
        cities.add(kurdistan);
        City hamadan = new City("hamadan");
        cities.add(hamadan);
        City qazvin = new City("qazvin");
        cities.add(qazvin);
        City kermanshah = new City("kermanshah");
        cities.add(kermanshah);
        City alborz = new City("alborz");
        cities.add(alborz);
        City mazandaran = new City("mazandaran");
        cities.add(mazandaran);
        City tehran = new City("tehran");
        cities.add(tehran);
        City markazi = new City("markazi");
        cities.add(markazi);
        City lorestan = new City("lorestan");
        cities.add(lorestan);
        City ilam = new City("ilam");
        cities.add(ilam);
        City qom = new City("qom");
        cities.add(qom);
        City golestan = new City("golestan");
        cities.add(golestan);
        City isfahan = new City("isfahan");
        cities.add(isfahan);
        City khuzestan = new City("khuzestan");
        cities.add(khuzestan);
        City charmahal = new City("charmahaml");
        cities.add(charmahal);
        City kohkilo = new City("kohkilo");
        cities.add(kohkilo);
        City fars = new City("fars");
        cities.add(fars);
        City yazd = new City("yazd");
        cities.add(yazd);
        City southKhorasan = new City("southKhorasan");
        cities.add(southKhorasan);
        City northKhorasan = new City("northKhorasan");
        cities.add(northKhorasan);
        City razavi = new City("razavi");
        cities.add(razavi);
        City kerman = new City("kerman");
        cities.add(kerman);
        City hormozgan = new City("hormozgan");
        cities.add(hormozgan);
        City bushehr = new City("bushehr");
        cities.add(bushehr);
        City sistan = new City("sistan");
        cities.add(sistan);
        City semnan = new City("semnan");
        cities.add(semnan);

        azarGharbi.addHamsaye(azerbaijanSharghi, zanjan, kurdistan);
        azerbaijanSharghi.addHamsaye(alborz, azarGharbi, zanjan);
        gilan.addHamsaye(ardabil, mazandaran, zanjan, qazvin);
        mazandaran.addHamsaye(gilan, golestan, alborz, tehran, semnan);
        golestan.addHamsaye(mazandaran, northKhorasan, semnan);
        razavi.addHamsaye(semnan, northKhorasan, southKhorasan);
        semnan.addHamsaye(razavi, northKhorasan, golestan, mazandaran, tehran, qom, isfahan, southKhorasan);
        tehran.addHamsaye(qom, semnan, mazandaran, alborz, markazi);
        alborz.addHamsaye(tehran, qazvin, mazandaran, markazi);
        zanjan.addHamsaye(qazvin, gilan, hamadan, kurdistan, azerbaijanSharghi, ardabil);
        kurdistan.addHamsaye(azarGharbi, zanjan, hamadan, kermanshah);
        hamadan.addHamsaye(kurdistan, qazvin, markazi, zanjan, lorestan, kermanshah);
        markazi.addHamsaye(hamadan, qom, qazvin, alborz, tehran, lorestan, isfahan);
        qom.addHamsaye(markazi, isfahan, semnan, tehran, alborz, qazvin, hamadan);
        isfahan.addHamsaye(markazi, qom, semnan, southKhorasan, yazd, fars, charmahal, lorestan);
        southKhorasan.addHamsaye(semnan, razavi, sistan, kerman, yazd, isfahan);
        yazd.addHamsaye(isfahan, southKhorasan, kerman, fars);
        charmahal.addHamsaye(lorestan, isfahan, kohkilo, khuzestan);
        lorestan.addHamsaye(ilam, kermanshah, hamadan, markazi, isfahan, charmahal, khuzestan);
        ilam.addHamsaye(kermanshah, lorestan, khuzestan);
        khuzestan.addHamsaye(ilam, lorestan, charmahal, kohkilo, bushehr);
        kohkilo.addHamsaye(khuzestan, charmahal, isfahan, fars, bushehr);
        fars.addHamsaye(kohkilo, isfahan, yazd, kerman, hormozgan, bushehr);
        kermanshah.addHamsaye(kurdistan, hamadan, lorestan, ilam);
        kerman.addHamsaye(fars, yazd, southKhorasan, sistan, hormozgan);
        sistan.addHamsaye(southKhorasan, kerman, hormozgan);
        hormozgan.addHamsaye(kerman, sistan, fars);
        bushehr.addHamsaye(khuzestan, kohkilo, fars, hormozgan);


        int[] init = new int[cities.size()];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < init.length; i++) {
            init[i] = random.nextInt(4);
        }
        initialState = new State(init);

    }

    public ArrayList<City> getCities() {
        return cities;
    }

    @Override
    public State getInitialState() {
        return initialState;
    }

    @Override
    public ArrayList<State> getNeighbors(State state) {
        ArrayList<State> neightbors = new ArrayList<>();
        for (int i = 0; i < state.getColors().length; i++) {
            for (int j = 0; j < state.getColors().length; j++) {
                for (int i1 = 1; i1 < 4; i1++) {
                    int[] newColors = state.getColors().clone();
                    newColors[j] += i1;
                    newColors[j] = newColors[j] % 4;
                    State s = new State(newColors);
                    neightbors.add(s);
                }

            }
        }
        return neightbors;
    }

    @Override
    public double stateValue(State state) {

        double val = 0;
        int[] cols = state.getColors();
        boolean flag = state instanceof Chromosome;
        double m = 0;
        for (int i = 0; i < cities.size(); i++) {
            ArrayList<City> neighbors = cities.get(i).getHamsye();
            for (int i1 = 0; i1 < neighbors.size(); i1++) {
                m++;
                if (flag) {
                    Chromosome chromosome = (Chromosome) state;
                    if (chromosome.getGens().charAt(i) != chromosome.getGens().charAt(i1)) {
                        val++;
                    }
                } else {

                    if (cols[i] != cols[i1]) {
                        val++;
                    }
                }

            }
        }
        return val / m ;
    }
}
