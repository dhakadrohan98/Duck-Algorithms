package org.codeship.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _4Sum {

	public static List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n-3; i++) {
        	for(int j = i+1; j < n-2; j++) {
        		int k = j+1;
        		int l = n-1;
        		while(k < l) {
        			int sum = arr[i] + arr[j] + arr[k] + arr[l];
        			if(sum == target) {
        				List<Integer> list = new ArrayList<>();
        				list.add(arr[i]);
        				list.add(arr[j]);
        				list.add(arr[k]);
        				list.add(arr[l]);
        				set.add(list);
        				k++;
        			} else if(sum > target) {
        				l--;
        			} else {
        				k++;
        			}
        		}
        	}
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(fourSum(arr, target));

	}
}












	
	
	
	
	
	
	

