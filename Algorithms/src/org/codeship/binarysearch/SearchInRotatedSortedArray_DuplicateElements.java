package org.codeship.binarysearch;

//277 test cases are passed out of 285
public class SearchInRotatedSortedArray_DuplicateElements {

	// TC: O(logn)
	// SC: O(1)
    public boolean search(int[] arr, int target) {
        // code here
        int n = arr.length;
        boolean ans = false;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == target) {
                ans = true;
                break;
            }

            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                //shrink the search space
                low += 1;
                high -= 1;
                continue;   
            } 

            if(arr[low] <= arr[mid]) { //left half is sorted
                if(arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(arr[mid] <= arr[high]) {
                if(arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
    
    //TC: O(logn)
    //SC: O(1)
	public boolean search_277_285_TestCases(int[] arr, int target) {
		// code here
		int n = arr.length;
		boolean ans = false;	
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				return true;
			}
			if (arr[low] <= arr[mid]) { // left half is sorted
				if (arr[low] <= target && target < arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (arr[mid] <= arr[high]) {
				if (arr[mid] < target && target <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
