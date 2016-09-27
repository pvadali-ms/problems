package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 9/22/2016.
 */
public class NumberOfIslandsTest {

    @Test
    public void testNumOfIslands() throws Exception {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
//        char[][] grid = new char[][]{{'1'},{'0'}};
        System.out.println(n.numOfIslands(grid));
    }
}