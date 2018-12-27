package ClassicalSearch.Problems;

import ClassicalSearch.ProblemSolving.Action;
import ClassicalSearch.ProblemSolving.Problem;
import ClassicalSearch.ProblemSolving.State;

import java.util.ArrayList;

public class Problem1 extends Problem {
    private State initialState;
    private ArrayList<State> states = new ArrayList<>();

    @Override
    public State getInitialState() {
        return initialState;
    }

    public Problem1() {
        State arad = new State("Arad", 0, 366);
        initialState = arad;
        finalStates = new ArrayList<>();
        states.add(initialState);
        State zerind = new State("Zerind", 1, 374);
        states.add(zerind);
        State oradea = new State("Oradea", 2, 380);
        states.add(oradea);
        State timisoara = new State("Timisoara", 3, 329);
        states.add(timisoara);
        State sibiu = new State("Sibiu", 4, 253);
        states.add(sibiu);
        State lugoj = new State("Lugoj", 5, 244);
        states.add(lugoj);
        State mehadia = new State("Mehadia", 6, 241);
        states.add(mehadia);
        State doberta = new State("Doberta", 7, 242);
        states.add(doberta);
        State fagaras = new State("Fagaras", 8, 178);
        states.add(fagaras);
        State riminciuVilcea = new State("Riminciu Vilcea", 9, 193);
        states.add(riminciuVilcea);
        State pitesti = new State("Pitesti", 10, 98);
        states.add(pitesti);
        State craiova = new State("Craiova", 11, 160);
        states.add(craiova);
        State bucharest = new State("Bucharest", 12, 0);
        states.add(bucharest);
        finalStates.add(bucharest);
        State giurgiu = new State("Giurgiu", 13, 77);
        states.add(giurgiu);
        State urziceni = new State("Urziceni", 14, 80);
        states.add(urziceni);
        State hirsova = new State("Hirsova", 15, 151);
        states.add(hirsova);
        State eforie = new State("Eforie", 16, 161);
        states.add(eforie);
        State vaslui = new State("Vaslui", 17, 199);
        states.add(vaslui);
        State lasi = new State("lasi", 18, 226);
        states.add(lasi);
        State neamt = new State("Neamt", 19, 234);
        states.add(neamt);
        arad.addAction(new Action(75, zerind));
        arad.addAction(new Action(140, sibiu));
        arad.addAction(new Action(118, timisoara));


        zerind.addAction(new Action(75, arad));
        zerind.addAction(new Action(71, oradea));


        oradea.addAction(new Action(71, zerind));
        oradea.addAction(new Action(151, sibiu));


        timisoara.addAction(new Action(118, arad));
        timisoara.addAction(new Action(111, lugoj));


        lugoj.addAction(new Action(70, mehadia));
        lugoj.addAction(new Action(111, timisoara));


        mehadia.addAction(new Action(70, lugoj));
        mehadia.addAction(new Action(75, doberta));


        doberta.addAction(new Action(75, mehadia));
        doberta.addAction(new Action(120, craiova));


        craiova.addAction(new Action(120, doberta));
        craiova.addAction(new Action(146, riminciuVilcea));
        craiova.addAction(new Action(138, pitesti));


        sibiu.addAction(new Action(75, riminciuVilcea));
        sibiu.addAction(new Action(140, arad));
        sibiu.addAction(new Action(151, oradea));
        sibiu.addAction(new Action(99, fagaras));


        riminciuVilcea.addAction(new Action(97, pitesti));
        riminciuVilcea.addAction(new Action(146, craiova));
        riminciuVilcea.addAction(new Action(80, sibiu));


        fagaras.addAction(new Action(99, sibiu));
        fagaras.addAction(new Action(211, bucharest));


        bucharest.addAction(new Action(211, fagaras));
        bucharest.addAction(new Action(101, pitesti));
        bucharest.addAction(new Action(90, giurgiu));
        bucharest.addAction(new Action(85, urziceni));


        pitesti.addAction(new Action(101,bucharest));
        pitesti.addAction(new Action(97,riminciuVilcea));
        pitesti.addAction(new Action(138,craiova));


        urziceni.addAction(new Action(85, bucharest));
        urziceni.addAction(new Action(98, hirsova));
        urziceni.addAction(new Action(142, vaslui));

        hirsova.addAction(new Action(98, urziceni));
        hirsova.addAction(new Action(86, eforie));

        vaslui.addAction(new Action(142, urziceni));
        vaslui.addAction(new Action(92, lasi));

        lasi.addAction(new Action(92, vaslui));
        lasi.addAction(new Action(87, neamt));

        neamt.addAction(new Action(87, lasi));


    }

    @Override
    public State transitionModel(State state, Action action) {

        return action.getDestination();
    }

    @Override
    public int getHeuristicValue(State state) {
        return state.getHValue();
    }
}
