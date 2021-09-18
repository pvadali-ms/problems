package epi.primitivetypes;

/**
 * Created by PV029500 on 12/23/2016.
 * Parity of a word is 1 if the number of 1's are odd and 0 if not.
 * A word is a binary stream
 * <p>
 * Method 1:
 * preCompute parity of 64 bits (if input is a long) in 4 sub divisions with 16 bits each.
 * 2^16 = 65536
 * Declare an array of size 65536
 * fill the array preComputedArray[] with parity for 0..65535
 * get each 16 bit subdivision by doing
 * preComputedParity[num >>> 3 * 16] ^ preComputedParity[num >>> 2 * 16] ^ preComputedParity[num >>> 2 * 16] ^ preComputedParity[num >>> 16]
 * <p>
 * Method 1:
 * preCompute parity of 64 bits (if input is a long) in 4 sub divisions with 16 bits each.
 * 2^16 = 65536
 * Declare an array of size 65536
 * fill the array preComputedArray[] with parity for 0..65535
 * get each 16 bit subdivision by doing
 * preComputedParity[num >>> 3 * 16] ^ preComputedParity[num >>> 2 * 16] ^ preComputedParity[num >>> 2 * 16] ^ preComputedParity[num >>> 16]
 */

/**
 * Method 1:
 * preCompute parity of 64 bits (if input is a long) in 4 sub divisions with 16 bits each.
 * 2^16 = 65536
 * Declare an array of size 65536
 * fill the array preComputedArray[] with parity for 0..65535
 * get each 16 bit subdivision by doing
 * preComputedParity[num >>> 3 * 16] ^ preComputedParity[num >>> 2 * 16] ^ preComputedParity[num >>> 2 * 16] ^ preComputedParity[num >>> 16]
 */

/**
 * Fastest way is in O(log n) time where n is number of bits XORing half each time will cancel 1's that are present at same indices
 * num ^= num >>> 32
 * num ^= num >>> 16
 * num ^= num >>> 8
 * num ^= num >>> 4
 * num ^= num >>> 2
 * num ^= num >>> 1
 * for example if the last four bit chunk is 1100
 * num ^ num>>>2 results in 1111
 * and num ^ num>>>1 results in 1010
 * return num & 1
 */
public class ComputeParity {

    public short computeParity(long num) {
        num ^= num >>> 32;
        num ^= num >>> 16;
        num ^= num >>> 8;
        num ^= num >>> 4;
        num ^= num >>> 2;
        num ^= num >>> 1;
        return (short) (num & 1);
    }
}
