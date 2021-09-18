package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by PV029500 on 9/26/2016.
 */
public class WordLadder_One {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        Set<String> visitedSet = new HashSet<String>();
        int level = 1;

        Queue<WordLevelPair> queue = new LinkedList<WordLevelPair>();
        queue.add(new WordLevelPair(beginWord, level));
        visitedSet.add(beginWord);
        while (!queue.isEmpty()) {
            int result = dictionaryChecker(visitedSet, queue, wordList, endWord);
            if (result != 0) return result;
        }
        return 0;
    }

    public int dictionaryChecker(Set<String> visitedSet, Queue<WordLevelPair> q, Set<String> wordList, String dest) {

        WordLevelPair pair = q.poll();
        String src = pair.word;
        int level = pair.level;
        for (String s : wordList) {
            if (compatible(s, src) && !visitedSet.contains(s)) {
                if (compatible(src, dest)) return level + 1;
                if (compatible(s, dest)) {
                    return level + 2;
                }
                visitedSet.add(s);
                q.add(new WordLevelPair(s, level + 1));
            }
        }
        return 0;
    }

    public boolean compatible(String s1, String s2) {
        int diff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    public class WordLevelPair {
        public String word;
        public int level;

        WordLevelPair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
