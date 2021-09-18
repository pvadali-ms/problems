package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by PV029500 on 11/26/2016.
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * <p>
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * <p>
 * Example :
 * <p>
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * <p>
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 */
public class MinStepsInInfiniteGrid {
    //Moving diagonally is the shortest way possible. Getting the max between x & x - 1, y & y - 1 results in number of diagonal steps required + linear for balance
    //for example (1, 1) to (4, 5) gives 4 - 1 steps in diagonal - reaches (4, 4) and one step vertical, gives (4 - 1) + 1 => (5 - 1) steps
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int size = X.size();
        int distance = 0;
        for (int i = 1; i < size; i++) {
            distance += Math.abs(X.get(i) - X.get(i - 1)) < Math.abs(Y.get(i) - Y.get(i - 1)) ?
                    Math.abs(Y.get(i) - Y.get(i - 1)) : Math.abs(X.get(i) - X.get(i - 1));
        }
        return distance;
    }
}
