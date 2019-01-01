package LocalSearchs;

import LocalSearchs.LocalSearchAlgorithms.GeneticAlgorithm.Chromosome;

import java.util.ArrayList;
import java.util.Random;

public class MapColoringProblem extends Problem {

    public MapColoringProblem(int numberOfColors) {
        super(numberOfColors);
        nodes = new ArrayList<>();
        GraphNode azerbaijanSharghi = new GraphNode("azarbaijansharghi", 0);
        nodes.add(azerbaijanSharghi);
        GraphNode ardabil = new GraphNode("ardabil", 1);
        nodes.add(ardabil);
        GraphNode azarGharbi = new GraphNode("azarGharbi", 2);
        nodes.add(azarGharbi);
        GraphNode gilan = new GraphNode("gilan", 3);
        nodes.add(gilan);
        GraphNode zanjan = new GraphNode("zanjan", 4);
        nodes.add(zanjan);
        GraphNode kurdistan = new GraphNode("kurdistan", 5);
        nodes.add(kurdistan);
        GraphNode hamadan = new GraphNode("hamadan", 6);
        nodes.add(hamadan);
        GraphNode qazvin = new GraphNode("qazvin", 7);
        nodes.add(qazvin);
        GraphNode kermanshah = new GraphNode("kermanshah", 8);
        nodes.add(kermanshah);
        GraphNode alborz = new GraphNode("alborz", 9);
        nodes.add(alborz);
        GraphNode mazandaran = new GraphNode("mazandaran", 10);
        nodes.add(mazandaran);
        GraphNode tehran = new GraphNode("tehran", 11);
        nodes.add(tehran);
        GraphNode markazi = new GraphNode("markazi", 12);
        nodes.add(markazi);
        GraphNode lorestan = new GraphNode("lorestan", 13);
        nodes.add(lorestan);
        GraphNode ilam = new GraphNode("ilam", 14);
        nodes.add(ilam);
        GraphNode qom = new GraphNode("qom", 15);
        nodes.add(qom);
        GraphNode golestan = new GraphNode("golestan", 16);
        nodes.add(golestan);
        GraphNode isfahan = new GraphNode("isfahan", 17);
        nodes.add(isfahan);
        GraphNode khuzestan = new GraphNode("khuzestan", 18);
        nodes.add(khuzestan);
        GraphNode charmahal = new GraphNode("charmahaml", 19);
        nodes.add(charmahal);
        GraphNode kohkilo = new GraphNode("kohkilo", 20);
        nodes.add(kohkilo);
        GraphNode fars = new GraphNode("fars", 21);
        nodes.add(fars);
        GraphNode yazd = new GraphNode("yazd", 22);
        nodes.add(yazd);
        GraphNode southKhorasan = new GraphNode("southKhorasan", 23);
        nodes.add(southKhorasan);
        GraphNode northKhorasan = new GraphNode("northKhorasan", 24);
        nodes.add(northKhorasan);
        GraphNode razavi = new GraphNode("razavi", 25);
        nodes.add(razavi);
        GraphNode kerman = new GraphNode("kerman", 26);
        nodes.add(kerman);
        GraphNode hormozgan = new GraphNode("hormozgan", 27);
        nodes.add(hormozgan);
        GraphNode bushehr = new GraphNode("bushehr", 28);
        nodes.add(bushehr);
        GraphNode sistan = new GraphNode("sistan", 29);
        nodes.add(sistan);
        GraphNode semnan = new GraphNode("semnan", 30);
        nodes.add(semnan);

        azarGharbi.addAdjNode(azerbaijanSharghi, zanjan, kurdistan);
        azerbaijanSharghi.addAdjNode(alborz, azarGharbi, zanjan);
        gilan.addAdjNode(ardabil, mazandaran, zanjan, qazvin);
        mazandaran.addAdjNode(gilan, golestan, alborz, tehran, semnan);
        golestan.addAdjNode(mazandaran, northKhorasan, semnan);
        razavi.addAdjNode(semnan, northKhorasan, southKhorasan);
        semnan.addAdjNode(razavi, northKhorasan, golestan, mazandaran, tehran, qom, isfahan, southKhorasan);
        tehran.addAdjNode(qom, semnan, mazandaran, alborz, markazi);
        alborz.addAdjNode(tehran, qazvin, mazandaran, markazi);
        zanjan.addAdjNode(qazvin, gilan, hamadan, kurdistan, azerbaijanSharghi, ardabil);
        kurdistan.addAdjNode(azarGharbi, zanjan, hamadan, kermanshah);
        hamadan.addAdjNode(kurdistan, qazvin, markazi, zanjan, lorestan, kermanshah);
        markazi.addAdjNode(hamadan, qom, qazvin, alborz, tehran, lorestan, isfahan);
        qom.addAdjNode(markazi, isfahan, semnan, tehran, alborz, qazvin, hamadan);
        isfahan.addAdjNode(markazi, qom, semnan, southKhorasan, yazd, fars, charmahal, lorestan);
        southKhorasan.addAdjNode(semnan, razavi, sistan, kerman, yazd, isfahan);
        yazd.addAdjNode(isfahan, southKhorasan, kerman, fars);
        charmahal.addAdjNode(lorestan, isfahan, kohkilo, khuzestan);
        lorestan.addAdjNode(ilam, kermanshah, hamadan, markazi, isfahan, charmahal, khuzestan);
        ilam.addAdjNode(kermanshah, lorestan, khuzestan);
        khuzestan.addAdjNode(ilam, lorestan, charmahal, kohkilo, bushehr);
        kohkilo.addAdjNode(khuzestan, charmahal, isfahan, fars, bushehr);
        fars.addAdjNode(kohkilo, isfahan, yazd, kerman, hormozgan, bushehr);
        kermanshah.addAdjNode(kurdistan, hamadan, lorestan, ilam);
        kerman.addAdjNode(fars, yazd, southKhorasan, sistan, hormozgan);
        sistan.addAdjNode(southKhorasan, kerman, hormozgan);
        hormozgan.addAdjNode(kerman, sistan, fars);
        bushehr.addAdjNode(khuzestan, kohkilo, fars, hormozgan);

        initToRandom();


    }

    @Override
    public void initToRandom() {
        int[] init = new int[nodes.size()];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < init.length; i++) {
            init[i] = random.nextInt(numberOfColors);
        }
        initialState = new State(init);
    }


}
