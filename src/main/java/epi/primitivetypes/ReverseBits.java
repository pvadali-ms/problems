package epi.primitivetypes;

/**
 * Created by PV029500 on 12/28/2016.
 */

/**
 * this is same as compute parity
 * shift half of the bits and shift each even bit
 * O (log n) time where n is the number of bits
 * <p>
 * Method 2:
 * Other way is to precompute the reverse for chunks of four
 * and repeat the same as in compute parity
 */
public class ReverseBits {

    public int reverseBits(int num) {
        num = (num & 0x55555555) << 1 | (num >>> 1) & 0x55555555; //"and" with 0101 (8 times) to preserve odd bits, right shift and "and" again to preserve even bits
        num = (num & 0x33333333) << 2 | (num >>> 2) & 0x33333333; //"and" with 0011 to shift two bits
        num = (num & 0x0f0f0f0f) << 4 | (num >>> 4) & 0x0f0f0f0f; //move 4 bits
        num = (num & 0x00ff00ff) << 8 | (num >>> 8) & 0x00ff00ff; // move 8 bits
        num = (num & 0x0000ffff) << 16 | (num >>> 16) & 0x0000ffff;
        return num;

        /**
         * Method 2:
         * Java Integer library does it this way:
         * i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
         i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
         i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
         i = (i << 24) | ((i & 0xff00) << 8) |
         ((i >>> 8) & 0xff00) | (i >>> 24);
         return i;
         here after shifting 4 bits the number is a-b-c-d
         it is, now enough to shift b-c to c-b and a to and d to a to make this d-c-b-a
         this is done by initially shifting i << 24 | i >>> 24 (shifts a and d), | ((i & 0xff00) << 8) |
         ((i >>> 8) & 0xff00) - shifts b and c
         */
    }
}
