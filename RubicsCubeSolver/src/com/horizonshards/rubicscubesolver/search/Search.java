package com.horizonshards.rubicscubesolver.search;

import com.horizonshards.rubicscubesolver.phasespace.Node;

import java.util.List;
import java.util.ArrayList;

public abstract class Search
{
  public static final int OSSZES_MEGOLDAS = 1;
  public static final int MEGOLDAS_ALLAPOT = 2;
  protected boolean allSolutions;
  protected boolean goalState;
  protected List<Node> terminals;

  protected Search()
  {
    allSolutions = false;
    goalState = false;
    terminals = new ArrayList<Node>();
  }
  
  protected Search( int attributes )
  {
    this();
    allSolutions = ( attributes & OSSZES_MEGOLDAS ) != 0;
    allSolutions = ( attributes & MEGOLDAS_ALLAPOT ) != 0;
  }
  
  public List<Node> getTerminals()
  {
    return terminals;
  }
  
  public String properties()
  {
    String s = new String();
    if ( allSolutions )
      s += "Looking for all solutions.\n";
    else
      s += "Looking for the first solution.\n";
    if ( goalState )
      s += "Goal is the goalState.\n";
    else
      s += "Goal is the operator sequence.\n";
    return s;
  }
  
  public void printSolution( Node cs )
  {
    if ( goalState )
      System.out.println( cs.getState() );
    else if ( cs != null )
    {
      printSolution( cs.getParent() );
      System.out.println( cs );
    }
  }
  
  public abstract void search();
}
