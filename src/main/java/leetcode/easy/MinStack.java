package leetcode.easy;

import java.util.Stack;

/**
 * Created by k on 10/5/16.
 */
public class MinStack {

    Stack<Long> minStack = new Stack<Long>();
    long min = 0;

    public MinStack() {

    }

    public void push(int x) {
        if(minStack.empty()) {
            min = x;
            minStack.push((long) 0);
        } else {
            minStack.push(x - min);
            if (x < min)
                min = x;
        }
    }

    public void pop() {
        long x = minStack.pop();
        if (x < 0) min = min - x;
    }

    public int top() {
        long top = minStack.peek();

        if (top > 0) {
            return (int)(top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
