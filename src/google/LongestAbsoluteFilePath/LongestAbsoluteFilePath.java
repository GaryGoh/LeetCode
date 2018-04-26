package google.LongestAbsoluteFilePath;

import java.util.Stack;

/**
 * Created by MingqianGao on 7/22/2017.
 */
public class LongestAbsoluteFilePath {

    int maxLen(String s){
        int len = 0;
        char firstChar = s.charAt(0);
            if (firstChar == 't') {
                len += s.length() - 1;
            } else if (firstChar == 'n' ){
            } else {
                len += s.length();
            }
        return len;
    }

    public int lengthLongestPath2(String input) {
        int maxLen = 0;
        String[] subs = input.split("\n");
        int[] levelLen = new int[subs.length+1];

        for (String sub: subs){
            String[] curSub = sub.split("\t");
            int curLevel = curSub.length - 1;
            String cur = curSub[curLevel];
            int len = cur.length() + levelLen[curLevel] + 1;

            if (sub.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            } else {
                levelLen[curLevel+1] = len;
            }
        }
        return maxLen;
    }

    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int result = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int level = countLevel(s);

            // if current directory/file depth is lower that the top directory/file on the stack, pop from stack
            while (stack.size() > level) {
                curLen -= stack.pop();
            }

            // +1 here because a "/" needs to be counted following each diretory
            int len = s.replaceAll("\t", "").length() + 1;
            curLen += len;

            // if s contains ".", we have found a file!
            if (s.contains(".")) {
                result = curLen - 1 > result ? curLen - 1 : result;
            }
            stack.add(len);
        }
        return result;
    }


    public int lengthLongestPath3(String input) {
        // each element in the stack, is representing the path length at current level
        Stack<Integer> stack = new Stack();
        int res = 0;
        String[] inputs = input.split("\n");

        stack.push(0);
        for (String s : inputs) {
            int level = s.lastIndexOf("\t") + 1;

            // deal with backward if done the search.
            while (stack.size() > level + 1) {
                stack.pop();
            }

            // compute the len and push to stack.

            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);

            // if meet the file, then compare with res.
            if (s.contains(".")) {
                res = Math.max(len - 1, res);
            }
        }

        return res;

    }

    private int countLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length() - cur.length();
    }

    public static void main(String[] args){
        String testcase1 = "dir\n\tsubdir1abcdefghjilajsdfkjslkdjflksdjf\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String testcase2 = "dir\n\tsubdir1abcdefghjikjkljlkjlkjlkjkljlkjlkjlk;j\n\tsubdir2\n\t\tfile.ext";
        String testcase3 = "dir\n\tsubdir1\n\t\tfile.ext\n\tsubdir2";
        String testcase4 = "a";

        LongestAbsoluteFilePath l = new LongestAbsoluteFilePath();
        DFS d = new DFS();
        System.out.println(l.lengthLongestPath3(testcase1));
        System.out.println(l.lengthLongestPath3(testcase4));
        System.out.println(l.lengthLongestPath3(testcase3));

        System.out.println(l.lengthLongestPath(testcase1));
        System.out.println(l.lengthLongestPath(testcase2));
        System.out.println(l.lengthLongestPath(testcase3));

        System.out.println(d.lengthLongestPath(testcase1));
        System.out.println(d.lengthLongestPath(testcase2));
        System.out.println(d.lengthLongestPath(testcase3));

    }

}
