package org.codeship.string;

public class StringToInteger {

	public int myAtoi(String s) {
		long ans = 0l;
		boolean isNeg = false;

		s = s.trim();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (i == 0 && ch == '-') {
				isNeg = true;
				continue;
			} else if (i == 0 && ch == '+') {
				continue;
			}
			if (ch < '0' || ch > '9') {
				break;
			}
			ans = (ans * 10) + (ch - '0');
			if (ans < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			
			if (ans > Integer.MAX_VALUE) {
				if(isNeg) {
					return (Integer.MAX_VALUE * -1) - 1;
				}
				return Integer.MAX_VALUE;
			}
		}

		if (isNeg) {
			ans = ans * -1l;
		}
		return (int) ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
