package com.horizonshards.rubicscubesolver.operators;

import com.horizonshards.rubicscubesolver.phasespace.Operator;

public class RotateCube extends Operator{

    public String side;
    public String direction;

    public RotateCube(String side, String direction) {
        this.side = side;
        this.direction = direction;
    }

    /*

    @Override
    public State useOperator(State c){
        Cube a = (Cube)c;

        a.state[0]=c.state[9];
        a.state[1]=c.state[10];
        a.state[2]=c.state[11];

        a.state[9]=c.state[18];
        a.state[10]=c.state[19];
        a.state[11]=c.state[20];

        a.state[18]=c.state[27];
        a.state[19]=c.state[28];
        a.state[20]=c.state[29];

        a.state[27]=c.state[0];
        a.state[28]=c.state[1];
        a.state[29]=c.state[2];

        //rotate top
        a.state[36] = c.state[42];
        a.state[37] = c.state[39];
        a.state[38] = c.state[36];
        a.state[39] = c.state[43];
        a.state[41] = c.state[37];
        a.state[42] = c.state[44];
        a.state[43] = c.state[41];
        a.state[44] = c.state[38];


        return a;
    }

    */
}
