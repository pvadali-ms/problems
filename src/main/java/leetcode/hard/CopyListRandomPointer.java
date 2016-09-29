package leetcode.hard;

import leetcode.utility.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 9/28/2016.
 */
public class CopyListRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = head, nTemp;
        while(temp != null) {
            nTemp = new RandomListNode(temp.label);
            m.put(temp, nTemp);
            temp = temp.next;
        }
        temp = head;

        while(temp != null) {
            nTemp = m.get(temp);
            nTemp.next = m.get(temp.next);
            nTemp.random = m.get(temp.random);
            temp = temp.next;
        }
        return m.get(head);
    }
}
