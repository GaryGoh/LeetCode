package google.RemoveDuplicateLetters;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mgao on 2018/3/27.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        TreeSet<Character> treeset = new TreeSet();
        for (char c : s.toCharArray()) {
            treeset.add(new Character(c));
        }
        return treeset.stream().map(c -> c.toString()).reduce("", String::concat);
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters t = new RemoveDuplicateLetters();
        System.out.println(t.removeDuplicateLetters("bcabc"));
    }
}
