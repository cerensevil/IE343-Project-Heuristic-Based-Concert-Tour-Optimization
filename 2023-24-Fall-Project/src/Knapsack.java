package src; //fvhj

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knapsack {

	public static List<Song> parseSongs(String csvFile) {
		List<Song> songs = new ArrayList<>();
		String line;
		String csvSplitBy = ",";
		boolean skipHeader = true;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				if (skipHeader) {
					skipHeader = false;
					continue;
				}
				String[] data = line.split(csvSplitBy);
				double popularity = Double.parseDouble(data[1]);
				double duration = Double.parseDouble(data[2]);
				songs.add(new Song(popularity, duration));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return songs;
	}

	public static void findSelectedSongs(double[][] v, double[] weights, double capacity, List<Song> selectedSongs) {

		int n = weights.length;

		while (n > 0 && capacity > 0) {
			if (v[n][(int) capacity] != v[n - 1][(int) capacity]) {
				selectedSongs.add(new Song(v[n][(int) capacity] - v[n - 1][(int) capacity], weights[n - 1]));
				capacity -= weights[n - 1];
			}
			n--;
		}
	}

	// popularity-value
	// duration-weight
	public static double knapsack(double[] weights, double[] values, double capacity, List<Song> selectedSongs) {
		int n = weights.length;
		double[][] v = new double[n + 1][(int) (capacity + 1)];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= capacity; w++) {
				if (i == 0 || w == 0) {
					v[i][w] = 0;
				} else if (weights[i - 1] <= w) {
					v[i][w] = (int) Math.max(values[i - 1] + v[i - 1][(int) (w - weights[i - 1])], v[i - 1][w]);
				} else {
					v[i][w] = v[i - 1][w];
				}
			}
		}

		System.out.println("\nConcert Duration = " + capacity);
		findSelectedSongs(v, weights, capacity, selectedSongs);

		for (Song song : selectedSongs) {
			for (int i = 0; i < n; i++) {
				if (song.duration == weights[i]) {
					song.popularity = values[i];
				}
			}
		}

		System.out.println("Selected songs:");
		double totalWeigth = 0.0;
		double totalPopularity = 0.0;
		for (Song song : selectedSongs) {
			System.out.println("Duration(weight): " + song.duration + ", Value(polularity): " + song.popularity);
			totalWeigth += song.duration;
			totalPopularity += song.popularity;
		}
		System.out.println("Total weight  =  + " + totalWeigth + ", Total popularity = " + totalPopularity);

		return v[n][(int) capacity];
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<Song> songs = parseSongs("songs_data.csv");
		String fileName = "ceren_beyda_cities.csv";
		List<City> cities = CSVParser.parseCities(fileName);
		Map<City, List<Song>> result = new HashMap<>();
		//
		// Polularity = value, Duration = weight

		double[] weights = new double[songs.size()];
		double[] values = new double[songs.size()];

		int i = 0;

		for (Song song : songs) {
			weights[i] = song.duration;
			values[i] = song.popularity;
			i++;
		}

		double totalPopularity = 0.0;

		for (City city : cities) {
			List<Song> selectedSongs = new ArrayList<Song>();
			double knapsackValue = knapsack(weights, values, city.getConcertDuration(), selectedSongs);
			city.setKnapsackValue(knapsackValue);
			result.put(city, selectedSongs);
			totalPopularity += knapsackValue;
		}

		System.out.println("\nTotal popularity = " + totalPopularity);

		long endTime = System.currentTimeMillis();

		long executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " milliseconds");

	}
}
