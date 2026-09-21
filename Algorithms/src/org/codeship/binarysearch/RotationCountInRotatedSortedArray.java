package org.codeship.binarysearch;

public class RotationCountInRotatedSortedArray {
	
	//TC: O(logn)
    //SC; O(1)
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        int minElement = Integer.MAX_VALUE;
        int minIndex = n;
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[mid]) { //left half is sorted
                if(minElement > arr[low]) {
                    minElement = arr[low];
                    minIndex = low;
                }
                low = mid + 1; //elimite the left half search space
            } else if(arr[mid] <= arr[high]) {
                if(minElement > arr[mid]) {
                    minElement = arr[mid];
                    minIndex = mid;
                }
                high = mid - 1;
            }
        }
        return minIndex;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
