package misc;

import java.util.*;

/**
 * Created by PV029500 on 10/17/2016.
 */
public class MaxViaRange {

    public int maxInArray(Map<Integer[], Integer> input) {

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        TreeSet<Integer> s = new TreeSet<Integer>();

        for(Map.Entry<Integer[], Integer> e : input.entrySet()) {
            Integer[] range = e.getKey();
            int rangeLow = range[0];
            int rangeHigh = range[1];
            int value = e.getValue();
            int lowVal = value, highVal = value;
            if (s.contains(rangeLow)) {
                m.put(rangeLow, m.get(rangeLow) + value);
            } else {
                if(s.ceiling(rangeLow) != null) {
                    lowVal += m.get(s.ceiling(rangeLow));
                    m.put(s.ceiling(rangeLow), lowVal);
                    highVal += m.get(s.floor(rangeHigh));
                    m.put(s.floor(rangeHigh), highVal);
                }
                s.add(rangeLow);
                s.add(rangeHigh);
                m.put(rangeLow, lowVal);
                m.put(rangeHigh, highVal);
            }

            if (s.contains(rangeHigh)) {
                m.put(rangeHigh, m.get(rangeHigh) + value);
            } else {
                s.add(rangeHigh);
                m.put(rangeHigh, value);
            }
        }

        int max = 0;
        for(int i : s) {
            max = max > m.get(i) ? max : m.get(i);
        }
        return max;
    }
}
