package org.codeship.twopointers;

import java.util.*;

//Test cases: 69/78 passed
public class BoatsToSavePeople {

	public int numRescueBoats_SelfWSolved(int[] people, int limit) {
		int n = people.length;
		int boats = 0;
		Set<Integer> set = new HashSet<>();
		int i = 0, j = n - 1;
		Arrays.sort(people);
		while (i <= j) {
			if (set.contains(i) && set.contains(j)) {
				i++;
				j--;
				continue;
			} else if (set.contains(i)) {
				i++;
				continue;
			} else if (set.contains(j)) {
				j--;
				continue;
			}
			int sum = people[i] + people[j];
			if ((i == j) || sum <= limit) {
				boats++;
				set.add(i);
				set.add(j);
				i++;
				j = n - 1;
			} else if (sum > limit) {
				j--;
			}
		}
		return boats;
	}

	// TC: O(nlogn)
	// SC: O(logn)
	public int numRescueBoats(int[] people, int limit) {
		int n = people.length;
		int boats = 0;
		int i = 0, j = n - 1;
		Arrays.sort(people);
		while (i <= j) {
			if (people[i] + people[j] <= limit) {
				i++;
				j--;
			} else { // send the heaviest weight people
				j--;
			}
			boats += 1;
		}
		return boats;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
