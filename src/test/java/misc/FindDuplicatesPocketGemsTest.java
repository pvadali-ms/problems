package misc;

import org.junit.Test;

/**
 * Created by PV029500 on 10/25/2016.
 */
public class FindDuplicatesPocketGemsTest {

    @Test
    public void findDup() {
        int[] nums = new int[]{4, 3, 2, 6, 3, 2};
        FindDuplicatesPocketGems findDuplicatesPocketGems = new FindDuplicatesPocketGems();
        System.out.println(findDuplicatesPocketGems.findDuplicates(nums));
    }

}