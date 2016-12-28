package epi.primitivetypes;

import org.junit.Test;

/**
 * Created by PV029500 on 12/28/2016.
 */
public class ReverseBitsTest {

    @Test
    public void reverseBitsTest() {
        double i = Math.pow(2, 200);
        System.out.println(
//                (i << 24)
//                |
//                        ((i & 0xff00))
//                | ((i >>> 8) & 0xff00)
//                  | (i >>> 24)
                i
        );
    }
}