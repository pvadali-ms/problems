package linkedin;

import java.util.Stack;

/**
 * Created by PV029500 on 11/27/2016.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {

        int first, second;
        Stack<Integer> st = new Stack<Integer>();

        for (String s : tokens) {
            if (s.equals("+")) {
                first = st.pop();
                second = st.pop();
                st.push(first + second);
            } else if (s.equals("*")) {
                first = st.pop();
                second = st.pop();
                st.push(first * second);
            } else if (s.equals("-")) {
                first = st.pop();
                second = st.pop();
                st.push(second - first);
            } else if (s.equals("/")) {
                first = st.pop();
                second = st.pop();
                st.push(second / first);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
