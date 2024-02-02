package src;//dfgg

import java.util.ArrayList;
import java.util.List;

public class TSP {
	private List<City> cities;

	public TSP(List<City> cities) {
		this.cities = new ArrayList<>(cities);
	}

	public static List<City> nearestNeighborTSP(List<City> cities) {
		int numCities = cities.size();
		boolean[] visited = new boolean[numCities];
		List<City> tour = new ArrayList<>();

		City currentCity = cities.get(0); // Start from the first city
		visited[0] = true;

		// your algorithm here

		tour.add(currentCity);
		double totalDistance = 0.0;

		for (int i = 1; i < numCities; i++) {

			int nearestCityIndex = numCities - 1;
			double minDistance = Double.MAX_VALUE;

			for (int j = 0; j < numCities; j++) {
				if (!visited[j]) {
					double distance = currentCity.distanceTo(cities.get(j));

					if (distance < minDistance) {
						minDistance = distance;
						nearestCityIndex = j;
					}

				}
			}
			totalDistance += currentCity.distanceTo(cities.get(nearestCityIndex));
			currentCity = cities.get(nearestCityIndex);
			visited[nearestCityIndex] = true;
			tour.add(currentCity);

		}
		tour.add(tour.get(0));
		totalDistance += currentCity.distanceTo(tour.get(0));
		System.out.println("Total Distance of the Tour: " + totalDistance);

		return tour;
	}

	public List<City> nearestNeighborTSP() {
		return nearestNeighborTSP(this.cities);
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// Use CSVParser to obtain the list of cities from the CSV file
		String fileName = "ceren_beyda_cities.csv"; // Provide the correct path to your CSV file

		List<City> cities = CSVParser.parseCities(fileName);
		List<City> selectedCities = cities.subList(0, Math.min(20, cities.size()));
		TSP tsp = new TSP(selectedCities);
		//

		List<City> optimalRoute = tsp.nearestNeighborTSP();
		for (City city : optimalRoute) {
			System.out.println(city);
		}

		long endTime = System.currentTimeMillis();

		long executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " milliseconds");

	}
}
