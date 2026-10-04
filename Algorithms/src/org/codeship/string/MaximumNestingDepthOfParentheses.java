package org.codeship.string;

import java.util.Stack;

public class MaximumNestingDepthOfParentheses {
	
	public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxDepth = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
                maxDepth = Math.max(maxDepth, st.size());
            } else if(ch == ')') {
                st.pop();
            }
        }
        return maxDepth;
    }
	
	public static void main(String[] args) {
		
	}
}
