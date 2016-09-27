package leetcode.utility;

/**
 * Created by PV029500 on 9/21/2016.
 */
public class NodeUtility {

    public ListNodeKeyValue dummyHead = new ListNodeKeyValue(0, 0);
    public ListNodeKeyValue tail = dummyHead;

    public ListNodeKeyValue deleteNode(ListNodeKeyValue n) {
        if (n.next == null) {
            tail = dummyHead;
            return tail;
        } else {
            n.value = n.next.value;
            n.key = n.next.key;
            n.next = n.next.next;
            if (n.next == null) {
                tail = n;
            }
        }
        return n;
    }

    public ListNodeKeyValue addNode(int key, int value) {
        ListNodeKeyValue k = new ListNodeKeyValue(key, value);
        ListNodeKeyValue prevTail = tail;
        tail.next = k;
        tail = k;
        return prevTail;
    }
}
