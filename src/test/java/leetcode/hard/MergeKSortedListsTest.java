package leetcode.hard;

import leetcode.utility.ListNode;
import org.junit.Test;

/**
 * Created by PV029500 on 10/9/2016.
 */
public class MergeKSortedListsTest {

    @Test
    public void copyTest() {
        ListNode[] src = new ListNode[]{new ListNode(3)};

        ListNode[] target = src;
        src[0].data = 24;

        System.out.println(target[0].data);
    }

}