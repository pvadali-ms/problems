package epi.arrays;

import org.junit.Test;

/**
 * Created by PV029500 on 1/13/2017.
 */
public class ApplyPermutationAgainstArrayTest {

    @Test
    public void applyPermute() {
        ApplyPermutationAgainstArray applyPermutationAgainstArray = new ApplyPermutationAgainstArray();
        int[] arr = new int[]{1, 2, 3, 4};
        int[] permute = new int[]{2, 0, 1, 3};
        System.out.println(applyPermutationAgainstArray.applyPermutations(arr, permute));
    }

}