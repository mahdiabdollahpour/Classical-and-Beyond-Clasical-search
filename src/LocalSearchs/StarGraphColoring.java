package LocalSearchs;

import java.util.ArrayList;
import java.util.Random;

public class StarGraphColoring extends Problem {
    public StarGraphColoring() {
        super(3);
        GraphNode a1 = new GraphNode("a1");
        GraphNode a2 = new GraphNode("a2");
        GraphNode a3 = new GraphNode("a3");
        GraphNode a4 = new GraphNode("a4");
        GraphNode a5 = new GraphNode("a5");
        GraphNode a6 = new GraphNode("a6");
        GraphNode a7 = new GraphNode("a7");
        GraphNode a8 = new GraphNode("a8");
        GraphNode a9 = new GraphNode("a9");
        GraphNode a10 = new GraphNode("a10");
        GraphNode a11 = new GraphNode("a11");
        nodes = new ArrayList<>();
        nodes.add(a1);
        nodes.add(a2);
        nodes.add(a3);
        nodes.add(a4);
        nodes.add(a5);
        nodes.add(a6);
        nodes.add(a7);
        nodes.add(a8);
        nodes.add(a9);
        nodes.add(a10);
        nodes.add(a11);


        a1.addAdjNode(a2, a3, a9, a10);
        a2.addAdjNode(a1, a5, a4);
        a3.addAdjNode(a1, a4, a6);
        a4.addAdjNode(a2, a3, a7, a11, a8);
        a5.addAdjNode(a2, a8, a6, a10);
        a6.addAdjNode(a3, a7, a5, a9);
        a7.addAdjNode(a6, a10, a4);
        a8.addAdjNode(a5, a4, a9);
        a9.addAdjNode(a8, a11, a6, a1);
        a10.addAdjNode(a7, a11, a1, a5);
        a11.addAdjNode(a9, a10, a4);


        int[] init = new int[nodes.size()];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < init.length; i++) {
            init[i] = random.nextInt(numberOfColors);
        }
        initialState = new State(init);

    }


}
