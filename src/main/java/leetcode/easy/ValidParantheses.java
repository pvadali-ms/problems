package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by PV029500 on 9/28/2016.
 */
public class ValidParantheses {


    public boolean validParantheses(String s) {
        Stack<String> st = new Stack<String>();
        Map<String, String> m = new HashMap<String, String>();

        m.put(")", "(");
        m.put("}", "{");
        m.put("]", "[");

        for (char c : s.toCharArray()) {
            if (m.get(String.valueOf(c)) != null) {
                String re = st.empty() ? null : st.pop();
                if (!m.get(String.valueOf(c)).equals(re)) {
                    return false;
                }
                break;
            }
            st.push(String.valueOf(c));
        }
        return st.empty();
    }
}
