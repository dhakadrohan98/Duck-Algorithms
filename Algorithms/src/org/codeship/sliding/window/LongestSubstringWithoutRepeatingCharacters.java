package org.codeship.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	//TC: O(n)
	//SC: O(n)
	public static int longestUniqueSubstr(String s) {
        // code here
		int longest = 0;
		Map<Character, Integer> hmap = new HashMap<>();
		int i = 0, j = 0;
		int len = s.length();
		while(j < len) {
			//calculations
			char ch = s.charAt(j);
			hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
			if(hmap.get(ch) == 1) {
				longest = Math.max(longest, j-i+1);
				j++;
			} else if(hmap.containsKey(ch) && hmap.get(ch) > 1) {
				while(hmap.containsKey(ch) && hmap.get(ch) > 1) {
					char ch1 = s.charAt(i);
					hmap.put(ch1, hmap.get(ch1) - 1);
					if(hmap.get(ch1) == 0) {
						hmap.remove(ch1);
					}
					i++;
				}
				j++;
			}
		}
		return longest;
    }
	
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(longestUniqueSubstr(s));

	}

}
