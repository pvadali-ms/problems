package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PV029500 on 2/10/2017.
 */
public class AllPermutations {

    public static List<String> result = new ArrayList<String>();

    public static void main(String args[]) {

        String s = "abc";
        recurse("", s);
        recurseWithCaps("", s);
        for(String str : result)
            System.out.println(str);
    }

    public static void recurseWithCaps(String first, String rest) {
        for (int i = 0; i < rest.length(); i++) {
            String s = (first + rest.charAt(i)).toUpperCase() + rest.substring(0, i) + rest.substring(i + 1, rest.length());
            recurse("", s);
            recurseWithCaps((first + rest.charAt(i)).toUpperCase(), rest.substring(0, i) + rest.substring(i + 1, rest.length()));
        }
    }

    public static void recurse(String first, String rest) {
        if (rest.equals(""))
            result.add(first);

        for (int i = 0; i < rest.length(); i++) {
            recurse(first + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1, rest.length()));
        }
    }
}


