package org.codeship.twopointers;

public class ContainerWithMostWater {
	
	//TC: O(n)
    //SC: O(1)
    public int maxArea(int[] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        int maxWater = 0;
        while(i < j) {
            int min = Math.min(arr[i], arr[j]);
            maxWater = Math.max(maxWater, min * (j-i));
            if(arr[i] <= arr[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
