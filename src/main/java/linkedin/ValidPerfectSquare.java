package linkedin;

/**
 * Created by PV029500 on 11/26/2016.
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Returns: True
 * Example 2:
 * <p>
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare {

    //Newtons method
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num)
            x = (x + num / x) / 2;
        return x * x == num;
    }

    //Binary search
    public boolean isPerfectSquareBinarySearch(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >> 1;
            if (mid * mid == num) return true;
            if (mid * mid > num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}
