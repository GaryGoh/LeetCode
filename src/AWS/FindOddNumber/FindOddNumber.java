package AWS.FindOddNumber;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mgao on 2017/3/23.
 */
public class FindOddNumber {
    static int findOddNumber (int[] array){
        int init = 0;

        for (int ele: array){
            init ^= ele;
        }
        return init;
    }

    public static void main(String[] args){
        int[] testArray = {1,1,3,3,3};
        assertEquals(3, findOddNumber(testArray));
    }
}
