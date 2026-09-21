package org.codeship.binarysearch;

public class SearchInsertPosition {
	
	//TC: O(logn)
	//SC: O(1)
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int ans = nums.length;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(nums[mid] < target) {
				low = mid + 1;
			} else if(nums[mid] > target) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return low;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
