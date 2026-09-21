package org.codeship.binarysearch;

//TC: O(logn)
//SC; O(1)
public class CeilAndFloor_InSortedArray {

	public static int floorSearch(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		int ans = -1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid] == target) {
				ans = arr[mid];
				break;
			} else if(arr[mid] < target) {
				ans = arr[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}
	
	public static int findCeil(int[] arr, int target) {
		int low = 0, high = arr.length - 1;
		int ans = -1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			if(arr[mid] >= target) {
				ans = arr[mid];
				high = mid - 1;
			} 
			else if(arr[mid] < target) {
				high = mid - 1;
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
