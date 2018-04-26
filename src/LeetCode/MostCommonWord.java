package LeetCode;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 Example:
 Input:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 Output: "ball"
 Explanation:
 "hit" occurs 3 times, but it is a banned word.
 "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 Note that words in the paragraph are not case sensitive,
 that punctuation is ignored (even if adjacent to words, such as "ball,"),
 and that "hit" isn't the answer even though it occurs more because it is banned.

 1. String.split() by regex of filtering any non-character words.
 2. map and cal each occur, store at TreeMap.
 3. looping treeMap and check the banned words, to have the res;
 */

/**
 *  1. Java Regex.
 *  2. Map sort, sorting the entries by value.
 *      if want to insert and sort, use PriorityQueue
 *  3. Entry value, compareTo, instead of -.
 */

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph.isEmpty()) {
            return null;
        }

        // Map each words with their occurrence.
        HashMap<String, Integer> map = new HashMap();
        String[] paraList = paragraph.toLowerCase().split("(\\W+)");
        List<String> list = Stream.of(paraList).map(s -> s.replaceAll("\\s+", "")).collect(Collectors.toList());
        List<String> bannedList = Stream.of(banned).collect(Collectors.toList());
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        // Sort and pick the result.
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<String, Integer> entry : entryList) {
            if (!bannedList.contains(entry.getKey())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MostCommonWord m = new MostCommonWord();
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(m.mostCommonWord(s, banned));
    }
}
