package google.Interview.RemoveDuplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mgao on 2018/3/23.
 */
public class RemoveDuplicates<T> {
    public List<T> removeDuplicate(List<T> list) {
        return new ArrayList(new HashSet(list));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add(new String("b"));
        list.add(new String("b"));
        list.add("c");
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDuplicate(list));
    }
}
