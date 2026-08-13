package org.codeship.stack.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    //TC: O(n)
    //SC: O(n)
    public static List<Integer> nextGreaterToRight(int[] arr) {
        int n = arr.length;
        List<Integer>  list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        list.add(-1);
        st.push(arr[n-1]);
        int i = n-2;
        while(i >= 0) {
            if(!st.isEmpty() && st.peek() > arr[i]) {
                list.add(st.peek());
            } else {
                while(!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                if(!st.isEmpty()) {
                    list.add(st.peek());
                } else {
                    list.add(-1);
                }
            }
            st.push(arr[i]);
            i -= 1;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {1, 3, 2, 4};
        List<Integer> list = nextGreaterToRight(arr2);
        for(int num: list) {
            System.out.print(num + " ");
        }
    }
}
