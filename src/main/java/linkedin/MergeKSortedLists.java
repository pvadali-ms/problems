package linkedin;

import leetcode.utility.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by PV029500 on 11/26/2016.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            tail.next = priorityQueue.poll();
            tail = tail.next;

            if (tail.next != null) {
                priorityQueue.add(tail.next);
            }
        }
        return dummy.next;
    }

//recursive
public ListNode mergeKListsRecurse(ListNode[] lists) {

    if (lists.length==0) return null;
    if (lists.length==1) return lists[0];
    if (lists.length==2) return mergeTwoLists(lists[0], lists[1]);
    return mergeTwoLists(mergeKListsRecurse(Arrays.copyOfRange(lists, 0, lists.length/2)),
            mergeKListsRecurse(Arrays.copyOfRange(lists, lists.length/2, lists.length)));
}


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

