package org.codeship.stack.problems;

import java.util.Stack;

//Tc: O(1) for push, pop, top & getMin() methods
public class MinStack {

    Stack<Integer> st;
    Stack<Integer> ss;

    public MinStack() {
        this.st = new Stack<>();
        this.ss = new Stack<>();
    }

    public void push(int value) {
        st.push(value);
        if(ss.isEmpty()) {
            ss.push(value);
        }
        else if(!ss.isEmpty() && ss.peek() >= value) {
            ss.push(value);
        }
    }

    public void pop() {
        int val = st.peek();
        if(!st.isEmpty()) {
            st.pop();
        }
        if(!ss.isEmpty() && ss.peek() == val) {
            ss.pop();
        }
    }

    public int top() {
        if(!st.isEmpty()) {
            return st.peek();
        }
        return Integer.MIN_VALUE - 1;
    }

    public int getMin() {
        if(!ss.isEmpty()) {
            return ss.peek();
        }
        return Integer.MIN_VALUE - 1;
    }
}
