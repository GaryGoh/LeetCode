package AWS.LambdaSubset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mgao on 2017/3/16.
 */
public class RandomSubset {

    public List<Integer> getRandomSubset(List<Integer> list){
        Random random = new Random();
        List<Integer> subset = new ArrayList<>();

        for (Integer ele : list){
            if (random.nextBoolean()){
                subset.add(ele);
            }
        }
        return subset;
    }
}
