package org.codeship.stack.problems;

public class TrapRainWater {

    public static int maxTrapWater(int[] arr) {
        int totalWater = 0;
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = arr[0];


        //store for maxLeft
        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
        }

        //store for maxRight
        maxRight[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }

        // print maxLeft & maxRight
        for(int num: maxLeft) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(int num : maxRight) {
            System.out.print(num + " ");
        }
        System.out.println();

        for(int i = 0; i < n; i++) {
            int boundOfWater = Math.min(maxLeft[i], maxRight[i]);
            totalWater += boundOfWater - arr[i];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 0, 1, 0, 4};
        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(maxTrapWater(arr1));
    }
}
