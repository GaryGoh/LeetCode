package AWS.CodePractive;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by mgao on 2017/4/4.
 */
public class RandomizedSet {
    private int length = 1;
    private HashSet randomSet;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.randomSet = new HashSet();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (randomSet.contains(val)){
            return false;
        }

        try{
            randomSet.add(val);
            length++;
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!randomSet.contains(val)){
            return false;
        }

        try{
            randomSet.remove(val);
            length--;
            return true;
        } catch(Exception ex){
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIndex = rand.nextInt(length);
        int result = Integer.MIN_VALUE;
        Iterator<Integer> randomSetIter = randomSet.iterator();

        while(randomSetIter.hasNext() && randIndex >= 0){
            randIndex--;
            result = randomSetIter.next().intValue();
        }
        return result;
    }
}
