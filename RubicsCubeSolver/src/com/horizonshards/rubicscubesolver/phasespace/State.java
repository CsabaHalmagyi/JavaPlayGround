package com.horizonshards.rubicscubesolver.phasespace;

import com.horizonshards.rubicscubesolver.operators.RotateCube;

import java.util.Collection;

public abstract class State {

        public String[] state;
        protected static Collection<RotateCube> operators;

        public static Collection<RotateCube> getOperators(){
            return operators;
        }

    public abstract boolean goalState();
    public abstract boolean condition(RotateCube op );
    public abstract State apply( Operator op );
}
