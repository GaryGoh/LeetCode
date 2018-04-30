package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * <p>
 * Machine 1 (sender) has the function:
 * <p>
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 * So Machine 1 does:
 * <p>
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * <p>
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * <p>
 * Implement the encode and decode methods.
 * <p>
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */

public class EncodeandDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s: strs) {
            res.append(s.length()).append("/").append(s);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList();
        int i = 0;
        while (i < s.length()) {
            int separator = s.indexOf("/", i);
            int length = s.charAt(separator - 1) - 48;
            res.add(s.substring(separator + 1, separator + length + 1));
            i = separator + length + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "123";
        List<String> t = new ArrayList();
        EncodeandDecodeStrings e = new EncodeandDecodeStrings();
//        t.add(s1);
//        t.add(s2);
        String[] s = {"`H","HlJfc&48}:.#4?wQ;q",">wQvyT.%J].z4o;}t`r","icEM?,5pldc","`U#"," yS","2A6ukFJl","G","kK+o|Oxe!y{u"};
        t = Arrays.asList(s);

        String res = e.encode(t);
        List<String> dres = e.decode(res);
        System.out.println(res);
        System.out.println(dres);
        System.out.println(dres.equals(t));
    }
}
