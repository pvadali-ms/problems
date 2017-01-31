package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by PV029500 on 1/25/2017.
 */

/**
 * Sample Input:
 * 1114/1112/1121/1111
 1115/1112/1121/1111
 1116/1113/1111
 1118/1120/1121/1111
 1119/1120/1121/1111
 1301/1300/1113/1111
 1302/1300/1113/1111
 *
 * Sample Output:
 * {name: '1111', msGroup: true}
 {name: '1121', msGroup: true}
 {name: '1112', msGroup: true}
 {name: '1114', selected: false}
 {name: '1115', selected: false}
 {msGroup: false}
 {name: '1120', msGroup: true}
 {name: '1118', selected: false}
 {name: '1119', selected: false}
 {msGroup: false}
 {msGroup: false}
 {name: '1113', msGroup: true}
 {name: '1116', selected: false}
 {name: '1300', msGroup: true}
 {name: '1301', selected: false}
 {name: '1302', selected: false}
 {msGroup: false}
 {msGroup: false}
 {msGroup: false}
 */
public class SampleTraversal {

    public static Map<Integer, Map<String, nAryTree>> levelMap = new HashMap<Integer, Map<String, nAryTree>>();
    public static Set<nAryTree> visitedSet = new HashSet<nAryTree>();
    public static List<String> resultList = new ArrayList<String>();

    public void readInput() throws Exception{
        String path = "..\\SampleTraversalInput";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(path)));
        String line;
        nAryTree dummyRoot = new nAryTree(null);
        while ((line = bufferedReader.readLine()) != null) {
            processLine(line.split("\\/"), dummyRoot);
        }
        bufferedReader.close();
        traverseAndPrintTree(dummyRoot);
    }

    public void processLine(String[] values, nAryTree dummy) {
        for (int i = 0, j = values.length - 1; i < values.length; i++, j--) {
            String currValue = values[j];
            nAryTree node;
            nAryTree parent = null;
            if (j != values.length - 1) {
                parent = levelMap.get(i - 1).get(values[j + 1]);
            }
            if (!levelMap.containsKey(i)) {
                levelMap.put(i, new HashMap<String, nAryTree>());
            }
            if (!levelMap.get(i).containsKey(currValue) ||
                    (parent != null && !levelMap.get(i).get(currValue).parent.data.equals(parent.data))) {
                node = new nAryTree(parent);
                node.data = currValue;
                levelMap.get(i).put(currValue, node);
                if (parent != null)
                    node.parent.children.add(node);
                else
                    dummy.children.add(node);
            }
        }
    }


    public void traverseAndPrintTree(nAryTree node) {
        for(nAryTree child : node.children) {
            dfs(child);
        }
        for (String s : resultList) {
            System.out.println(s);
        }
    }

    public void dfs(nAryTree curr) {
        if (!visitedSet.contains(curr))
            resultList.add("{\"name\": \"" + curr.data + "\", "  + (curr.children.size() > 0 ? "\"msGroup\": \"true\"}" : "\"selected\": \"false\"}"));
        visitedSet.add(curr);
        for(nAryTree child : curr.children) {
            dfs(child);
        }
        if (curr.children.size() > 0)
            resultList.add("{\"msGroup\": \"false\"}");
    }

    public class nAryTree {

        String data;
        List<nAryTree> children;
        nAryTree parent;

        public nAryTree(nAryTree parent) {
            children = new ArrayList<nAryTree>();
            this.parent = parent;
        }
    }
}
