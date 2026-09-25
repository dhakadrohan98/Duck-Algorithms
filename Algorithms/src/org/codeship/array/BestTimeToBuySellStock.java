package org.codeship.array;

public class BestTimeToBuySellStock {

	// TC: O(n)
	// SC: O(1)
	public int maxProfit(int[] arr) {
		int n = arr.length;
		int maxProfit = 0;
		int buy = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int profit = arr[i] - buy;
			maxProfit = Math.max(maxProfit, profit);
			if (buy > arr[i]) {
				buy = arr[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
