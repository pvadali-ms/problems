package leetcode.hard;

import leetcode.utility.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PV029500 on 10/9/2016.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists1) {
        List<ListNode> lists = new ArrayList<ListNode>(Arrays.asList(lists1));
        int k = lists.size();
        ListNode[] maxHeap = (ListNode[]) lists.toArray().clone();
        for(int i = k / 2; i >= 0; i--) {
            maxHeapify(maxHeap, i);
        }

        ListNode head = null, dummy = null;

        while(lists.size() != 0) {
            if(head == null) {
                head = maxHeap[0];
                dummy = maxHeap[0];
            } else {
                dummy.next = maxHeap[0];
            }
            if (maxHeap[0] == null) return null;
            if (maxHeap[0].next == null) {
                ListNode l = maxHeap[k];
            } else {
                maxHeap[0] = maxHeap[0].next;
            }
            maxHeapify(maxHeap, 0);
        }

        return head;
    }

    public void maxHeapify(ListNode[] listNodes, int i) {

        int max;
        if(listNodes[2 * i + 1] == null || listNodes[2 * i + 2] == null) {
            max = listNodes[2 * i + 1] == null ? 2 * i + 2 : 2 * i + 1;
        } else {
            max = listNodes[2 * i + 1].data > listNodes[2 * i + 2].data ? 2 * i + 1 : 2 * i + 2;
        }

        if (listNodes[i] == null) {
            swap(listNodes, i, max);
        } else if (listNodes[i].data < listNodes[max].data) {
            swap(listNodes, i, max);
            maxHeapify(listNodes, max);
        }

    }

    public void swap(ListNode[] listNodes, int a, int b) {
        ListNode temp = listNodes[a];
        listNodes[a] = listNodes[b];
        listNodes[b] = temp;
    }

}

