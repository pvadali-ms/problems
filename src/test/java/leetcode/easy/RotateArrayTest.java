package leetcode.easy;

import org.junit.Test;

import java.util.*;

/**
 * Created by k on 10/20/16.
 */
public class RotateArrayTest {

    @Test
    public void rotateArray() {
        RotateArray rotateArray = new RotateArray();
    }

    private Map<Class, Object> m = new HashMap<Class, Object>();

    public <T extends List> void putGeneric(Class<T> type, T instance) {
        m.put(type, instance);
    }

    public void testPut() {
        String s = "test";
        RotateArrayTest rotateArrayTest = new RotateArrayTest();
        rotateArrayTest.putGeneric(LinkedList.class, new LinkedList());
    }

    public <T> T getGeneric(Class<T> type) {
        return type.cast(m.get(type));
    }

    public void testAny(Object o) {
        Stack<? extends Object> s= new Stack<Object>();

    }

}