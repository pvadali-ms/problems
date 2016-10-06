package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 10/6/2016.
 */
public class SearchMatrixTest {

    @Test
    public void searchMatrix() {
        SearchMatrix searchMatrix = new SearchMatrix();

        int[][] matrix = new int[][]{{-1, 3}};

        System.out.println(searchMatrix.searchMatrix(matrix, -1));
    }

}