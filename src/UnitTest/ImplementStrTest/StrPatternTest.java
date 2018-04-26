package UnitTest.ImplementStrTest;

import AWS.ImplementStr.strStr;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mgao on 2017/3/20.
 */
public class StrPatternTest {

    @Test
    public void patternOne(){
        String haystack = "abcdefg";
        String needle = "cde";
        strStr str = new strStr();
        assertEquals(2, str.strip(haystack, needle));
    }

    @Test
    public void patternTwo(){
        String haystack = "abcefg";
        String needle = "bcde";
        strStr str = new strStr();
        assertEquals(-1, str.strip(haystack, needle));
    }

    @Test
    public void patternThree(){
        String haystack = "abcd";
        String needle = "bcde";
        strStr str = new strStr();
        assertEquals(-1, str.strip(haystack, needle));
    }
}
