package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mgao on 2018/4/4.
 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        if (people.length == 0) { return new int[0][];}
        // if height is equal, then look at the num
        Arrays.sort(people, (p1, p2) -> (p1[0] == p2[0])? p1[1] - p2[1] : p2[0] - p1[0]);
        for (int[] i : people) {
            System.out.println(i[0] + "," + i[1]);
        }

        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionbyHeight q = new QueueReconstructionbyHeight();
        int[][] t = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int [][] res = q.reconstructQueue(t);
        System.out.println("*************************");

        for (int[] i : res) {
            System.out.println(i[0] + "," + i[1]);
        }

    }
}
