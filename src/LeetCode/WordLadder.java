package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log","cog"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // check if wordList contains endWord.
        if (!wordList.contains(endWord)) {return 0;}
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }

        HashMap<String, Integer> map = new HashMap();
        ArrayDeque<String> queue = new ArrayDeque();
        ListIterator<String> itr;
        int curLevel;
        map.put(beginWord, 1);
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String e = queue.poll();
            curLevel = map.get(e);
            if (e.equals(endWord)) {
                return map.get(e);
            }
            itr = wordList.listIterator();
            while (itr.hasNext()) {
                String s = itr.next();
                if (wordDistance(e.toCharArray(), s.toCharArray()) == 1) {
                    queue.offer(s);
                    map.put(s, curLevel + 1);
                    itr.remove();
                }
            }
        }
        return 0;
    }

    private int wordDistance(char[] beginWord, char[] endWord) {
        int res = 0;
        for (int i = 0; i < beginWord.length; i ++) {
            res += (beginWord[i] == endWord[i])? 0: 1;
        }
        return res;
    }

    private int dfsSearch(String cureentWord, String endWord, List<String> wordList, int res) {
        List<String> oneDistanceList = wordList.stream().filter(e -> wordDistance(cureentWord.toCharArray(), e.toCharArray()) == 1).collect(Collectors.toList());
        if (oneDistanceList.contains(endWord)) {
            return 2;
        } else if (!oneDistanceList.contains(endWord) && oneDistanceList.isEmpty()) {
            return 0;
        } else {
            wordList.removeAll(oneDistanceList);
            for (String s : oneDistanceList) {
                res = dfsSearch(s, endWord, wordList, res) + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        String b = "a";
        String e = "c";
        String[] sa = {"a","b", "c"};
        List<String> l1 = new ArrayList<>();
        for (String s : sa) {
            l1.add(s);
        }
//        System.out.println(l1);
        System.out.println(w.ladderLength(b, e, l1));
    }
}
