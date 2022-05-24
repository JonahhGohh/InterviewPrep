package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackMin {
    java.util.Stack<Integer> stack;
    List<Integer> list;
    int size;
    public StackMin() {
        this.stack = new java.util.Stack<>();
        this.list = new ArrayList<>();
        this.size = 0;
    }

    public void push(int i) {
        stack.push(i);
        if (size == 0) {
            list.add(i);
        } else {
            int prevSmallest = list.get(size - 1);
            if (prevSmallest > i) {
                list.add(i);
            } else {
                list.add(prevSmallest);
            }
        }
        size++;
    }

    public int pop() {
        size--;
        return stack.pop();
    }

    public int min() {
        return list.get(size - 1);
    }

}
