package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.


 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 1. height
 2. number of person higher than it.

 sort by number of person, and if equal, compare with height by ASC.

 insert p[1] = 0;
    sort those by height;
 if (height1 < height2 ) && (checkNum(height) = p[1])

1. insert heighest first, as if insert low before a high, the number of k will be messsy.
 2. the k is representing the possition of each element, as it represent how many people higher than it, so after inserting the high people, their must be a unique position for the new people, ordered by k.

 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();

        if (people.length == 0) {return null;}
        Arrays.sort(people, (p1, p2) -> (p1[0] == p2[0])? p1[1] - p2[1]: p2[0] - p1[0]);
        System.out.println(Arrays.deepToString(people));
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionbyHeight q = new QueueReconstructionbyHeight();
        int[][] t = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(Arrays.deepToString(q.reconstructQueue(t)));
    }
}
