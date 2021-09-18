package leetcode.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 10/13/2016.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
