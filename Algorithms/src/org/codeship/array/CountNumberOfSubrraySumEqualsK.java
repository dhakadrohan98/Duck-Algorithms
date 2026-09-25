package org.codeship.array;

import java.util.*;

public class CountNumberOfSubrraySumEqualsK {
	
	//TC: O(n)
    //SC: O(n)
	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		Map<Integer, Integer> hmap = new HashMap<>();
		int prefixSum = 0;
		int count = 0;
		hmap.put(0, 1);
		
		for(int i = 0; i < n; i++) {
			prefixSum += nums[i];
			int diffSum = prefixSum - k;
			if(hmap.containsKey(diffSum)) {
				count += hmap.get(diffSum);
			}
			hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
