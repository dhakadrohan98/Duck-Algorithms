package org.codeship.twopointers;

public class PushDominoes {

	//TC: O(3n)
	//SC: O(2n)
	public static String pushDominoes(String str) {
		int n = str.length();
		int[] leftIndices = new int[n];
		int[] rightIndices = new int[n];

		int nearestLeftIndex = -1;
		// fill the leftIndex array
		for (int i = n - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (ch == 'L') {
				nearestLeftIndex = i;
			} else if (ch == 'R') {
				nearestLeftIndex = -1;
			}
			leftIndices[i] = nearestLeftIndex;
		}

		// fill the rightIndex array
		int nearestRightIndex = -1;
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (ch == 'R') {
				nearestRightIndex = i;
			} else if (ch == 'L') {
				nearestRightIndex = -1;
			}
			rightIndices[i] = nearestRightIndex;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if(leftIndices[i] == -1) {
				if(rightIndices[i] == -1) {
					sb.append('.');
				} else {
					sb.append('R');
				}
			} else if(rightIndices[i] == -1) {
				sb.append('L');
			} else {
				//Check the distance b/w left & right force indices if both index values are not -1
				int leftForceDist = Math.abs(i - leftIndices[i]);
				int rightForDist = Math.abs(i - rightIndices[i]);
				if(leftForceDist < rightForDist) {
					sb.append('L');
				} else if(rightForDist < leftForceDist) {
					sb.append('R');
				} else { //left & right force have been put at the same nearest index together
					sb.append('.');
				}
			}
			
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = ".L.R...LR..L..";
		String result = pushDominoes(str);
		System.out.println(result);

	}

}
