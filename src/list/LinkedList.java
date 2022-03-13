package list;

public class LinkedList<T> implements List<T>{

    private Node<T> head;
    private int size;


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
       return size;
    }

    @Override
    public void addToFront(T data) {

    Node<T> newNode = new Node();
    newNode.setData(data);
    newNode.setNext(head);

    head = newNode;
    size++;


    }

    @Override
    public T removeFirst() throws EmptyListException {
        if (size == 0){
            throw new EmptyListException();
        }
        T oldHeadData = head.getData();
        head = head.getNext();
        size--;

        return oldHeadData;

    }
}
