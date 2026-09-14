package org.codeship.twopointers;

import java.util.Arrays;

public class _3SumClosest {
	
	//TC: O(n^2)
    //SC: O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = 0;
        int prevDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n-2; i++) {
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int absDiff = Math.abs(target - sum);
                if(absDiff < prevDiff) {
                    prevDiff = absDiff;
                    closestSum = sum;
                }
                if(sum < target) {
                    j++;
                } else if(sum > target) {
                    k--;
                } else { //sum == target
                    return sum;
                }
            }
        }
        return closestSum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
