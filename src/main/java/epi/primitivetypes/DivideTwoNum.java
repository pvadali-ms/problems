package epi.primitivetypes;

/**
 * Created by PV029500 on 1/8/2017.
 */
public class DivideTwoNum {

    public long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while(yPower > x) {
                yPower >>>= 1;
                power--;
            }
            result += 1L << power;
            x -= yPower;
        }
        return result;
    }
}
