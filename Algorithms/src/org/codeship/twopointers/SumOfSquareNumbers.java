package org.codeship.twopointers;

public class SumOfSquareNumbers {
	
	//TC:O(sqrt(C))
    //SC: O(1)
	public boolean judgeSquareSum(int c) {
		int l = 0;
		int r = (int) Math.sqrt(c);

		boolean isPerfectSquare = false;

		while (l <= r) {
			int aSquare = c - (l * l);
			int a = (int) Math.sqrt(aSquare);
			if (a * a == aSquare) {
				isPerfectSquare = true;
				break;
			} else if ((a * a) < aSquare) {
				l++;
			} else if ((a * a) > aSquare) {
				r--;
			}
		}
		return isPerfectSquare;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
