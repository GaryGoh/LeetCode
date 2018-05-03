package google.MinStack;

import java.util.Stack;

//import static org.junit.Assert.assertEquals;

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * <p>
 * Created by mgao on 2018/3/7.
 */

public class MinStack {
    private Stack<Integer> stack;
    private int minElement;

    public MinStack() {
        stack = new Stack();
        minElement = Integer.MAX_VALUE;
    }

    // push new element and check if less than minElement,
    // and update it if so.
    // push the sec min again, in case pop the min and loss the last minElement.
    public void push(int x) {
        stack.push(minElement);

        if (x < minElement) {
            minElement = x;
        }
        stack.push(x);
    }

    // pop the top element and check if this is the minElement,
    // and update the minElement for the second min.
    // pop twice if top is minElement;
    public int pop() {
        int res;
            res = stack.pop();
            minElement = stack.pop();
        return res;
    }

    // peek the stack.
    public int top() {
        return stack.peek();
    }

    // return minElement.
    public int getMin() {
        return minElement;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
//        assertEquals(0, minStack.getMin());
        minStack.pop();
//        assertEquals(1, minStack.top());
//        assertEquals(0, minStack.getMin());
        System.out.print("done");
    }
}
