package leetcode.easy;

import leetcode.utility.ListNode;

/**
 * Created by PV029500 on 9/27/2016.
 */
public class ReverseLinkedList {

    public ListNode reverseLinkedListNonRecursive(ListNode head) {

        if (head == null) return null;
        ListNode curr = head;
        ListNode prev = null, tmp;

        while(curr.next != null) {
            tmp = curr.next;
            if (prev != null) curr.next = prev;
            else curr.next = null;
            prev = curr;
            curr = tmp;
        }
        curr.next = prev;

        return curr;
    }

}
