package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 10/14/2016.
 */
public class PartitionEqualSubsetTest {

    @Test
    public void testPartitionEqualSubset() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        PartitionEqualSubset partitionEqualSubset = new PartitionEqualSubset();

        System.out.println(partitionEqualSubset.canPartition(nums));

    }

}