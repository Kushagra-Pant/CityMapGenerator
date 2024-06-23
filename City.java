import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class City extends JPanel {
  private String name;
  private Road roads[] = new Road[0];
  
  /**
   * Creates a city object
   * @param name - the name of the city
   */
  public City(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }
  
  public void setName(String newName){
    this.name = newName;
  }
  
  public void draw(){
    JFrame frame = new JFrame("Simple Graphics Example");
    CityPanel panel = new CityPanel();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.add(panel);
    frame.setVisible(true);
  }
  
  class CityPanel extends JPanel {
      @Override
      protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          for (int i = 0; i < roads.length; i++) {
              roads[i].draw(g, getWidth(), getHeight());
          }
      }
  }

  public void createRoad(int startingEastCoordinate, int startingNorthCoordinate, int endingEastCoordinate, int endingNorthCoordinate){
    Road[] newRoads = new Road[roads.length + 1];
    for(int i = 0; i < roads.length; i++){
      newRoads[i] = roads[i];
    }
    newRoads[newRoads.length - 1] = new Road(startingEastCoordinate, startingNorthCoordinate, endingEastCoordinate, endingNorthCoordinate, this);
    roads = newRoads;
  }

  public int[] getMin(){
    int[] min = new int[2];
    min[0] = roads[0].getMin()[0];
    min[1] = roads[0].getMin()[1];
    
    for(int i = 1; i < roads.length; i++){
      if(roads[i].getMin()[0] < min[0])
        min[0] = roads[i].getMin()[0];
      
      if(roads[i].getMin()[1] < min[1])
        min[1] = roads[i].getMin()[1];
    }
    return min;
  }

  public int[] getMax(){
    int[] max = new int[2];
    max[0] = roads[0].getMax()[0];
    max[1] = roads[0].getMax()[0];
    
    for(int i = 1; i < roads.length; i++){
      if(roads[i].getMax()[0] > max[0])
        max[0] = roads[i].getMax()[0];
      
      if(roads[i].getMax()[1] > max[1])
        max[1] = roads[i].getMax()[1];
    }
    return max;
  }
}
