package com.horizonshards.rubicscubesolver;

import com.horizonshards.rubicscubesolver.phasespace.Cube;
import com.horizonshards.rubicscubesolver.phasespace.Node;
import com.horizonshards.rubicscubesolver.search.*;


public class Main {

    public static void main(String[] args){

        System.out.println("Hello");

        Cube c1 = new Cube(new String[]{
                "O", "Y", "R", "W", "W", "W", "W", "W", "W",
                "Y", "G", "G", "B", "B", "Y", "B", "B", "B",
                "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y",
                "W", "W", "W", "O", "Y", "Y", "O", "G", "R",
                "B", "B", "G", "R", "G", "G", "Y", "G", "G",
                "O", "O", "O", "O", "O", "O", "Y", "B", "B",
                "R", "R", "R", "R", "R", "R", "G", "Y", "Y"}
        );

        Cube c = new Cube(new String[]{
                "O", "Y", "R", "W", "W", "W", "W", "W", "W",
                "Y", "G", "G", "B", "B", "Y", "B", "B", "B",
                "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y", "Y",
                "W", "W", "W", "O", "Y", "Y", "O", "G", "R",
                "B", "B", "G", "R", "G", "G", "Y", "G", "G",
                "O", "O", "O", "O", "O", "O", "Y", "B", "B",
                "R", "R", "R", "R", "R", "R", "G", "Y", "Y"}
        );


        //c.printCube();
        System.out.println("********** ROTATING **********");
        //c.leftC();

        System.out.println("********** RESULT **********");

        c.printCube();

        //solution state:

        BreadthFirstSearch kereso = new BreadthFirstSearch(c);
        System.out.println( kereso );
        kereso.search();
        for ( Node cs: kereso.getTerminals() )
        {
            System.out.println( "\nEgy megoldas:" );
            kereso.printSolution( cs );
        }
        System.out.println( "\nMegoldasok szama: " + kereso.getTerminals().size() );


    }

}

/*

import kereso.*;

        import kereso.keresografos.szisztematikus.SzelessegiKereso;

public class Main
{
//  private static final int KORLAT = 7;

    public static void main( String[] args )
    {

        Kereso kereso = new SzelessegiKereso( new Vidam(), SzelessegiKereso.MEGOLDAS_ALLAPOT | SzelessegiKereso.OSSZES_MEGOLDAS );

        System.out.println( kereso );
        kereso.keres();
        for ( Csucs cs: kereso.getTerminalisok() )
        {
            System.out.println( "\nEgy megoldas:" );
            kereso.kiirMegoldas( cs );
        }
        System.out.println( "\nMegoldasok szama: " + kereso.getTerminalisok().size() );
    }
}

*/