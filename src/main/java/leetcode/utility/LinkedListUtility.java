package leetcode.utility;

import java.util.Random;

/**
 * Created by PV029500 on 7/25/2016.
 */
public class LinkedListUtility {

    public static ListNode makeList(int boundary, int size) {
        Random rand = new Random();
        ListNode head = null, temp = null;
        for (int i = 0; i < size; i++) {
            int j = rand.nextInt(boundary);
            if (i == 0) {
                temp = new ListNode(j);
                head = temp;
            } else {
                temp.next = new ListNode(j);
                temp = temp.next;
            }
        }
        return head;
    }

    public static ListNode reverseList(ListNode node) {
        if (node == null)
            return null;
        if(node.next == null)
            return node;
        ListNode head = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    public static ListNode reverseList(ListNode source, ListNode target, ListNode begin) {
        if (source == target)
            return target;
        ListNode temp = target.next;
        ListNode head = reverseList(source.next, target, begin);
        begin.next = head;
        source.next.next = source;
        source.next = temp;
        return head;
    }

    public static int getSize(ListNode node) {
        int count = 0;
        while(node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public static void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
