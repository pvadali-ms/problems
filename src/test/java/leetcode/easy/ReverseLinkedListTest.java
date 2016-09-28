package leetcode.easy;

import leetcode.utility.LinkedListUtility;
import leetcode.utility.ListNode;
import org.junit.Test;

/**
 * Created by PV029500 on 9/27/2016.
 */
public class ReverseLinkedListTest {

    @Test
    public void reverLinkedList() {
        ListNode head = LinkedListUtility.makeList(30, 0);
        LinkedListUtility.printList(head);
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode tmp = r.reverseLinkedListNonRecursive(head);
        LinkedListUtility.printList(tmp);

    }

}