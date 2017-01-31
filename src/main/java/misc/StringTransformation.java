package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PV029500 on 1/30/2017.
 */
public class StringTransformation {

    public boolean isTransformationPossible(String[] arr) {

        Map<String, Integer> occurences = new HashMap<String, Integer>();
        Map<String, List<String>> matches = new HashMap<String, List<String>>();
        for (String str : arr) {
            if (occurences.containsKey(str)) {
                occurences.put(str, occurences.get(str) + 1);
            } else {
                occurences.put(str, 1);
            }
        }
        findMatches(arr, matches);

        for (Map.Entry<String, List<String>> e : matches.entrySet()) {
            occurences.put(e.getKey(), occurences.get(e.getKey()) - 1);
            if (runDFS(e.getValue(), occurences, matches, 1, arr.length))
                return true;
            occurences.put(e.getKey(), occurences.get(e.getKey()) + 1);
        }
        return false;
    }

    public boolean runDFS(List<String> matchList, Map<String, Integer> occurences, Map<String, List<String>> matches, int currLen, int arrLen) {
        if (currLen == arrLen)
            return true;
        for(String str : matchList) {
            if (matches.containsKey(str) && occurences.get(str) > 0) {
                occurences.put(str, occurences.get(str) - 1);
                if (runDFS(matches.get(str), occurences, matches, currLen + 1, arrLen))
                    return true;
                occurences.put(str, occurences.get(str) + 1);
            }
        }
        return false;
    }

    public void findMatches(String[] arr, Map<String, List<String>> matches) {
        for(int i = 0; i < arr.length; i++) {
            if (!matches.containsKey(arr[i])) {
                for(int j = 0; j < arr.length; j++) {
                    if (i != j && isMatch(arr[i], arr[j])) {
                        if(!matches.containsKey(arr[i]))
                            matches.put(arr[i], new ArrayList<String>());
                        matches.get(arr[i]).add(arr[j]);
                    }
                }
            }
        }
    }

    public boolean isMatch(String s1, String s2) {
        boolean diff = false;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && diff)
                return false;
            else if (s1.charAt(i) != s2.charAt(i))
                diff = true;
        }
        return diff;
    }
}
