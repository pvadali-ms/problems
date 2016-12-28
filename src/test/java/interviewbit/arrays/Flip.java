package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by PV029500 on 11/26/2016.
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation,
 * return an empty array.
 * Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

 Notes:
 - Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

 For example,
 S = 010

 Pair of [L, R] | Final string
 _______________|_____________
 [1 1]          | 110
 [1 2]          | 100
 [1 3]          | 101
 [2 2]          | 000
 [2 3]          | 001

 We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
 Another example,

 If S = 111

 No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Flip {

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(-1);
        arrayList.add(-1);
        int start = -1, count = -1, max = 0;

        for (int i = 0; i < A.length(); i++) {
            while(i < A.length() && A.charAt(i) == '1') {
                count--;
                i++;
            }

            if (i < A.length()) {
                if (count < 0) {
                    start = i;
                    count = 0;
                }
                count++;
                if (max < count) {
                    max = count;
                    arrayList.set(0, start + 1);
                    arrayList.set(1, i + 1);
                }
            }
        }
        return arrayList.get(0) == -1 ? new ArrayList<Integer>() : arrayList;
    }
}
