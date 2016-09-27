package leetcode.medium;


import leetcode.utility.ListNode;

/**
 * Created by PV029500 on 7/25/2016.
 */
public class AddNumbersInLinkedList {
    static ListNode result = null;
    public static class Solution{
        public static ListNode addNumbers(ListNode l1, ListNode l2) {
            ListNode temp = null;
            int sum, carry = 0, add;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    add = l1.data + l2.data + carry;
                    sum = add % 10;
                    carry = add / 10;
                    l1 = l1.next;
                    l2 = l2.next;
                    temp = makeListNode(sum, temp);
                } else if (l2 != null) {
                    temp = runLoop(l2, carry, temp);
                    l2 = null;
                } else if (l1 != null) {
                    temp = runLoop(l1, carry, temp);
                    l1 = null;
                }
            }
            if (carry != 0) {
                temp.next = new ListNode(carry);
            }
            return result;
        }

        public static ListNode makeListNode(int sum, ListNode temp) {
            if(temp == null) {
                temp = new ListNode(sum);
                result = temp;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            return temp;
        }

        public static ListNode runLoop(ListNode node, int carry, ListNode temp) {
            int sum;
            while(node != null) {
                sum = (node.data + carry) % 10;
                carry = (node.data + carry) / 10;
                node = node.next;
                temp = makeListNode(sum, temp);
            }
            return temp;
        }
    }
}
