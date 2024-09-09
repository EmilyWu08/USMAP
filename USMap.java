/**
 *	USMap.java
 *	Draw a map of US, showing cities as points and big cities colored.
 *	@author	Emily Wu
 *	@since	9/4/2024
 */
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
	
public class USMap{
	public void main(String[] args) {
	  readCities();
	  setupCanvas();
	  plotCities();
	}

	/** Set up the canvas size and scale */
	public void setupCanvas() {
	StdDraw.setTitle("USMap");
	StdDraw.setCanvasSize(900, 512);
	StdDraw.setXscale(128.0, 65.0);
	StdDraw.setYscale(22.0, 52.0);
	}

	public static void readCities() {
	  try {
		  Scanner cities = new Scanner(new File("cities.txt"));
		  while (cities.hasNextLine()) {
			  String line = cities.nextLine();
			  String[] parts = line.split(" ");
			  double latitude = Double.parseDouble(parts[0]);
			  double longitude = Double.parseDouble(parts[1]);
			  String cityName = parts[2];
			  cities.add(new city(latitude, longitude, cityName));
		  }
	  } catch (Exception e) {
		  System.err.println("ERROR: Cannot read cities");
	  }
	}
	public static void plotCities() {
	  for (int counter=1; counter<=100;counter++) {
		  StdDraw.setPenColor(StdDraw.gray);
		  StdDraw.setPenRadius(0.006);
		  StdDraw.point(cities.getLongitude(), cities.getLatitude());
	  }
	}
}
