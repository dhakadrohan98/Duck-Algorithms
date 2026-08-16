package org.codeship.stack.problems;

import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {

    //TC: O((m*n) * 3n)
    //SC: O(2n+m)
    public static int maxArea(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int maxArea = 0;
        //edge case
        if(n == 0 || m == 0) {
            return 0;
        }
        int[] currRow = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    currRow[j] += 1;
                } else if(arr[i][j] == 0) {
                    currRow[j] = 0;
                }
            }
            int currentHistogramArea = getMaxArea(currRow);
            maxArea = Math.max(maxArea, currentHistogramArea);
        }
        return maxArea;
    }

    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] nstl = nstl(arr);
        int[] nstr = nstr(arr);
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            int width = nstr[i] - nstl[i] - 1;
            int currArea = arr[i] * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static int[] nstl(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek().num >= arr[i]) {
                st.pop();
            }
            if(!st.isEmpty() && st.peek().num < arr[i]) {
                res[i] = st.peek().index;
            } else {
                res[i] = -1;
            }
            st.push(new Pair(arr[i], i));
        }
        return res;
    }

    public static int[] nstr(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek().num >= arr[i]) {
                st.pop();
            }
            if(!st.isEmpty() && st.peek().num < arr[i]) {
                res[i] = st.peek().index;
            } else {
                res[i] = n;
            }
            st.push(new Pair(arr[i], i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0},
                       {1, 1, 1, 1},
                       {1, 1, 1, 1},
                       {0, 1, 0, 0}};
        System.out.println(maxArea(arr));
    }
}
