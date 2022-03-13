package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Til Test bruges Integers, det er valgt da de er nemme at forholde sig til
 */

class LinkedListTest {


    LinkedList<Integer> list;

    @BeforeEach
    void setUp(){
        list = new LinkedList<>();
    }



    @Test
    void testAddingAndRemoveInRightOrder() throws EmptyListException {


        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);

        assertEquals(3, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(1, list.removeFirst());


    }


    /**
     * Her tilføjer den en Node, men dataen i Noden er null, kan være der skal gøres noget ved det.
     */
    @Test
    void testTryingToAddNullToList() throws EmptyListException {

        list.addToFront(null);
        list.removeFirst();

    }

    @Test
    void testIsEmptyWhenFirstCreated(){

        assertEquals(true, list.isEmpty());
    }

    @Test
    void testIsEmptyWhenRemovingFromList() throws EmptyListException {
        list.addToFront(20);
        list.removeFirst();
        assertEquals(true, list.isEmpty());
    }


    @Test
    void testIsEmptyWhenListNotEmpty(){
        list.addToFront(20);

        assertEquals(false, list.isEmpty());
    }

    @Test
    void testSizeStartsAt0(){
        assertEquals(0, list.size());
    }

    @Test
    void testSizeGoesUpWhenAddingToList(){

        int initialSize = list.size();

        list.addToFront(20);

        int afterAddingSize = list.size();

        assertEquals(initialSize+1, afterAddingSize);
    }

    @Test
    void sizeGoesDownWhenRemoving() throws EmptyListException {

        list.addToFront(20);
        int initialSize = list.size();

        list.removeFirst();

        int afterRemovingSize = list.size();

        assertEquals(initialSize-1, afterRemovingSize);
    }

    @Test
    void removingFromEmptyListThrowsException(){

        assertThrows(EmptyListException.class, () -> list.removeFirst());

    }













}