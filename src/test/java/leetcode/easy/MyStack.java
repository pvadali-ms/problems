package leetcode.easy;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by PV029500 on 1/26/2017.
 */
public class MyStack<T> {

    public static Stack<Object> s = new Stack<Object>();
    public void pushAll(Collection<T> c) {
        Iterator it = c.iterator();
        while(it.hasNext()) {
            s.push(it.next());
        }
    }


}
