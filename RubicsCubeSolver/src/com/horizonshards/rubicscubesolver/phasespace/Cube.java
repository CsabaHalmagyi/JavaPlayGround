package com.horizonshards.rubicscubesolver.phasespace;


import com.horizonshards.rubicscubesolver.operators.RotateCube;

import java.util.Arrays;
import java.util.HashSet;

public class Cube extends State {

    static {
        operators = new HashSet<RotateCube>();

        operators.add(new RotateCube("top","C"));
        //TODO: add missing operators
    }

    public String[] state;

    public Cube() {
    }

    public Cube(String[] state) {
        this.state = state;
    }


    @Override
    public boolean goalState() {
        /*
        String[] goal ={
                "W", "W", "W", "W", "W", "W", "W", "W", "W",
                "B", "B", "B", "B", "B", "B", "B", "B", "B",
                "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y",
                "G", "G", "G", "G", "G", "G", "G", "G", "G",
                "O", "O", "O", "O", "O", "O", "O", "O", "O",
                "R", "R", "R", "R", "R", "R", "R", "R", "R"};
        */
        String[] goal ={
                "W", "W", "W", "W", "W", "W", "W", "W", "W", //FRONT
                "B", "B", "G", "B", "B", "Y", "B", "B", "B", //RIGHT
                "O", "Y", "R", "O", "Y", "Y", "O", "G", "R", //BACK
                "Y", "G", "G", "R", "G", "G", "Y", "G", "G", //LEFT
                "B", "B", "Y", "O", "O", "O", "O", "O", "O", //TOP
                "R", "R", "R", "R", "R", "R", "G", "Y", "Y"}; //BOTTOM


        for(int i=0;i<54;i++){
            if(!goal[i].equals(this.state[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean condition(RotateCube op) {
        return true;
    }

    @Override
    public Cube apply(Operator op) {
        Cube newCube = new Cube(this.state);
        if(op instanceof RotateCube){
            RotateCube rc = (RotateCube)op;

            String rotation = rc.side+rc.direction;
            newCube.rotate(rotation);
        }

        return newCube;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (!Arrays.equals(this.state, cube.state)) return false;
        return true;

    }




    @Override
    public int hashCode() {
        return Arrays.hashCode(state);
    }

    public void printCube(){

        System.out.println("FRONT:");
        for(int i=0;i<=8;i++){
            System.out.print(this.state[i]);
            if((i+1)%3 == 0) System.out.println();
        }

        System.out.println("RIGHT:");
        for(int i=9;i<=17;i++){
            System.out.print(this.state[i]);
            if((i+1)%3 == 0) System.out.println();
        }

        System.out.println("BACK:");
        for(int i=18;i<=26;i++){
            System.out.print(this.state[i]);
            if((i+1)%3 == 0) System.out.println();
        }

        System.out.println("LEFT:");
        for(int i=27;i<=35;i++){
            System.out.print(this.state[i]);
            if((i+1)%3 == 0) System.out.println();
        }

        System.out.println("TOP:");
        for(int i=36;i<=44;i++){
            System.out.print(this.state[i]);
            if((i+1)%3 == 0) System.out.println();
        }

        System.out.println("BOTTOM:");
        for(int i=45;i<=53;i++){
            System.out.print(this.state[i]);
            if((i+1)%3 == 0) System.out.println();
        }



    }


    private void rotate(String d){

        if(d.equals("topC")){
            System.out.println("Rotating topC");
            Cube a = new Cube(this.state);

            a.state[0]=this.state[9];
            a.state[1]=this.state[10];
            a.state[2]=this.state[11];

            a.state[9]=this.state[18];
            a.state[10]=this.state[19];
            a.state[11]=this.state[20];

            a.state[18]=this.state[27];
            a.state[19]=this.state[28];
            a.state[20]=this.state[29];

            a.state[27]=this.state[0];
            a.state[28]=this.state[1];
            a.state[29]=this.state[2];

            //rotate top
            a.state[36] = this.state[42];
            a.state[37] = this.state[39];
            a.state[38] = this.state[36];
            a.state[39] = this.state[43];
            a.state[41] = this.state[37];
            a.state[42] = this.state[44];
            a.state[43] = this.state[41];
            a.state[44] = this.state[38];

            this.state = a.state;

        }

        //TODO: add the rest of the rotations


    }



}
