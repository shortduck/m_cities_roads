package m_cities_roads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CitiesRoads {
	public static void main(String[] args) {

		int T[] = { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };

		CitiesRoads test = new CitiesRoads();
		test.solution(T);

	}

	public void solution(int[] T) {

		// find capital
		// push this capital into queue
		// pop top element and traverse the array, and maintain count
		// push any element with the above value.

		int capital = 0;
		ArrayList<Integer> returnNearCities = new ArrayList<Integer>();

		// get Capital
		for (int i = 0; i < T.length ; i++) {
			if (T[i] == i)
				capital = i;
		}

		int currentCity = capital;
		int count = 0;

		// push the capital to the queue
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(capital);
		queue.add(-999);
		// now traverse the array and find the nearby cities
		while (!queue.isEmpty()) {

			currentCity = queue.remove();

			// reset the counter, because we have traversed all the immediate cities.
			if (currentCity == -999) {
				returnNearCities.add(count);
				count = 0;
				// get next city
				if (!queue.isEmpty())
					currentCity = queue.remove();
			}

			for (int j = 0; j < T.length ; j++) {

				if (T[j] == currentCity && T[j] != j) {
					queue.add(j);
					count++;
				}
			}

			// add -999 to mark the end of the path or the road
			if (count > 0)
				queue.add(-999);

		}

		System.out.println(returnNearCities);
	}

}
