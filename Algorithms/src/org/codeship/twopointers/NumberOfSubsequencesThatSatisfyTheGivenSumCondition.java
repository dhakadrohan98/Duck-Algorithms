package org.codeship.twopointers;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
	
	//TC: O(n*logn)
	//SC: O(n) + O(logn)
	public static int numSubseq(int[] nums, int target) {
		Arrays.sort(nums);
        int n = nums.length;
        //preCompute the powers to save the time for 10^5 times to calculate the powers of 2 as 2^(r-l)
        int[] powers = new int[n+1];
        long mod = (long) (1e9 + 7);
        int totalSub = 0;
        powers[0] = 1;
        for(int i = 1; i <= n; i++) {
            powers[i] = (int) ((powers[i-1] * 2) % mod);
        }
        
        int l = 0, r = n-1;
        while(l <= r) {
        	int sum = nums[l] + nums[r];
        	if(sum <= target) {
        		totalSub = totalSub + powers[r-l];
        		totalSub %= mod;
        		l++;
        	} else {
        		r--;
        	}
        }
        return totalSub;
        
    }
	
	public static void main(String[] args) {
		int[] nums = {3,5,6,7};
		int target = 9;
		
		int[] nums2 = {2,3,3,4,6,7};
		int target2 = 12;
		
		System.out.println(numSubseq(nums2, target2));

	}

}
