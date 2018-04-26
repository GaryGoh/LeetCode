package AWS.CodePractive;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by mgao on 2017/3/23.
 */
public class ReverseLinkedList {
//    static LinkedList revserLinkedList(LinkedList list){
//        System.out.print(reverserLinkedList((int)list.getFirst(), list.iterator()));
//        return;
//    }

    static int reverserLinkedList(int currentNode, Iterator list){
        if (list.hasNext()) {
           return reverserLinkedList((int)list.next(), list);
        } else {
           return currentNode;
        }
    }

    public static void main(String[] args){
//        int[] testArray = {1,2,3,4,5,6,7,7};
        LinkedList testList = new LinkedList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
//        revserLinkedList(testList);
    }
}
