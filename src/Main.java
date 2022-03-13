import calculator.MalformedExpressionExeption;
import token.Operand;
import token.Operation;
import token.Operator;
import token.Token;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MalformedExpressionExeption {


        ArrayList<Token> tokenList = new ArrayList<>();


        Token token = new Operand(10);
        Token token2 = new Operand(2);
        Token token3 = new Operand(3);
        Token token4 = new Operand(4);
        Token token5 = new Operand(5);

        Token token6 = new Operator(Operation.PLUS);
        Token token7 = new Operator(Operation.MINUS);
        Token token8 = new Operator(Operation.MULTIPLY);
        Token token9 = new Operator(Operation.DIVISION);

        tokenList.add(token);
        tokenList.add(token2);
        tokenList.add(token6);
        tokenList.add(token3);
        tokenList.add(token4);
        tokenList.add(token7);
        tokenList.add(token5);
        tokenList.add(token8);
        tokenList.add(token9);



        Client client = new Client();

        int result = client.evaluateExpression(tokenList);

        System.out.println("RESULT: " + result);

    }
}
