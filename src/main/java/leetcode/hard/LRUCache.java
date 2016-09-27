package leetcode.hard;


import leetcode.utility.ListNodeKeyValue;
import leetcode.utility.NodeUtility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 9/21/2016.
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, ListNodeKeyValue> m = new HashMap<Integer, ListNodeKeyValue>();
    NodeUtility nu = new NodeUtility();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = -1;
        if(m.containsKey(key)) {
            ListNodeKeyValue l = m.get(key);
            if (l == nu.tail) {
                return l.value;
            } else {
                val = l.value;
                m.remove(l.key);
                ListNodeKeyValue k = nu.deleteNode(l);
                m.put(k.key, k);
                ListNodeKeyValue prev = nu.addNode(key, val);
                if (prev != nu.dummyHead) {
                    m.put(prev.key, prev);
                }
                m.put(key, nu.tail);
            }
        }
        return val;
    }

    public void set(int key, int value) {
        if (m.containsKey(key)) {
            ListNodeKeyValue l = m.get(key);
            if (l == nu.tail) {
                l.value = value;
                return;
            }
            m.remove(l.key);
            ListNodeKeyValue k = nu.deleteNode(l);
            m.put(k.key, k);
            ListNodeKeyValue prev = nu.addNode(key, value);
            if (prev != nu.dummyHead) {
                m.put(prev.key, prev);
            }
            m.put(key, nu.tail);
            return;
        } else if(m.size() == capacity) {
            ListNodeKeyValue l = nu.dummyHead.next;
            m.remove(l.key);
            ListNodeKeyValue k = nu.deleteNode(l);
            if(k != nu.dummyHead) m.put(k.key, k);
            ListNodeKeyValue prev = nu.addNode(key, value);
            if (prev != nu.dummyHead) {
                m.put(prev.key, prev);
            }
            m.put(key, nu.tail);
            return;
        }
        ListNodeKeyValue temp = nu.addNode(key, value);
        m.put(key, nu.tail);
        if (temp != nu.dummyHead) {
            m.put(temp.key, temp);
        }
    }

}
