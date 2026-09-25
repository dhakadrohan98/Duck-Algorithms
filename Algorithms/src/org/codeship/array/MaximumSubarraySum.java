package org.codeship.array;

public class MaximumSubarraySum {

	// TC: O(n)
	// SC: O(1)
	// Kadane's algorithm
	public int maxSubArray(int[] arr) {
		int n = arr.length;
		int currSum = 0;
		int maxSum = arr[0];
		for (int i = 0; i < n; i++) {
			currSum += arr[i];
			maxSum = Math.max(maxSum, currSum);
			if (currSum < 0) {
				currSum = 0;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
