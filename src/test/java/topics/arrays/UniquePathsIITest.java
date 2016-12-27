package topics.arrays;

import org.junit.Test;

/**
 * Created by PV029500 on 10/24/2016.
 */
public class UniquePathsIITest {

    @Test
    public void uniquePathTest() {
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();

        System.out.println(uniquePathsII.uniquePathsWithObstacles(matrix));

    }

}