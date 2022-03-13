package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {


    LinkedStack<Integer> stack;

    @BeforeEach
    void setUp(){
        stack = new LinkedStack<>();
    }



    @Test
    void pushToStackAndPopFromStackInRightOrder() {


        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

    }


    /**
     * Her tilføjer vi null og der sker ikke noget ved det, kan være der skal gøres noget ved det.
     */
    @Test
    void tryingToAddNullToStack() {

        assertDoesNotThrow(() -> stack.push(null));
        assertDoesNotThrow(() ->stack.pop());

    }

    @Test
    void isEmptyWhenFirstCreated(){

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void isEmptyWhenRemovingFromStack() {
        stack.push(20);
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }


    @Test
    void isEmptyWhenStackNotEmpty(){
        stack.push(20);

        assertEquals(false, stack.isEmpty());
    }


    @Test
    void removingFromEmptyStackThrowsException(){

        assertThrows(EmptyStackException.class, () -> stack.pop());

    }



}