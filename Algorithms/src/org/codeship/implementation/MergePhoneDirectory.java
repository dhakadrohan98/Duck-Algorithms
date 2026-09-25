package org.codeship.implementation;

import java.util.*;

public class MergePhoneDirectory {

	//TC: O(m+n)
	//SC: O(m+n)
	private static Map<String, Set<Integer>> mergeTwoPhoneDir(Map<String, List<Integer>> phone1,
			Map<String, List<Integer>> phone2) {

		Map<String, Set<Integer>> contactMap = new HashMap<>();

		for (String name1 : phone1.keySet()) {
			Set<Integer> set = new HashSet<>();
			if (phone2.containsKey(name1)) {
				// iterate over list of numbers of name1 person & if found the similar contact
				// then add into Set
				set.addAll(phone1.get(name1));
				set.addAll(phone2.get(name1));
			} else {
				set.addAll(phone1.get(name1));
			}
			contactMap.put(name1, set);
		}
		
		for (String name2 : phone2.keySet()) {
			if(phone1.containsKey(name2)) {
				continue;
			}
			Set<Integer> set = new HashSet<>();
			set.addAll(phone2.get(name2));
			contactMap.put(name2, set);
		}
		
		return contactMap;
	}

	public static void main(String[] args) {
		Map<String, List<Integer>> phone1 = new HashMap<>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(9273);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1234);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(2589);
		phone1.put("Ayush", list1);
		phone1.put("Rohan", list2);
		phone1.put("Khatik", list3);

		Map<String, List<Integer>> phone2 = new HashMap<>();
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(68910);
		List<Integer> list5 = new ArrayList<Integer>();
		list5.add(78125);
		List<Integer> list6 = new ArrayList<Integer>();
		list6.add(6542);
		list6.add(1234);
		phone2.put("Ritesh", list4);
		phone2.put("Pranav", list5);
		phone2.put("Rohan", list6);
		
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(mergeTwoPhoneDir(phone1, phone2));

	}

}
