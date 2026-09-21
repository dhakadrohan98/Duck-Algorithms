package org.codeship.binarysearch;

public class FindPeakElement {
	
	//TC: O(logn)
    //SC: O(1)
    public int findPeakElement(int[] arr) {
        int n = arr.length;
		//some edge cases
		if(n == 1) {
			return 0;
		}
		//check for 1st element
		if(arr[0] > arr[1]) {
			return 0;
		}
        //check for 2nd element
		if(arr[n-2] < arr[n-1]) {
			return n - 1;
		}
		
        int low = 1;
        int high = n-2;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) {
				return mid;
			}
			
			if(arr[mid-1] < arr[mid]) { //increasing curve
				low = mid + 1;
			} else if(arr[mid-1] >= arr[mid]) {
				high = mid - 1;
			}
		}
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
