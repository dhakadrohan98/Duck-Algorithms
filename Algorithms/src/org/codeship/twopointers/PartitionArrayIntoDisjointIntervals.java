package org.codeship.twopointers;

public class PartitionArrayIntoDisjointIntervals {
	
	public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int partition = -1;
        
        leftMax[0] = nums[0];
        for(int i = 1; i < n; i++) {
            if(leftMax[i-1] >= nums[i]) {
                leftMax[i] = leftMax[i-1]; 
            } else {
                leftMax[i] = nums[i];
            }
        }

        rightMin[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            if(rightMin[i+1] <= nums[i]) {
                rightMin[i] = rightMin[i+1];
            } else {
                rightMin[i] = nums[i];
            }
        }
        
        //print leftMax 
        for(int i = 0; i < n; i++) {
        	System.out.print(leftMax[i] + " ");
        }
        System.out.println();
        
      //print rightMin
        for(int i = 0; i < n; i++) {
        	System.out.print(rightMin[i] + " ");
        }
        System.out.println();

        for(int i = 1; i < n; i++) {
            if(leftMax[i-1] <= rightMin[i]) {
                partition = i;
                break;
            }
        }
        return partition;

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums0 = {5, 0, 3, 8, 6};
		int[] nums1 = {1,1,1,0,6,12};
		int partitionDisjoint = partitionDisjoint(nums1);
		System.out.println(partitionDisjoint);
		

	}

}
