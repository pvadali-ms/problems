package leetcode.utility;

import org.junit.Test;

/**
 * Created by PV029500 on 7/25/2016.
 */
public class MakeLinkedlistTest {

    @Test
    public void makeLinkedlist() {
        LinkedListUtility makeLinkedList = new LinkedListUtility();
        ListNode node = makeLinkedList.makeList(9, 6);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}