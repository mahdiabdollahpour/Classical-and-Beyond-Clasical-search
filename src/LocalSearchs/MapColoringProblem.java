package LocalSearchs;

import LocalSearchs.LocalSearchAlgorithms.GeneticAlgorithm.Chromosome;

import java.util.ArrayList;
import java.util.Random;

public class MapColoringProblem extends Problem {

    public MapColoringProblem(int numberOfColors) {
        super(numberOfColors);
        nodes = new ArrayList<>();
        GraphNode azerbaijanSharghi = new GraphNode("azarbaijansharghi");
        nodes.add(azerbaijanSharghi);
        GraphNode ardabil = new GraphNode("ardabil");
        nodes.add(ardabil);
        GraphNode azarGharbi = new GraphNode("azarGharbi");
        nodes.add(azarGharbi);
        GraphNode gilan = new GraphNode("gilan");
        nodes.add(gilan);
        GraphNode zanjan = new GraphNode("zanjan");
        nodes.add(zanjan);
        GraphNode kurdistan = new GraphNode("kurdistan");
        nodes.add(kurdistan);
        GraphNode hamadan = new GraphNode("hamadan");
        nodes.add(hamadan);
        GraphNode qazvin = new GraphNode("qazvin");
        nodes.add(qazvin);
        GraphNode kermanshah = new GraphNode("kermanshah");
        nodes.add(kermanshah);
        GraphNode alborz = new GraphNode("alborz");
        nodes.add(alborz);
        GraphNode mazandaran = new GraphNode("mazandaran");
        nodes.add(mazandaran);
        GraphNode tehran = new GraphNode("tehran");
        nodes.add(tehran);
        GraphNode markazi = new GraphNode("markazi");
        nodes.add(markazi);
        GraphNode lorestan = new GraphNode("lorestan");
        nodes.add(lorestan);
        GraphNode ilam = new GraphNode("ilam");
        nodes.add(ilam);
        GraphNode qom = new GraphNode("qom");
        nodes.add(qom);
        GraphNode golestan = new GraphNode("golestan");
        nodes.add(golestan);
        GraphNode isfahan = new GraphNode("isfahan");
        nodes.add(isfahan);
        GraphNode khuzestan = new GraphNode("khuzestan");
        nodes.add(khuzestan);
        GraphNode charmahal = new GraphNode("charmahaml");
        nodes.add(charmahal);
        GraphNode kohkilo = new GraphNode("kohkilo");
        nodes.add(kohkilo);
        GraphNode fars = new GraphNode("fars");
        nodes.add(fars);
        GraphNode yazd = new GraphNode("yazd");
        nodes.add(yazd);
        GraphNode southKhorasan = new GraphNode("southKhorasan");
        nodes.add(southKhorasan);
        GraphNode northKhorasan = new GraphNode("northKhorasan");
        nodes.add(northKhorasan);
        GraphNode razavi = new GraphNode("razavi");
        nodes.add(razavi);
        GraphNode kerman = new GraphNode("kerman");
        nodes.add(kerman);
        GraphNode hormozgan = new GraphNode("hormozgan");
        nodes.add(hormozgan);
        GraphNode bushehr = new GraphNode("bushehr");
        nodes.add(bushehr);
        GraphNode sistan = new GraphNode("sistan");
        nodes.add(sistan);
        GraphNode semnan = new GraphNode("semnan");
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


        int[] init = new int[nodes.size()];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < init.length; i++) {
            init[i] = random.nextInt(numberOfColors);
        }
        initialState = new State(init);

    }

    public ArrayList<GraphNode> getNodes() {
        return nodes;
    }


}
