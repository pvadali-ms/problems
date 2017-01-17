package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by k on 10/20/16.
 */
public class RotateArrayTest {

    @Test
    public void rotateArray() {
        RotateArray rotateArray = new RotateArray();
    }

    Map<Class<?>, Object> m = new HashMap<Class<?>, Object>();

    public <T> void putGeneric(Class<T> type, T instance) {
        m.put(type, instance);
    }

    public void testPut() {
        String s = "test";
        RotateArrayTest rotateArrayTest = new RotateArrayTest();
        rotateArrayTest.putGeneric(String.class, s);
    }

    public <T> T getGeneric(Class<T> type) {
        return type.cast(m.get(type));
    }

    public void testAny(Object o) {

    }

}