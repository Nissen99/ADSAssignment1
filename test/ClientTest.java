import calculator.MalformedExpressionExeption;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import token.Operand;
import token.Operation;
import token.Operator;
import token.Token;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * For denne test bruges https://www.mathblog.dk/tools/infix-postfix-converter/
 * Denne converter bliver brugt til at finde infix til vores postfix.
 */


class ClientTest {


    Client client;

    @BeforeEach
    void setUp(){
        client = new Client();
    }



    @Test
    void simpleAddingExpression() throws MalformedExpressionExeption {
        Token token1 = new Operand(1);
        Token token2 = new Operand(2);
        Token token3 = new Operand(3);
        Token token4 = new Operand(4);

        Token tokenPlus = new Operator(Operation.PLUS);

        ArrayList<Token> allTokens = new ArrayList<>();

        allTokens.add(token1);
        allTokens.add(token2);
        allTokens.add(token3);
        allTokens.add(token4);
        allTokens.add(tokenPlus);
        allTokens.add(tokenPlus);
        allTokens.add(tokenPlus);


        assertEquals(1+2+3+4, client.evaluateExpression(allTokens));

    }

    @Test
    void expressionWhereOrderMatters() throws MalformedExpressionExeption {
        // Here I will be using (3 - 7)/(2 - 1) as an example
        // After postfix converter it looks like this 3 7 - 2 1 - /

        Token token1 = new Operand(3);
        Token token2 = new Operand(7);
        Token token3 = new Operator(Operation.MINUS);
        Token token4 = new Operand(2);
        Token token5 = new Operand(1);
        Token token6 = new Operator(Operation.MINUS);
        Token token7 = new Operator(Operation.DIVISION);

        ArrayList<Token> allTokens = new ArrayList<>();

        allTokens.add(token1);
        allTokens.add(token2);
        allTokens.add(token3);
        allTokens.add(token4);
        allTokens.add(token5);
        allTokens.add(token6);
        allTokens.add(token7);

        assertEquals((3-7)/(2-1), client.evaluateExpression(allTokens));

    }

    @Test
    void expressionNotCompleteThrowsException(){

        Token token1 = new Operand(3);
        Token token2 = new Operand(7);
        Token token3 = new Operator(Operation.MINUS);
        Token token4 = new Operand(2);

        ArrayList<Token> allTokens = new ArrayList<>();

        allTokens.add(token1);
        allTokens.add(token2);
        allTokens.add(token3);
        allTokens.add(token4);

        assertThrows(MalformedExpressionExeption.class, () -> client.evaluateExpression(allTokens));

    }

    @Test
    void emptyListThrowsException(){

        ArrayList<Token> emptyList = new ArrayList<>();

        assertThrows(MalformedExpressionExeption.class, () -> client.evaluateExpression(emptyList));
    }

    @Test
    void nullListThrowsException(){

        assertThrows(MalformedExpressionExeption.class, () -> client.evaluateExpression(null));
    }

}