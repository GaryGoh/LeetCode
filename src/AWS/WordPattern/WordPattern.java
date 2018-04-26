package AWS.WordPattern;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by mgao on 2017/3/15.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strEum = str.split(" ");
        HashMap index = new HashMap<>();


        if ((pattern.length() != strEum.length)) {
            return false;
        } else {

            for (int eumIndex = 0; eumIndex < strEum.length; eumIndex++) {
                if (!Objects.equals(index.put(pattern.charAt(eumIndex), eumIndex),(index.put(strEum[eumIndex], eumIndex)))) {
                    return false;
                }
            }
            return true;
        }
    }
}

