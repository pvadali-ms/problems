package leetcode.hard;

import leetcode.utility.RandomListNode;
import org.junit.Test;

/**
 * Created by PV029500 on 9/28/2016.
 */
public class CopyListRandomPointerTest {

    @Test
    public void testCopyRandomList() throws Exception {
        CopyListRandomPointer copyListRandomPointer = new CopyListRandomPointer();
        RandomListNode r1 = new RandomListNode(-1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        r1.next = r2;
        r2.next = r3;
        r3.random = r1;

        RandomListNode k = copyListRandomPointer.copyRandomList(r1);

        while(k != null) {
            System.out.println(k.random == null ? null : k.random.label);
            k = k.next;
        }
    }
}