package org.codeship.twopointers;

public class LongestPalidromicSubstring {
	
	public static String longestPalindrome(String s) {
		int n = s.length();		
		int maxLen = 0;
		int sp = 0;
		boolean[][] mem = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				boolean isPalindrome = solve(i, j, s, mem);
				if(isPalindrome && maxLen < (j-i+1)) {
					maxLen = j-i+1;
					sp = i;
				}
			}
		}
		return s.substring(sp, sp + maxLen);
    }

    private static boolean solve(int i, int j, String s, boolean[][] mem) {
        //base case
    	if(i >= j) {
    		mem[i][j] = true;
    		return true;
    	}
    	
    	if(mem[i][j]) {
    		return true;
    	}
    	
    	if(s.charAt(i) == s.charAt(j)) {
    		return solve(i+1, j-1, s, mem);
    	}
    	else {
    		mem[i][j] = false;
    		return false;
    	}
    } 
    
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}

}
