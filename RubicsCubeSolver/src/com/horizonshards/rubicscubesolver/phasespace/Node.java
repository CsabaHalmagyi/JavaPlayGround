package com.horizonshards.rubicscubesolver.phasespace;

public class Node {

        protected State state;
        protected Node parent;
        protected Operator operator;
        protected int depth;

        public Node( State startingState )
        {
            state = startingState;
            parent = null;
            operator = null;
            depth = 0;
        }

        public Node( Node parent, Operator operator )
        {
            state = parent.state.apply( operator );
            this.parent = parent;
            this.operator = operator;
            depth = parent.depth + 1;
        }

        public State getState()
        {
            return state;
        }

        public Node getParent()
        {
            return parent;
        }

        public Operator getOperator()
        {
            return operator;
        }

        public int getDepth()
        {
            return depth;
        }

        @Override
        public boolean equals( Object obj )
        {
            if ( obj == null || !( obj instanceof Node ) )
                return false;
            return state.equals( ( ( Node )obj ).state );
        }

        @Override
        public String toString()
        {
            String s = new String();
            if ( operator != null )
                s += operator + " =>" + System.getProperty( "line.separator" );
            s += state + " (" + depth + ")";
            return s;
        }

    }


