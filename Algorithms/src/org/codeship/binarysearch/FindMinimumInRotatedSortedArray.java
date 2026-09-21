package org.codeship.binarysearch;

public class FindMinimumInRotatedSortedArray {

	// TC: O(logn)
	// SC: O(1)
	public int findMin(int[] nums) {
		int n = nums.length;
		int low = 0, high = nums.length - 1;
		int ans = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[low] <= nums[mid]) {
				ans = Math.min(ans, nums[low]);
				// eliminate the left half sorted side after picking up the minimum from it
				low = mid + 1;
			} else if (nums[mid] <= nums[high]) {
				ans = Math.min(ans, nums[mid]);
				// eliminate the right half sorted side after picking up the minimum from it
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
