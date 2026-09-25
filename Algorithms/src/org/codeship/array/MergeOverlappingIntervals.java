package org.codeship.array;

import java.util.*;

public class MergeOverlappingIntervals {
	
	
	public static List<List<Integer>> merge(int[][] arr) {

	    int n = arr.length;

	    if (n <= 1) {
	    	List<List<Integer>> list = new ArrayList<List<Integer>>();
	    	List<Integer> tempList = new ArrayList<>();
	    	tempList.add(arr[0][0]);
	    	tempList.add(arr[1][0]);
	    	list.add(tempList);
	    	return list;
	    }

	    // Sort by start time, then by end time
	    Arrays.sort(arr, (arr1, arr2) -> {
	        if (arr1[0] == arr2[0]) {
	            return Integer.compare(arr1[1], arr2[1]);
	        }
	        return Integer.compare(arr1[0], arr2[0]);
	    });

	    List<List<Integer>> list = new ArrayList<>();

	    int i = 0;

	    while (i < n) {

	        int start = arr[i][0];
	        int end = arr[i][1];

	        int j = i + 1;

	        // Merge all intervals overlapping with current interval
	        while (j < n && end >= arr[j][0]) {
	            end = Math.max(end, arr[j][1]);
	            j++;
	        }

	        List<Integer> tempList = new ArrayList<>();
	        tempList.add(start);
	        tempList.add(end);

	        list.add(tempList);

	        // Start processing from the first unprocessed interval
	        i = j;
	    }

	    // Convert List<List<Integer>> to int[][]
	    int[][] merged = new int[list.size()][2];

	    for (int row = 0; row < list.size(); row++) {
	        merged[row][0] = list.get(row).get(0);
	        merged[row][1] = list.get(row).get(1);
	    }

	    return list;
	}
	
	public static void main(String[] args) {
		int[][] arr1 = {{1,3}, {2,6}, {8,9}, {9,11}, {8,10}, {2,4}, {15,18}, {16,17}};
		int[][] arr2 = {{1,3}, {2,6}, {8, 10}, {15,18}};
		System.out.println(merge(arr1));
		System.out.println(merge(arr2));

	}

}
