package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 * You are given a read only array of n integers from 1 to n.
 * <p>
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * <p>
 * Return A and B.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Note that in your output A should precede B.
 * <p>
 * Example:
 * <p>
 * Input:[3 1 2 5 3]
 * <p>
 * Output:[3, 4]
 * <p>
 * A = 3, B = 4
 */
public class RepeatAndMissingNumberArray {

    //finding two numbers x, y from x^y - http://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/


    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            result ^= (a.get(i) ^ (i + 1));
        }

        int setBit = result & ~(result - 1);

        int first = 0, second = 0;

        for (Integer anA1 : a) {
            if ((anA1 & setBit) > 0) {
                first ^= (anA1);
            } else {
                second ^= (anA1);
            }
        }

        for (int i = 1; i <= a.size(); i++) {
            if ((i & setBit) > 0)
                first ^= i;
            else
                second ^= i;
        }

        for (Integer anA : a) {
            if (first == anA) {
                resultList.add(first);
                resultList.add(second);
                return resultList;
            }
        }
        resultList.add(second);
        resultList.add(first);
        return resultList;
    }
}
