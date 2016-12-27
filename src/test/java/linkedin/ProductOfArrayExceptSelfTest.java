package linkedin;

import org.junit.Test;

/**
 * Created by PV029500 on 11/27/2016.
 */
public class ProductOfArrayExceptSelfTest {

    @Test
    public void ProductArrayTest() {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        productOfArrayExceptSelf.productExceptSelf(arr);
    }

}