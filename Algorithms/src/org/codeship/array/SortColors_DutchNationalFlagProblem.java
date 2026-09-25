package org.codeship.array;

public class SortColors_DutchNationalFlagProblem {

	// TC: O(n)
	// SC: O(1)
	public void sortColors(int[] nums) {
		int n = nums.length;
		int start = 0;
		int mid = 0;
		int end = n - 1;

		while (start <= mid && mid <= end) {
			if (nums[mid] == 0) {
				swap(nums, start, mid);
				start += 1;
				mid += 1;
			} else if (nums[mid] == 1) {
				// no swapping
				mid += 1;
			} else if (nums[mid] == 2) {
				swap(nums, mid, end);
				end -= 1;
			}
		}
		return;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
