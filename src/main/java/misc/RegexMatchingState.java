package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PV029500 on 4/14/2017.
 */
public class RegexMatchingState {
    State compile(String pattern) {
        State root = new State();
        State cur = root;
        for (int i = 0; i < pattern.length(); i++) {
            if (i < pattern.length() && '*' == pattern.charAt(i)) {
                cur.addTransfer(pattern.charAt(i), cur);
                State next = new State();
                cur.addTransfer('\0', next);
                cur = next;
            } else {
                State next = new State();
                cur.addTransfer(pattern.charAt(i), next);
                cur = next;
            }
        }
        cur.setEnd();
        return root;
    }

    boolean isMatch(String input, int index, State cur) {
        if (index == input.length() && cur.getNext('\0') == null) {
            return cur.isEnd();
        }
        if (index < input.length() && (cur.getNext(input.charAt(index)) != null || cur.getNext('*') != null)) {
            char c = cur.getNext(input.charAt(index)) == null ? '*' : input.charAt(index);
            for (State next : cur.getNext(c)) {
                if (isMatch(input, index + 1, next)) {
                    return true;
                }
            }
        }
        if (cur.getNext('\0') != null) {
            for (State next : cur.getNext('\0')) {
                if (isMatch(input, index, next)) {
                    return true;
                }
            }
        }
        if (index < input.length() && cur.getNext('?') != null) {
            for (State next : cur.getNext('?')) {
                if (isMatch(input, index + 1, next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, compile(p));
    }

    class State {
        boolean end;
        Map<Character, List<State>> transferTable;

        State() {
            transferTable = new HashMap<Character, List<State>>();
        }

        void addTransfer(char c, State next) {
            if (transferTable.containsKey(c)) {
                transferTable.get(c).add(next);
            } else {
                List<State> nexts = new ArrayList<State>();
                nexts.add(next);
                transferTable.put(c, nexts);
            }
        }

        List<State> getNext(char c) {
            return transferTable.get(c);
        }

        void setEnd() {
            end = true;
        }

        boolean isEnd() {
            return end;
        }
    }
}
