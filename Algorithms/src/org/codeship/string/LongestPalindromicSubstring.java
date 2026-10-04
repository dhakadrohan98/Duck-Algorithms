package org.codeship.string;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		int n = s.length();
		int maxLen = 0;
		int sp = 0;
		Boolean[][] mem = new Boolean[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				boolean isPalindrome = solve(i, j, s, mem);
				if (isPalindrome && maxLen < (j - i + 1)) {
					maxLen = j - i + 1;
					sp = i;
				}
			}
		}
		return s.substring(sp, sp + maxLen);
	}

	private static boolean solve(int i, int j, String s, Boolean[][] mem) {

		if (mem[i][j] != null) {
			return mem[i][j];
		}

		// base case
		if (i >= j) {
			return true;
		}

		if (s.charAt(i) == s.charAt(j)) {
			mem[i][j] = solve(i + 1, j - 1, s, mem);
		} else {
			mem[i][j] = false;
		}
		return mem[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
