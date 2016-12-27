package topics.arrays;

import org.junit.Test;

/**
 * Created by PV029500 on 10/23/2016.
 */
public class SearchInsertPositionTest {

    @Test
    public void searchInsetPosition() {

        int [] arr = new int[]{1, 3, 5};

        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(arr, 2));
    }
}