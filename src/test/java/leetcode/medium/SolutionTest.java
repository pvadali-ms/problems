package leetcode.medium;

import org.junit.Test;
import leetcode.utility.LinkedListUtility;
import leetcode.utility.ListNode;

/**
 * Created by PV029500 on 7/25/2016.
 */
public class SolutionTest {

    @Test
    public void testAddNumbers() throws Exception {
        ListNode l1 = LinkedListUtility.makeList(9, 5);
        printList(l1);
        ListNode l2 = LinkedListUtility.makeList(9, 2);
        printList(l2);
        ListNode result = AddNumbersInLinkedList.Solution.addNumbers(l1, l2);
        printList(result);
    }

    public void printList(ListNode node){
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }
}