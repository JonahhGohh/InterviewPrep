package StacksAndQueues;

import java.util.Stack;

public class SortStack<T extends Comparable> {
    Stack<T> stack;

    public SortStack() {
        stack = new Stack<>();
    }

    public void push(T item) {
        if (stack.size() == 0) {
            stack.push(item);
            return;
        }
        Stack<T> tempStack = new Stack<>();
        T topValue = stack.peek();
        while (topValue.compareTo(item) < 0 && stack.size() > 0)  {
             tempStack.push(stack.pop());
             if (stack.size() > 0) {
                 topValue = stack.peek();
             }
        }
        stack.push(item);
        while (tempStack.size() > 0) {
            stack.push(tempStack.pop());
        }
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
