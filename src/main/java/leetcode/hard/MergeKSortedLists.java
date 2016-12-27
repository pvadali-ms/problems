package leetcode.hard;

import leetcode.utility.ListNode;

/**
 * Created by PV029500 on 10/9/2016.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;
        ListNode[] minHeap = lists.clone();
        ListNode head = new ListNode(0), dummy = head;
        if (k <= 2) {
            ListNode firstNode = lists[0];
            ListNode secondNode = lists[1];
            while (firstNode != null || secondNode != null) {
                if (firstNode == null) {
                    while (secondNode != null) {
                        dummy.next = secondNode;
                        secondNode = secondNode.next;
                        dummy = dummy.next;
                    }
                } else if (secondNode == null) {
                    while (firstNode != null) {
                        dummy.next = firstNode;
                        firstNode = firstNode.next;
                        dummy = dummy.next;
                    }
                } else {
                    if (firstNode.val > secondNode.val) {
                        dummy.next = secondNode;
                        dummy = dummy.next;
                        secondNode = secondNode.next;
                    } else {
                        dummy.next = firstNode;
                        dummy = dummy.next;
                        firstNode = firstNode.next;
                    }
                }
            }
            return head.next;
        }

        for(int i = k / 2; i >= 0; i--) {
            minHeapify(minHeap, i);
        }


        while(minHeap[0] != null) {

        }

        return head.next;
    }

    public void minHeapify(ListNode[] listNodes, int i) {
        ListNode first = listNodes[2 * i + 1];
        ListNode second = listNodes[2 * i + 2];
        ListNode min = listNodes[i];
        if (first == null && second == null && min == null) return;
        if (first == null && second == null) return;
        if (min == null) {
            if (first != null && second != null) {
                if (first.val > second.val)
                    swap(listNodes, i, 2 * i + 2);
                else
                    swap(listNodes, i, 2 * i + 1);
            } else if (first == null) {
                swap(listNodes, i, 2 * i + 2);
            } else {
                swap(listNodes, i, 2 * i + 1);
            }
            return;
        }
        if (first == null) {
            if (min.val > second.val)
                swap(listNodes, i, 2 * i + 2);
        } else if (second == null) {
            if (min.val > first.val)
                swap(listNodes, i, 2 * i + 1);
        } else {
            if (min.val > first.val && first.val < second.val) {
                swap(listNodes, i, 2 * i + 1);
            } else if (min.val > second.val && second.val < first.val) {
                swap(listNodes, i, 2 * i + 2);
            }
        }

    }

    public void swap(ListNode[] listNodes, int a, int b) {
        ListNode temp = listNodes[a];
        listNodes[a] = listNodes[b];
        listNodes[b] = temp;
    }

}

