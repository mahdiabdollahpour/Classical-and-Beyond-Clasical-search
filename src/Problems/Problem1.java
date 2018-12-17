package Problems;

import ProblemSolving.Action;
import ProblemSolving.Problem;
import ProblemSolving.State;

import java.util.ArrayList;

public class Problem1 extends Problem {
    private State initialState;
    private ArrayList<State> states = new ArrayList<>();

    @Override
    public State getInitialState() {
        return initialState;
    }

    public Problem1() {
        State arad = new State("Arad", 0);
        initialState = arad;
        states.add(initialState);
        State zerind = new State("Zerind", 1);
        states.add(zerind);
        State oradea = new State("Oradea", 2);
        states.add(oradea);
        State timisoara = new State("Timisoara", 3);
        states.add(timisoara);
        State sibiu = new State("Sibiu", 4);
        states.add(sibiu);
        State lugoj = new State("Lugoj", 5);
        states.add(lugoj);
        State mehadia = new State("Mehadia", 6);
        states.add(mehadia);
        State doberta = new State("Doberta", 7);
        states.add(doberta);
        State fagaras = new State("Fagaras", 8);
        states.add(fagaras);
        State riminciuVilcea = new State("Riminciu Vilcea", 9);
        states.add(riminciuVilcea);
        State pitesti = new State("Pitesti", 10);
        states.add(pitesti);
        State craiova = new State("Craiova", 11);
        states.add(craiova);
        State bucharest = new State("Bucharest", 12);
        states.add(bucharest);
        State giurgiu = new State("Giurgiu", 13);
        states.add(giurgiu);
        State urziceni = new State("Urziceni", 14);
        states.add(urziceni);
        State hirsova = new State("Hirsova", 15);
        states.add(hirsova);
        State eforie = new State("Eforie", 16);
        states.add(eforie);
        State vaslui = new State("Vaslui", 17);
        states.add(vaslui);
        State lasi = new State("lasi", 18);
        states.add(lasi);
        State neamt = new State("Neamt", 19);
        states.add(neamt);



    }

    @Override
    public State transitionModel(State state, Action action) {
        return null;
    }

    @Override
    public int getH(State state) {
        return 0;
    }
}
