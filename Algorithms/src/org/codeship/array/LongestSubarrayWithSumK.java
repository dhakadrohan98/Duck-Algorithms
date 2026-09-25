package org.codeship.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

	// TC: O(n)
	// SC: O(n)
	public static int longestSubarray(int[] arr, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		int n = arr.length;
		int prefixSum = 0;
		int longest = 0;
		hmap.put(0, -1);

		for (int i = 0; i < n; i++) {
			prefixSum += arr[i];
			
			if (hmap.containsKey(prefixSum - k)) {
				longest = Math.max(longest, i - hmap.get(prefixSum - k));
			}
			//put the first prefixSum with its index because we can loose first prefixSum with its index if we 
			//put the current prefixSum into the map
			if (!hmap.containsKey(prefixSum)) {
				hmap.put(prefixSum, i);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, -2, 5, -3, 1, 2, 6, -4, 3, 1, 5 };
		int k = 7;
		int longestSubarray = longestSubarray(arr, k);
		System.out.println(longestSubarray);

	}

}
