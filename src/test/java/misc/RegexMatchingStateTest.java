package misc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PV029500 on 4/14/2017.
 */
public class RegexMatchingStateTest {

    @Test
    public void test() {
        RegexMatchingState regexMatchingState = new RegexMatchingState();
        System.out.println(regexMatchingState.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }
}