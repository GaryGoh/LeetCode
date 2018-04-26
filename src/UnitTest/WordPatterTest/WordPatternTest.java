package UnitTest.WordPatterTest;

import AWS.WordPattern.WordPattern;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mgao on 2017/3/15.
 */
public class WordPatternTest {

    @Test
    public void patterOne(){
        String pattern = "abba";
        String word = "dog cat cat dog";
        WordPattern wp = new WordPattern();
        assertEquals(true, wp.wordPattern(pattern, word));
    }

    @Test
    public void patterTwo(){
        String pattern = "abba";
        String word = "dog cat cat fish";
        WordPattern wp = new WordPattern();
        assertEquals(false, wp.wordPattern(pattern, word));
    }

    @Test
    public void patterThree(){
        String pattern = "aaaa";
        String word = "dog cat cat dog";
        WordPattern wp = new WordPattern();
        assertEquals(false, wp.wordPattern(pattern, word));
    }

    @Test
    public void patterFour(){
        String pattern = "abba";
        String word = "dog dog dog dog";
        WordPattern wp = new WordPattern();
        assertEquals(false, wp.wordPattern(pattern, word));
    }
}
