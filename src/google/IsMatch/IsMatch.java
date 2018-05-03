package google.IsMatch;

//import static org.junit.Assert.assertEquals;

/**
 * Created by mgao on 2018/3/8.
 */
public class IsMatch {
    /**
     *  Using dynamic programming with 2D array to resolve this question.
     *
     *  @param s The string that used to be match.
     *  @param p The pattern string that used to match s.
     */
    public boolean isMatch (String s, String p) {
        // the first index is to store the null.
        boolean[][] dp = new boolean[s.length() + 1][ p.length() + 1];
        dp[0][0] = true;

        // initialize the first row. 
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= p.length(); j ++) {
                // if s[i - 1] match p[j - 1], including p[j - 1] == "."
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else if (p.charAt(j - 1) == '*') {

                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        IsMatch t = new IsMatch();
//        assertEquals(true, t.isMatch("aab", "c*a*b"));
//        assertEquals(true, t.isMatch("caab", "c*a*b"));
//        assertEquals(false, t.isMatch("aa", "a"));
//        assertEquals(true, t.isMatch("aa", "aa"));
//        assertEquals(true, t.isMatch("aa", "a*"));
//        assertEquals(true, t.isMatch("aa", "a."));
//        assertEquals(true, t.isMatch("ab", ".*"));
//        assertEquals(true, t.isMatch("aa", ".*"));
//        assertEquals(true, t.isMatch("aasdf", "aasdf.*"));

    }
}
