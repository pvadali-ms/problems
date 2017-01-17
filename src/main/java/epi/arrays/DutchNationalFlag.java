package epi.arrays;

/**
 * Created by PV029500 on 1/9/2017.
 */
public class DutchNationalFlag {

    public void ductchNationalFlag(int[] arr) {
        int second = arr.length - 1;
        int zero = 0;
        for (int i = 0; i <= second; i++) {
            while (arr[i] == 2 && i < second)
                //swap(arr[i], arr[second--]);
            ;
            while (arr[i] == 0 && i > zero)
                //swap(arr[i], arr[zero++]);
            ;
        }
    }
}
