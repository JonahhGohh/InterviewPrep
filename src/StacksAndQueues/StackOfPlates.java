package StacksAndQueues;


import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class StackOfPlates<T> {
    int size;
    List<LinkedList<T>> outerList;

    public StackOfPlates(int size) {
        this.size = size;
        outerList = new ArrayList<>();
    }

    public void push(T element) {
        if (outerList.size() == 0) {
            outerList.add(new LinkedList<>());
        }
        LinkedList<T> currentStack = getCurrentStack();
        int currStackSize = currentStack.size();
        if (currStackSize < size) {
            currentStack.push(element);
        } else {
            LinkedList<T> newStack = new LinkedList<>();
            newStack.push(element);
            outerList.add(newStack);
        }
    }

    public T pop() {
        LinkedList<T> currentStack = getCurrentStack();
        if (currentStack == null) {
            return null;
        }
        T element = currentStack.pop();
        int currStackSize = currentStack.size();
        if (currStackSize == 0) {
            outerList.remove(outerList.size() - 1);
        }
        return element;
    }

    public int size() {
        return outerList.size();
    }

    public T popAt(int index) {
        if (index >= outerList.size()) {
            return null;
        } else {
            // for linkedlist at index pos and upwards,
            // link the top element to the bottom of the other linkedlist
            // :)
        }
        return null;
    }

    private LinkedList<T> getCurrentStack() {
        if (outerList.size() == 0) {
            return null;
        }
        return outerList.get(outerList.size() - 1);
    }
}
