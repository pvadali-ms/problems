package linkedin;

import leetcode.utility.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 11/26/2016.
 */
public class BSTIteratorTest {

    @Test
    public void BSTTest() {
        TreeNode treeNode = new TreeNode(30);
        treeNode.left = new TreeNode(24);
        treeNode.right = new TreeNode(34);
        BSTIterator bstIterator = new BSTIterator(treeNode);
        while (bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }

    public List<Integer> reverseFib(int first, int second) {

        int temp;
        List<Integer> result = new ArrayList<Integer>();
        result.add(first);
        result.add(second);
        while (second != 0) {
            temp = second;
            second = first - second;
            first = temp;
            result.add(second);
        }
        return result;
    }

    void Reformat(String[] numbers) {
        int buf = 4, count;
        for (int i = 0; i < numbers.length; i++) {
            char[] temp = new char[12];
            if (numbers[i].length() == 10) {
                for (int j = 0, k = 0; j < 12; j++) {
                    if (j == 3 || j == 7) {
                        temp[j] = '-';
                    } else {
                        temp[j] = numbers[i].charAt(k);
                        k++;
                    }
                }
            } else {
                for (int m = 0; m < 12; m++) {
                    temp[m] = numbers[i].charAt(m);
                }
            }
            count = 0;
            while(count < 3) {
                swap(temp, count, count + buf);
                count++;
            }
            numbers[i] = String.valueOf(temp);
        }
    }

    void swap(char[] arr, int i, int j) {
        char c = arr[j];
        arr[j] = arr[i];
        arr[i] = c;
    }
}