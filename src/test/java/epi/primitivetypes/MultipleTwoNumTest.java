package epi.primitivetypes;

import org.junit.Test;

/**
 * Created by PV029500 on 12/28/2016.
 */
public class MultipleTwoNumTest {

    @Test
    public void MultipleTest() {
        MultiplyTwoNum multiplyTwoNum = new MultiplyTwoNum();
        for (int i = 1; i < 10; i++)
            for (int j = 1; j < 10; j++)
                assert multiplyTwoNum.multiplyXandY(i, j) == i * j;
    }

}