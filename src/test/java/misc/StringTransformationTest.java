package misc;

import org.junit.Test;

/**
 * Created by PV029500 on 1/30/2017.
 */
public class StringTransformationTest {

    @Test
    public void StringTransformationTest() {
        StringTransformation st = new StringTransformation();
        String[] arr = new String[]{"aede", "abcd", "abce", "abde", "abef"};
        System.out.println(st.isTransformationPossible(arr));
    }

}