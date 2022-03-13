package list;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(T element) {
        System.out.println("Push");
        linkedList.addToFront(element);

    }

    @Override
    public T pop() throws EmptyStackException {
        System.out.println("Pop");

        try {
            return linkedList.removeFirst();
        }
        catch (EmptyListException e) {
            throw new EmptyStackException();
        }
    }
}
