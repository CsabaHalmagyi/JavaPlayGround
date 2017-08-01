package com.horizonshards.rubicscubesolver.search;

import java.util.LinkedList;

import com.horizonshards.rubicscubesolver.phasespace.Node;

public abstract class GraphTreeSearch extends Search {

    protected LinkedList<Node> open, closed;

    {
        open = new LinkedList<Node>();
        closed = new LinkedList<Node>();
    }

    protected GraphTreeSearch() {
    }

    protected GraphTreeSearch(int attributes) {
        super(attributes);
    }

    @Override
    public String toString() {
        return "Searching with GraphTreeSearch.\n" + properties();
    }
}
