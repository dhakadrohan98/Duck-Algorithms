package org.codeship.array;

import java.util.*;

public class LongestConsecutiveSequence {
	
	//TC: O(n)
    //SC: O(n)
	public int longestConsecutive(int[] nums) {
		int n = nums.length;
		Set<Integer> set = new HashSet<>();
		int longestSeq = 0;
		
		for(int num: nums) {
			set.add(num);
		}
		for(int num: set) {
			if(!set.contains(num-1)) {
				int temp = num;
				int cnt = 1;
				while(set.contains(temp+1)) {
					cnt += 1;
					temp += 1;
				}
				longestSeq = Math.max(cnt, longestSeq);
			}
		}
		return longestSeq;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
