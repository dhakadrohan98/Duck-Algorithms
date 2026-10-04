package org.codeship.string;

public class SumOfBeautyOfAllSubstrings {

	// TC: O(n^2)
	// SC: O(1)
	public int beautySum(String s) {
		int n = s.length();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			// freq arr
			int[] arr = new int[26];
			for (int j = i; j < n; j++) {
				char ch = s.charAt(j);
				arr[ch - 'a']++;

				// iterate through frequency array
				int max = 0;
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < 26; k++) {
					if (arr[k] == 0) {
						continue;
					}
					max = Math.max(max, arr[k]);
					min = Math.min(min, arr[k]);
				}
				sum += (max - min);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
