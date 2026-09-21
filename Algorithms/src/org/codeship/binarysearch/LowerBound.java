package org.codeship.binarysearch;

public class LowerBound {

	//TC: O(logn)
    //SC: O(1)
    private int lowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int indx = n;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] < target) {
                low = mid + 1;
            } else {
                indx = Math.min(indx, mid);
                high = mid - 1;
            }
        }
        return low;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
