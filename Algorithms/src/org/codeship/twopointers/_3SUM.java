package org.codeship.twopointers;
import java.util.*;

public class _3SUM {
	
	//TC: O(n^2)
	//SC: O(3 * m) where m is the average length of possible ans
	public static List<List<Integer>> threeSum(int[] arr) {
		
		Arrays.sort(arr);
		Set<List<Integer>> hashSet = new HashSet<>();
		int n = arr.length;
		
		for(int i = 0; i < n-2; i++) {
			int j = i + 1;
			int k = n-1;
			while(j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if(sum == 0) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(arr[i]);
					temp.add(arr[j]);
					temp.add(arr[k]);
					hashSet.add(temp);
					j++;
				} else if(sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		List<List<Integer>> ans = new ArrayList<>(hashSet);
		return ans;
    }

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		int[] arr1 = {0, 1, 1};
		int[] arr2 = {0,0,0};
		System.out.println(threeSum(arr2));
	}

}
