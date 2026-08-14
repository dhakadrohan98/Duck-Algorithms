package org.codeship.stack.problems;

import java.util.Stack;


public class LargestRectabgleAreaInHistogram {

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

    public static void main() {
        int[] arr = new int[]{6, 2, 5, 4, 5, 1, 6};
        int maxArea = getMaxArea(arr);
        System.out.println(maxArea);

//        int[] ans = nstr(arr);
//        for(int num: ans) {
//            System.out.print(num + " ");
//        }
    }

}
