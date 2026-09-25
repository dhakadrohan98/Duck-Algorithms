package org.codeship.array;

public class BestTimeToBuySellStock_II {

	// TC: O(n)
	// SC: O(1)
	public int maxProfit(int[] arr) {
		int n = arr.length;
		int totalProfit = 0;
		int buy = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int profit = arr[i] - buy;
			// if profit is +ve then add it to the totalProfit
			if (profit > 0) {
				totalProfit += profit;
			}
			// buy the share at current price after selling it
			buy = arr[i];
		}
		return totalProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
