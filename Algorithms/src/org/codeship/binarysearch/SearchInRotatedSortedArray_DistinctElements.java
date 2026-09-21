package org.codeship.binarysearch;

public class SearchInRotatedSortedArray_DistinctElements {
	
	 //TC: O(logn)
    //SC: O(1)
    public int search(int[] arr, int target) {
        // code here
        int n = arr.length;
        int ans = -1;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == target) {
                ans = mid;
                break;
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
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
