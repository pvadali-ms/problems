package linkedin;

/**
 * Created by PV029500 on 11/27/2016.
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1people know him/her but he/she does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * <p>
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class FindCelebrity {

    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            //if a candidate knows someone, he is not a celeb. If a candidate doesn't know someone, for example 2 doesn't know 3 but knows
            //4, candidate is set to 4. However, none from 1..3 are celeb because celeb is known by everyone.
            //The place at which candidate stops gettting updated is the celeb. To verify this, as there can be no celeb at all,
            //loop through once again and check for if (i != myself(cand) && if cand knows i or i doesn't know cand, return -1
            if (knows(candidate, i))
                candidate = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    //this is an api
    public boolean knows(int i, int j) {
        return true;
    }
}
