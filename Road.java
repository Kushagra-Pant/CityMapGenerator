public class Road {
  private int[] xVals = new int[2];
  private int[] yVals = new int[2];

  public Road(int startingEastCoordinate, int startingNorthCoordinate, int endingEastCoordinate, int endingNorthCoordinate){
    xVals[0] = startingEastCoordinate;
    xVals[1] = endingEastCoordinate;
    yVals[0] = startingNorthCoordinate;
    yVals[1] = endingNorthCoordinate;
  }
  
  /**
   * Returns the minimum coordinate
   */
  public int[] getMin(){
    int[] min = new int[2];
    min[0] = xVals[0];
    min[1] = yVals[0];
    
    for(int i = 1; i < xVals.length; i++){
      if(xVals[i] < min[0])
        min[0] = xVals[i];
      
      if(yVals[i] < min[1])
        min[1] = yVals[i];
    }
    return min;
  }
  
  /**
   * Returns the maximum coordinate
   */
  public int[] getMax(){
    int[] max = new int[2];
    max[0] = xVals[0];
    max[1] = yVals[0];
    
    for(int i = 1; i < xVals.length; i++){
      if(xVals[i] > max[0])
        max[0] = xVals[i];

      if(yVals[i] > max[1])
        max[1] = yVals[i];
    }
    return max;
  }
}
