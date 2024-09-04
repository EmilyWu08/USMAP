/**
 *	USMap.java
 *	Draw a map of US, showing cities as points and big cities colored.
 *	@author	Emily Wu
 *	@since	9/4/2024
 */


import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import StdDraw;

/** Set up the canvas size and scale */
public void setupCanvas() {
StdDraw.setTitle("USMap");
StdDraw.setCanvasSize(900, 512);
StdDraw.setXscale(128.0, 65.0);
StdDraw.setYscale(22.0, 52.0);
}

public class ReadFile {
  public static void main(String[] args) {
    try {
      File cities = new File("cities.txt");
      Scanner myReader = new Scanner(cities);
      while (myReader.hasNextLine()) {
        
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
  }
}
