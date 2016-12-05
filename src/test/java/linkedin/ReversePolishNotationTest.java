package linkedin;

import org.junit.Test;

/**
 * Created by PV029500 on 11/28/2016.
 */
public class ReversePolishNotationTest {

    @Test
    public void test() {
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

        String[] arr = new String[]{"2", "1", "+", "3", "*"};

        reversePolishNotation.evalRPN(arr);
    }

}