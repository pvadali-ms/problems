package epi.primitivetypes;

/**
 * Created by PV029500 on 12/28/2016.
 * <p>
 * weight of number 9 is 2 since there are 2 1's
 * closest number is number with same number of 1's such that |x - y| is a min as possible
 * 9 = 0001 0001
 * closest will be 0001 0010 in this case.
 * if the number is 0011
 * closest will be 0101
 * if the first 1 has a zero beside it, swap those bits
 * else find the first 1 that has a zero left to it and swap bits
 */

/**
 * weight of number 9 is 2 since there are 2 1's
 * closest number is number with same number of 1's such that |x - y| is a min as possible
 * 9 = 0001 0001
 * closest will be 0001 0010 in this case.
 * if the number is 0011
 * closest will be 0101
 * if the first 1 has a zero beside it, swap those bits
 * else find the first 1 that has a zero left to it and swap bits
 *
 */

/**
 * solving the below problem in constant time:
 *get the lowest set bit by num & ~(num - 1)
 * get the lowest unset bit by ~num & (num + 1)
 * if (unsetbit > setbit),             num ^= (lowestBitNotSet | lowestBitNotSet>>1);
 * else             num ^= (lowestBitSet | lowestBitSet>>1);
 */
public class ClosestIntegerWithSameWeights {

    public int closestIntegerWithSameWeights(int num) {
        for (int i = 0; i < 30; i++) {
            if ((num >>> i & 1) != (num >>> (i + 1) & 1)) {
                num ^= (1 << i) | (1 << (i + 1));
                return num;
            }
        }
        return num;
    }

    public int closestIntegerConstantTime(int num) {
        int lowestBitSet = num & ~(num - 1);
        int lowestBitNotSet = ~num & (num + 1);

        if (lowestBitNotSet > lowestBitSet) {
            num ^= (lowestBitNotSet | lowestBitNotSet >> 1);
        } else {
            num ^= (lowestBitSet | lowestBitSet >> 1);
        }
        return num;
    }
}
