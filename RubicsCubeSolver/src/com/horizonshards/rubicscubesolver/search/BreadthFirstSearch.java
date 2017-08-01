package com.horizonshards.rubicscubesolver.search;


import com.horizonshards.rubicscubesolver.operators.RotateCube;
import com.horizonshards.rubicscubesolver.phasespace.Node;
import com.horizonshards.rubicscubesolver.phasespace.State;


public class BreadthFirstSearch extends GraphTreeSearch {

    public BreadthFirstSearch(State kezdoAllapot) {
        open.add(new Node(kezdoAllapot));
    }

    public BreadthFirstSearch(State kezdoAllapot, int attributes) {
        super(attributes);
        open.add(new Node(kezdoAllapot));
    }

    @Override
    public void search() {
        while (true) {
            System.out.print("Open: " + open.size() + ", closed: " + closed.size());
            if (open.isEmpty()) {
                System.out.println();
                break;
            }
            Node aktualis = open.getFirst();
            System.out.println(", depth: " + aktualis.getDepth());
            if (aktualis.getState().goalState()) {
                terminals.add(aktualis);
                if (allSolutions) {
                    System.out.println("Found a solution.");
                    closed.add(open.removeFirst());
                    continue;
                } else {
                    break;
                }
            }
            for (RotateCube op : State.getOperators()) {
                if (aktualis.getState().condition(op)) {
                    Node uj = new Node(aktualis, op);
                    if (!open.contains(uj) && !closed.contains(uj)) {
                        open.addLast(uj);
                    }
                }
            }
            closed.add(open.removeFirst());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Searching with BFS." + System.getProperty("line.separator") + properties();
    }
}
