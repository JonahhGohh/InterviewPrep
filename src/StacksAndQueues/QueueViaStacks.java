package StacksAndQueues;

import java.util.Stack;

public class QueueViaStacks<T> {
    Stack<T> newestStack;
    Stack<T> oldestStack;

    public QueueViaStacks() {
        newestStack = new Stack<>();
        oldestStack = new Stack<>();
    }

    public void push(T item) {
        newestStack.push(item);
    }

    public T pop() {
        shiftStacks();
        return oldestStack.pop();
    }

    public T peek() {
        shiftStacks();
        return oldestStack.peek();
    }

    private void shiftStacks() {
        if (oldestStack.size() == 0) {
            while (newestStack.size() > 0) {
                oldestStack.push(newestStack.pop());
            }
        }
    }
}
