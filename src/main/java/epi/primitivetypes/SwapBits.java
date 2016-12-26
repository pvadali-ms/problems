package epi.primitivetypes;

/**
 * Created by PV029500 on 12/26/2016.
 */

/**
 * Swap bits at indices i, j
 * build a mask as (1 << i) | (1 << j)
 * xor the num with mask
 */
public class SwapBits {

    public int swapBits(int num, int i, int j) {
        int mask;
        if (i != j && ((num & (1 << i)) != (num & (1 << j))))
            mask = (1 << i) | (1 << j);
        else
            return num;
        return num ^ mask;
    }
}
