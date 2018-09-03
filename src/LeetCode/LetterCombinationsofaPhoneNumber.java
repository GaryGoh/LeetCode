package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinationsofaPhoneNumber {
    String[] map = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList();

        if (digits.length() == 0) {
            resList.add("");
        }
        backTrcking(digits, "", resList, 0);
        return resList;
    }

    private void backTrcking(String digits, String res, List<String> resList, int index) {
        if (index == digits.length()) {
            resList.add(res);
            return;
        }

        char ch = digits.charAt(index);
        int digit = ch - 48;
        for (Character c : map[digit].toCharArray()) {
            backTrcking(digits, res + c, resList, index + 1);
        }
    }

    public static void main(String[] args) {
        String i = "23";
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        System.out.println(l.letterCombinations(i));
    }
}
