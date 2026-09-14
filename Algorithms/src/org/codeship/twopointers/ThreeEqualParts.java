package org.codeship.twopointers;

public class ThreeEqualParts {
	

	public static int[] threeEqualParts(int[] arr) {
        int[] ans = new int[] {-1, -1};
        //Track total num of 1s
        int numOf1s = 0;
        
        for(int element: arr) {
        	if(element == 1) {
        		numOf1s++;
        	}
        }
        
        if(numOf1s == 0) {
        	return new int[]{0, 2};
        }
        
        if(numOf1s % 3 != 0) {
        	return ans;
        }
        
        int numOf1sInEachPart = numOf1s / 3;
        int numOf1sInPart0 = -1;
        int numOf1sInPart1 = -1;
        int numOf1sInPart2 = -1;
        numOf1s = 0;
        
        //Find the index of first 1s in each part
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 1) {
        		numOf1s++;
        		if(numOf1s == 1) {
        			numOf1sInPart0 = i;
        		}
        		else if(numOf1s == numOf1sInEachPart + 1) {
        			numOf1sInPart1 = i;
        		} else if(numOf1s == (2 * numOf1sInEachPart) + 1) {
        			numOf1sInPart2 = i;
        		}
        	}
        }
        
        //Now start from 1st index of last part(start with 1) & compare the array values with each its previous parts
        while(numOf1sInPart2 < arr.length) {
        	if(arr[numOf1sInPart2] == arr[numOf1sInPart0] && arr[numOf1sInPart2] == arr[numOf1sInPart1]) {
        		numOf1sInPart0++;
        		numOf1sInPart1++;
        		numOf1sInPart2++;
        	} else {
        		return ans;
        	}
        }
        ans[0] = numOf1sInPart0 - 1;
        ans[1] = numOf1sInPart1;
        return ans;
    }
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1};
		int[] ans = threeEqualParts(arr);
		for(int num : ans) {
			System.out.print(num + ", ");
		}
	}

}
