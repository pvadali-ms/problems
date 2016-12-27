package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by PV029500 on 11/25/2016.
 */
public class PlusOne {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int trueHead = 0;
        while (trueHead < a.size() && a.get(trueHead) == 0)
            trueHead++;
        ArrayList<Integer> answer = new ArrayList<Integer>();

        int carry = 1;
        int i = a.size() - 1;
        for (; i >= trueHead; i--) {
            if (a.get(i) + carry < 10) {
                answer.add(a.get(i) + 1);
                carry = 0;
                i--;
                break;
            } else {
                answer.add((a.get(i) + 1) % 10);
                carry = 1;
            }
        }

        if (i < trueHead && carry == 1) {
            answer.add(1);
        }

        while(i >= trueHead) {
            answer.add(a.get(i));
            i--;
        }
        Collections.reverse(answer);
        return answer;
    }
}
