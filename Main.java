public class Main {
  public static void main(String[] args) {
    // This is just an example
    City Maxtopia = new City("Maxtopia");
    Maxtopia.createRoad(50, 50, 200, 200);
    Maxtopia.createRoad(150, 100, 900, 900);
    System.out.println(Maxtopia.getMin()[0] + " " + Maxtopia.getMin()[1]);
    System.out.println(Maxtopia.getMax()[0] + " " + Maxtopia.getMax()[1]);
    Maxtopia.draw();
  }
}
