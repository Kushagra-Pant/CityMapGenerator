import java.awt.Graphics;
import java.awt.Color;

public class Road {
  private int[] xVals = new int[2];
  private int[] yVals = new int[2];
  private City city;

  public Road(int startingEastCoordinate, int startingNorthCoordinate, int endingEastCoordinate, int endingNorthCoordinate, City parentCity){
    xVals[0] = startingEastCoordinate;
    xVals[1] = endingEastCoordinate;
    yVals[0] = startingNorthCoordinate;
    yVals[1] = endingNorthCoordinate;
    city = parentCity;
  }
  
  public void draw(Graphics g, int frameWidth, int frameHeight) {
    double width = city.getMax()[0] - city.getMin()[0];
    double height = city.getMax()[1] - city.getMin()[1];
    double scale = Math.min(frameWidth/width, frameHeight/height);
    g.setColor(Color.BLACK);

    for(int i = 1; i < xVals.length; i++){
      g.drawLine((int)((xVals[i - 1] - city.getMin()[0])*scale + 0.5),
                 (int)((yVals[i - 1] - city.getMin()[0])*scale + 0.5),
                 (int)((xVals[i] - city.getMin()[0])*scale + 0.5),
                 (int)((yVals[i] - city.getMin()[0])*scale + 0.5));
    }
  }

  public void extendTo(int newEndEastCoordinate, int newEndNorthCoordinate){
    int[] newXVals = new int[xVals.length + 1];
    int[] newYVals = new int[yVals.length + 1];
    for(int i = 0; i < xVals.length; i++){
      newXVals[i] = xVals[i];
      newYVals[i] = yVals[i];
    }
    newXVals[newXVals.length - 1] = newEndEastCoordinate;
    newYVals[newYVals.length - 1] = newEndNorthCoordinate;
    xVals = newXVals;
    yVals = newYVals;
  }

  public void extendBehind(int newStartEastCoordinate, int newStartNorthCoordinate){
    int[] newXVals = new int[xVals.length + 1];
    int[] newYVals = new int[yVals.length + 1];
    for(int i = 1; i < xVals.length; i++){
      newXVals[i] = xVals[i];
      newYVals[i] = yVals[i];
    }
    newXVals[0] = newStartEastCoordinate;
    newYVals[0] = newStartNorthCoordinate;
    xVals = newXVals;
    yVals = newYVals;
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
