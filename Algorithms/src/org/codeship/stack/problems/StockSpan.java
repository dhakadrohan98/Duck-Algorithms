package org.codeship.stack.problems;

import java.util.ArrayList;
import java.util.Stack;

class Pair {
    int num;
    int index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

public class StockSpan {

    //TC: O(n)
    //SC: O(n)
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] ngtr = new int[n];
        Stack<Pair> st = new Stack<>();
        //calculate next greater to left element index in ngtr array
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek().num <= arr[i]) {
                st.pop();
            }
            if(!st.isEmpty() && st.peek().num > arr[i]) {
                //Don't pop the greatest element because it is required to compare it with further elements to its next element
                ngtr[i] = st.peek().index;
            } else {
                ngtr[i] = -1;
            }
            st.push(new Pair(arr[i], i));
            System.out.print(arr[i] + " " + ngtr[i]);
            list.add(i - ngtr[i]);
            System.out.println();
        }
        return list;
    }

    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        int[] arr1 = {100, 80, 60, 70, 60, 75, 85};
        int[] arr2 = {10, 4, 5, 90, 120, 8};
        System.out.println(stockSpan.calculateSpan(arr2));
    }
}
