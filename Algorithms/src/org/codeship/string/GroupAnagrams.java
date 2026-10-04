package org.codeship.string;

import java.util.*;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> hmap = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++) {
			//convert string into char array for sorting
			char[] str = strs[i].toCharArray();
			Arrays.sort(str);
			String sortedStr = new String(str);
			if(hmap.containsKey(sortedStr)) {
				List<String> list = hmap.get(sortedStr);
				list.add(strs[i]);
				hmap.put(sortedStr, list);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				hmap.put(sortedStr, list);
			}
		}
		
		//take list for each key in map
		List<List<String>> ans = new ArrayList<>();
		for(String key : hmap.keySet()) {
			ans.add(hmap.get(key));
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));

	}

}
