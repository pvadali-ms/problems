package leetcode.easy;

import org.junit.Test;

/**
 * Created by k on 10/5/16.
 */
public class MinStackTest {

    @Test
    public void minStackTest() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());

        minStack.push(2);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());




    }



}