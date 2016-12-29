package epi.primitivetypes;

/**
 * Created by PV029500 on 12/28/2016.
 */
public class MultiplyTwoNum {

    public int multiplyXandY(int x, int y) {
        int result = 0;
        while (y != 0) {
            if ((y & 1) == 1) {
                result = addTwoNum(result, x);
            }
            x <<= 1;
            y >>= 1;
        }
        return result;
    }

    public int addTwoNum(int a, int b) {
        int sum = 0, tmpA = a, tmpB = b, k = 1;
        int carryIn = 0, carryOut, aK, bK;
        while ((tmpA | tmpB) != 0) {
            aK = a & k;
            bK = b & k;
            carryOut = (aK & bK) | (aK & carryIn) | (bK & carryIn);
            sum = sum | (aK ^ bK ^ carryIn);
            carryIn = carryOut<<1;
            k <<= 1;
            tmpA >>>= 1;
            tmpB >>>= 1;
        }
        return sum | carryIn;
    }
}
