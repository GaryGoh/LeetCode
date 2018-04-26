package AWS.ImplementStr;

/**
 * Created by mgao on 2017/3/20.
 */
public class strStr {
    public int strip(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (haystackLen < needleLen){
            return -1;
        }

        int offset = haystackLen - needleLen;
        for (int i = 0; i < offset; i ++){
            if (haystack.substring(i, i+needleLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
