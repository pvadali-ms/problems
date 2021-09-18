package leetcode.medium;

/**
 * Created by PV029500 on 9/12/2016.
 */
public class LongestPalindromicSubstring {

    public class loopWithPointers {
        public String longestPalindrome(String s) {

            if (s.length() == 1) return s;

            int a[] = new int[2];
            int max = 1;
            int currStart = 0, currEnd = 0;
            int end = s.length() - 1;
            int begin = s.length() - 1;
            int length;

            a[0] = begin;
            a[1] = end;

            while (end >= 1) {

                length = s.length() - end;

                a = checkPalindrome(begin, end, length, s, a);
                if (a[1] - a[0] + 1 > max) {
                    max = a[1] - a[0] + 1;
                    currStart = a[0];
                    currEnd = a[1];
                }
                a = checkPalindrome(begin - 1, end, length, s, a);
                if (a[1] - a[0] + 1 > max) {
                    max = a[1] - a[0] + 1;
                    currStart = a[0];
                    currEnd = a[1];
                }
                end--;
                begin = end;


            }

            return s.substring(currStart, currEnd + 1);
        }

        public int[] checkPalindrome(int begin, int end, int length, String s, int a[]) {

            while (length > 0 && begin >= 0 && end <= s.length() - 1) {
                if (s.charAt(begin) == s.charAt(end)) {
                    a[0] = begin;
                    a[1] = end;
                    begin--;
                    end++;
                } else {
                    return a;
                }
                length--;
            }

            return a;
        }
    }

    public class DynamicProgram {
        public String longestPalindrome(String s) {
            int len = s.length();
            int max = 0, begin = 0;
            boolean arr[][] = new boolean[len][len];

            for (int i = 0; i < len; i++) {
                arr[i][i] = true;
            }

            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    arr[i][i + 1] = true;
                    max = 2;
                    begin = i;
                }
            }

            for (int n = 3; n <= len; n++) {
                int j = n - 1;
                for (int i = 0; i <= len - n; i++) {
                    if (s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1]) {
                        arr[i][j] = true;
                        max = j - i + 1;
                        begin = i;
                    }
                    j++;
                }
            }
            return s.substring(begin, begin + max);
        }
    }
}
