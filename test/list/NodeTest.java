package list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void setAndGetData(){

        Node<Integer> newNode = new Node<>();

        newNode.setData(20);

        assertEquals(20, newNode.getData());
    }

    @Test
    void getDataWithoutSettingIt(){
        Node<Integer> newNode = new Node<>();

        assertEquals(null, newNode.getData());
    }

    @Test
    void setDataWithNull(){

        Node<Integer> newNode = new Node<>();

        assertDoesNotThrow(() -> newNode.setData(null));
    }

    @Test
    void setNextAndGetNext(){
        Node<Integer> firstNode = new Node<>();
        Node<Integer> secondNode= new Node<>();
        firstNode.setData(10);
        secondNode.setData(20);

        firstNode.setNext(secondNode);

        assertEquals(20, firstNode.getNext().getData());
    }

    @Test
    void getNextWithoutSettingIt(){
        Node<Integer> newNode = new Node<>();

        assertEquals(null, newNode.getNext());
    }

    @Test
    void setNextWithNull(){

        Node<Integer> newNode = new Node<>();

        assertDoesNotThrow(() -> newNode.setNext(null));
    }


}