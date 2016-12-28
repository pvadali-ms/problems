package epi.primitivetypes;

import org.junit.Test;

/**
 * Created by PV029500 on 12/28/2016.
 */
public class ClosestIntegerWithSameWeightsTest {

    @Test
    public void ClosestIntegerWithSameWeights() {
        ClosestIntegerWithSameWeights closestIntegerWithSameWeights = new ClosestIntegerWithSameWeights();
        for (int i = 1; i < 2000; i++) {
            if (closestIntegerWithSameWeights.closestIntegerConstantTime(i) !=
                    closestIntegerWithSameWeights.closestIntegerWithSameWeights(i)) {
                System.out.println(i);
            }
        }
    }
}