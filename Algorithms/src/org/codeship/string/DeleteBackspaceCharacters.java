package org.codeship.string;

import java.util.Stack;

public class DeleteBackspaceCharacters {

	public static String deleteBackspace(String str) {
		Stack<Character> st = new Stack<>();

		for (char ch : str.toCharArray()) {
			if(!st.isEmpty() && ch == '#') {
				st.pop();
			}
			else {
				st.push(ch);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < st.size(); i++) {
			sb.append(st.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "bwj#s#ns#n";
		String deleteBackspace = deleteBackspace(str);
		System.out.println(deleteBackspace);
	}

}
