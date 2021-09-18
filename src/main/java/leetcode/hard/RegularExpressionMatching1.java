package leetcode.hard;

/**
 * Created by PV029500 on 9/10/2016.
 */
public class RegularExpressionMatching1 {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return false;

        boolean[][] a = new boolean[p.length() + 1][s.length() + 1];
        fill(a);

        int i = 0, curr = 0, j = curr;
        boolean changed = false;

        while (i < p.length()) {
            j = curr;
            if (j > s.length()) return false;
            while (j < s.length()) {
                if (i != p.length() - 1 && p.charAt(i + 1) == '*') {
                    if (p.charAt(i) == '.') {
                        a[i + 1][j + 1] = a[i][j] || a[i][j - 1];
                    } else {
                        a[i + 1][j + 1] = (a[i][j] || a[i][j - 1]) && p.charAt(i) == s.charAt(j);
                    }
                    a[i + 2][j + 1] = a[i + 1][j + 1];
                } else if (p.charAt(i) == '.') {
                    a[i + 1][j + 1] = a[i][j];
                    if (!changed) {
                        curr = j + 1;
                        changed = true;
                    }
                } else {
                    a[i + 1][j + 1] = a[i][j] && p.charAt(i) == s.charAt(j);
                    if (p.charAt(i) == s.charAt(j) && !changed) {
                        curr = j + 1;
                        changed = true;
                    }
                }
                j++;
            }
            changed = false;
            i = i + 1 != p.length() && p.charAt(i + 1) == '*' ? i + 2 : i + 1;
        }
        return a[p.length()][s.length()];
    }

    public void fill(boolean a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = i == 0 || j == 0;
            }
        }
    }
}
