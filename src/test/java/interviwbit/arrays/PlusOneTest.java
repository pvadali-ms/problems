package interviwbit.arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by PV029500 on 11/25/2016.
 */
public class PlusOneTest {

    @Test
    public void testPlusOne() throws Exception {
        PlusOne plusOne = new PlusOne();
        int[] arr = new int[]{ 2, 5, 6, 8, 6, 1, 2, 4, 5 };
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(ArrayUtils.toObject(arr)));
        plusOne.plusOne(input);
    }
}