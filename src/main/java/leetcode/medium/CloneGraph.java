package leetcode.medium;

import leetcode.utility.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 10/13/2016.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode newNode = null;

        Map<UndirectedGraphNode, UndirectedGraphNode> visitedMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        if (node != null) {
            newNode = new UndirectedGraphNode(node.label);
            visitedMap.put(node, newNode);
            runDFS(node, newNode, visitedMap);
        }
        return newNode;
    }

    public void runDFS(UndirectedGraphNode node, UndirectedGraphNode newNode, Map<UndirectedGraphNode, UndirectedGraphNode> visitedMap) {
        for(UndirectedGraphNode neighborNode : node.neighbors) {
            if (visitedMap.containsKey(neighborNode)) {
                newNode.neighbors.add(visitedMap.get(neighborNode));
            } else {
                UndirectedGraphNode newNeighborNode = new UndirectedGraphNode(neighborNode.label);
                newNode.neighbors.add(newNeighborNode);
                visitedMap.put(neighborNode, newNeighborNode);
                runDFS(neighborNode, newNeighborNode, visitedMap);
            }
        }
    }
}
