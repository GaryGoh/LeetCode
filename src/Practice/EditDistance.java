package Practice;

/**
 * Created by mgao on 2018/3/7.
 */
public class EditDistance {
    public int distance(String s1, String s2, int m, int n) {
        int[][] d = new int[m+1][n+1];	 // 1 more length for checking null.

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // for null -> null, a,d,r, insert operation will apply
                //  to each sub-solution
                if (i == 0) {
                    d[i][j] = j;
                }

                // for null,a,b,c,d,e,f -> null
                else if (j ==0) {
                    d[i][j] = i;
                }

                // if current chars are same, then no operation is applied,
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    d[i][j] = d[i- 1][j - 1];
                }

                else {
                    d[i][j] = 1 + min(d[i][j - 1], d[i - 1][j], d[i - 1][j - 1]);
                }
            }
        }

        return d[m][n];
    }

    private int min(int... ds) {
        int min = Integer.MAX_VALUE;
        for (int d : ds) {
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println( new EditDistance().distance( str1 , str2 , str1.length(), str2.length()) );
    }
}
