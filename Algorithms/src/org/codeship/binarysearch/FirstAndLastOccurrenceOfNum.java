package org.codeship.binarysearch;

import java.util.*;

public class FirstAndLastOccurrenceOfNum {
	
	//TC: O(2*logn)
    //SC: O(1)
	public static ArrayList<Integer> find(int arr[], int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int firstOccurIndx = firstOccurence(arr, num);
		int lastOccurIndx = lastOccurence(arr, num);
		list.add(firstOccurIndx);
		list.add(lastOccurIndx);
		return list;
	}
	
	private static int firstOccurence(int[] arr, int num) {
		int low = 0, high = arr.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == num) {
				ans = mid;
				high = mid - 1; // last occurrence
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	private static int lastOccurence(int[] arr, int num) {
		int low = 0, high = arr.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == num) {
				ans = mid;
				low = mid + 1; // last occurrence
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 5, 5, 5, 5, 67, 123, 125};
		int num = 5;
		System.out.println(find(arr, num));

	}

}
