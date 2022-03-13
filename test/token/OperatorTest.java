package token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void constructorSetsValeAndGetGetsValue(){
        Operator operator = new Operator(Operation.MULTIPLY);

        assertEquals(Operation.MULTIPLY, operator.getOperation());
    }


}