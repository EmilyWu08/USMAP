/**
 *	USMap.java
 *	Draw a map of US, showing cities as points and big cities colored.
 *	@author	Emily Wu
 *	@since	9/4/2024
 */


import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;
import edu.princeton.cs.introcs.StdDraw;

/** Set up the canvas size and scale */
public void setupCanvas() {
StdDraw.setTitle("USMap");
StdDraw.setCanvasSize(900, 512);
StdDraw.setXscale(128.0, 65.0);
StdDraw.setYscale(22.0, 52.0);
}

public void main(String[] args) {
  readCities();
  setupCanvas();
  plotCities();
}

public static void readCities() {
  try {
      Scanner cities = new Scanner(new File("cities.txt"));
      while (cities.hasNextLine()) {
          String line = cities.nextLine();
          String[] parts = line.split(" ");
          String cityName = parts[0];
          double latitude = Double.parseDouble(parts[1]);
          double longitude = Double.parseDouble(parts[2]);
          cities.add(new City(cityName, latitude, longitude));
      }
  } catch (Exception e) {
      e.printStackTrace();
  }
}
public static void plotCities() {
  for (City city : cities) {
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.setPenRadius(0.006);
      StdDraw.point(city.getLongitude(), city.getLatitude());
  }
}
public static void readBigCities() {
  try {
      Scanner sc = new Scanner(new File("bigCities.txt"));
      while (sc.hasNextLine()) {
          String line = sc.nextLine();
          String[] parts = line.split(" ");
          String cityName = parts[0];
          int population = Integer.parseInt(parts[1]);

          // Find the city in your city database and update its population
          for (City city : cities) {
              if (city.getName().equals(cityName)) {
                  city.setPopulation(population);
                  break;
              }
          }
      }
  } catch (Exception e) {
      e.printStackTrace();
  }
}
public static void plotBigCities() {
  for (City city : cities) {
      if (city.getPopulation() > 0) {
          double size = 0.6 * (Math.sqrt(city.getPopulation()) / 18500);

          // For the largest 10 cities, use red, otherwise use blue
          if (city.getPopulationRank() <= 10) {
              StdDraw.setPenColor(StdDraw.RED);
          } else {
              StdDraw.setPenColor(StdDraw.BLUE);
          }

          StdDraw.setPenRadius(size);
          StdDraw.point(city.getLongitude(), city.getLatitude());
      }
  }
}
public static class City {
  private String name;
  private double latitude;
  private double longitude;
  private int population;

  public City(String name, double latitude, double longitude) {
      this.name = name;
      this.latitude = latitude;
      this.longitude = longitude;
      this.population = 0; // Default if not a big city
  }

  public String getName() { return name; }
  public double getLatitude() { return latitude; }
  public double getLongitude() { return longitude; }
  public int getPopulation() { return population; }
  public void setPopulation(int population) { this.population = population; }
}
