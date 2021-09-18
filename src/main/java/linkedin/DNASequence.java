package linkedin;

import java.util.*;

/**
 * Created by PV029500 on 11/27/2016.
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * For example,
 * <p>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class DNASequence {
    //straight forward solution
    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> m = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (m.containsKey(str)) {
                m.put(str, m.get(str) + 1);
            } else {
                m.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > 1)
                result.add(e.getKey());
        }

        return result;
    }

    //using bit manipulation
    public List<String> findRepeatedDnaSequencesBestVoted(String s) {
        Set<Integer> words = new HashSet<Integer>();
        Set<Integer> doubleWords = new HashSet<Integer>();
        List<String> rv = new ArrayList<String>();
        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                //each element in the array is taking two bits, hence left shift twice.
                //the ten letter sequence will take up twenty bits and gives a unique number
                //store the number in set
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if (!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }
}
