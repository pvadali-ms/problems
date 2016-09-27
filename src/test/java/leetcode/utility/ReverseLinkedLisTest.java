package leetcode.utility;

import org.junit.Test;

/**
 * Created by PV029500 on 8/3/2016.
 */
public class ReverseLinkedLisTest {
    @Test
    public void reverseLinkedList() {
        ListNode head = LinkedListUtility.makeList(15, 8);
        LinkedListUtility.printList(head);
        head = LinkedListUtility.reverseList(head);
        LinkedListUtility.printList(head);
    }

    @Test
    public void reversePartialList() {
        ListNode head = LinkedListUtility.makeList(45, 9);
        LinkedListUtility.printList(head);
        ListNode temp = head;
        int start = 3, end = 7, count = 0;
        ListNode src = head, dest = head, begin = head;
        while(count++ <= end) {
            if (count == start - 1) {
                begin = temp;
            }
            if (count == start)
                src = temp;
            if (count == end)
                dest = temp;
            temp = temp.next;
        }
        LinkedListUtility.reverseList(src, dest, begin);
        LinkedListUtility.printList(head);
    }
}
