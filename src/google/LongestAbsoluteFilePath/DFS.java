package google.LongestAbsoluteFilePath;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by mgao on 2018/3/6.
 */
public class DFS {
    public int lengthLongestPath(String input) {
        int res = Integer.MIN_VALUE;
        StringBuilder longestPath = new StringBuilder();

        // if there is no file in the FS, then return 0.
        if (!input.contains(".")) {
            return 0;
        }

        // Otherwise using DFS to search each file.
        String[] inputArray = input.split("\n");
        LinkedList<String> stack = new LinkedList();    // the stack for DFS.
        stack.push(inputArray[0]);

        while (!stack.isEmpty()) {
            String visitedElement = stack.pop();
            longestPath.append(visitedElement);
            ArrayList<String> children = searchNodeChildren(inputArray, visitedElement);

            // terminate and calculate the path length
            if (children.size() == 0) {
                int len = (visitedElement.contains(".")) ? 0 : replaceSpacesToBackSlash(longestPath.toString()).length();

                if (res < len) {
                    res = len;
                }
            } else {
                for (String c : children) {
                    stack.push(c);
                }
            }
        }
        return res;
    }

    private ArrayList<String> searchNodeChildren(String[] input, String node) {
        int nodeLevel = node.lastIndexOf("\t");
        boolean searchFlag = false;
        ArrayList<String> children = new ArrayList();
        for (String s : input) {
            // reaching up the node, and
            // search its children by looking up the number of \t
            if (s.contains(node)) {
                searchFlag = true;
            }

            // reaching up the children
            else if (searchFlag && s.lastIndexOf("t") == nodeLevel + 1) {
                children.add(s);
            }

            // teaminate searching
            else {
                break;
            }
        }

        return children;
    }

    private String replaceSpacesToBackSlash(String s) {
        return s.replaceFirst("\t", "/").replace("t", "");
    }

}
