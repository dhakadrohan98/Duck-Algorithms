package org.codeship.twopointers;

import java.util.Arrays;

public class ValidTraingleNumber {

	// TC: O(n^2)
	// SC: O(1)
	public static int triangleNumber(int[] nums) {
		int n = nums.length;
		int count = 0;
		Arrays.sort(nums);
		for (int i = 2; i < n; i++) {
			int l = 0;
			int r = i - 1;
			while (l < r) {
				int sumOfTwoSides = nums[l] + nums[r];
				if (sumOfTwoSides > nums[i]) {
					count += (r - l);
					// need to decrement right pointer because there can be a chance if duplicate
					// numbers are present at (r & i)th pointer
					r--;
				} else {
					l++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
