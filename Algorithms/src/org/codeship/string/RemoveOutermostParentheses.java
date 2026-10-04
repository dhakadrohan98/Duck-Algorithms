package org.codeship.string;

import java.util.*;

public class RemoveOutermostParentheses {

	// TC: O(n)
	// SC: O(1)
	public String removeOuterParentheses(String s) {
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				if (st.size() > 0) {
					sb.append(ch);
				}
				st.push(ch);
			} else if (ch == ')') {
				if (st.size() > 1) {
					sb.append(ch);
				}
				st.pop();
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
