package oop.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<Object> {

    int size = 0;
    List<Object> stackList = new ArrayList<>();

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object a) {
        stackList.add(a);
        size++;
    }

    public Object pop() {
        size--;
        Object peek = stackList.get(size);
        return peek;
    }

    public Object peek() {
        return stackList.get(size-1);
    }
}
