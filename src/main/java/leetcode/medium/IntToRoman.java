package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PV029500 on 9/12/2016.
 */
public class IntToRoman {

    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<Integer, String>();
        fill(romanMap);

        String s = "";
        while (num > 0) {
            while (num > 1000) {
                if (num > 100) {
                    s += romanMap.get(1000);
                    num /= 1000;
                }

            }
            while (num > 500) {
                s += romanMap.get(500);
                num /= 500;
            }
        }
        return "";
    }

    public void fill(Map<Integer, String> m) {
        m.put(1, "I");
        m.put(5, "V");
        m.put(10, "X");
        m.put(50, "L");
        m.put(100, "C");
        m.put(500, "D");
        m.put(1000, "M");
    }
}
