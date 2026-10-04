package org.codeship.string;

import java.util.*;

public class IsomorphicString {

	// TC: O(n)
	// SC: O(1)
	public boolean isIsomorphic(String s, String t) {
		int n = s.length();
		int m = t.length();
		if (n != m) {
			return false;
		}
		Map<Character, Character> hmap = new HashMap<>();
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if (hmap.containsKey(ch1)) {
				if (hmap.get(ch1) != ch2) {
					return false;
				}
			} else if (set.contains(ch2)) {
				return false;
			} else if (!set.contains(ch2)) {
				hmap.put(ch1, ch2);
				set.add(ch2);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
