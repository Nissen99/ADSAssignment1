package token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {

    @Test
    void constructorSetsValeAndGetGetsValue(){
        Operand operand = new Operand(2);

        assertEquals(2, operand.getValue());
    }

    @Test
    void constructorWithNull(){
        Integer integerAsNull = null;
        assertThrows(NullPointerException.class, () -> new Operand(integerAsNull));
    }

}