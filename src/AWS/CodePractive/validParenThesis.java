package AWS.CodePractive;

import java.util.TreeMap;

/**
 * Created by mgao on 2017/4/4.
 */
public class validParenThesis {

    public boolean isValid(String s) {
        TreeMap table = new TreeMap<>();
        table.put('(', 0);
        table.put(')', 0);
        table.put('{', 0);
        table.put('}', 0);
        table.put('[', 0);
        table.put(']', 0);
        char[] stringList = s.toCharArray();
        for (char c: stringList){
            if (table.containsKey(c)){
                table.put(c, (int)table.get(c) + 1);
            }
        }
        return table.get('(') == table.get(')') && table.get('[') == table.get(']')  && table.get('{') == table.get('}') ;
    }
}
