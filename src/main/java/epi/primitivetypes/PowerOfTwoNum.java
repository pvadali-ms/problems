package epi.primitivetypes;

/**
 * Created by PV029500 on 1/8/2017.
 */
public class PowerOfTwoNum {

    public double powerOfTwoNum(double x, int y) {
        double result = 1;

        if (y < 0) {
            y = -y;
            x = 1.0 / x;
        }
        while (y != 0) {
            if ((y & 1) != 0) {
                result *= x;
            }
            x *= x;
            y >>= 1;
        }

        return result;
    }
}
