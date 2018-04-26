package UnitTest.WordPatterTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by mgao on 2017/3/15.
 */
public class WordPatternRuner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(WordPatternTest.class);

        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
