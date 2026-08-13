package org.codeship.stack.problems;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElement {

    //TC: O(n)
    //SC: O(n)
    public static ArrayList<Integer> prevSmaller(int[] nums) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!st.isEmpty() && st.peek() < nums[i]) {
                list.add(st.peek());
            } else {
                while(!st.isEmpty() && st.peek() >= nums[i]) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() < nums[i]) {
                    list.add(st.peek());
                } else {
                    list.add(-1);
                }
            }
            st.push(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 4, 5};
        ArrayList<Integer> ans = prevSmaller(nums);
        System.out.println(ans);
    }
}
