package org.codeship.binarysearch;

public class SearchIn_2DMatrix {
	// TC: O(log(m*n))
	// SC: O(1)
	public boolean searchMatrix(int[][] mat, int target) {
		int n = mat.length;
		int m = mat[0].length;
		int low = 0;
		int high = (m * n) - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			// calculate 2d indexes from hypothetical 1d array
			int row = mid / m;
			int col = mid % m;

			if (mat[row][col] == target) {
				return true;
			} else if (mat[row][col] < target) {
				low = mid + 1;
			} else { // mat[row][col] > target
				high = mid - 1;
			}
		}

		return false;
	}

	public boolean searchMatrix_NaiveSolution(int[][] mat, int target) {
		int m = mat.length;
		int n = mat[0].length;
		int[] arr = new int[m * n];
		int incr = 0;
		// converting 1d array into 2d array
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[incr++] = mat[i][j];
			}
		}

		// implement binary search on 1d array
		int low = 0, high = arr.length - 1;
		int index = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				index = mid;
				break;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		// element is not found
		if (index == -1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
