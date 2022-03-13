import calculator.CalculatorVisitor;
import calculator.MalformedExpressionExeption;
import token.Token;

import java.util.ArrayList;

public class Client {



    public int evaluateExpression(ArrayList<Token> tokenList) throws MalformedExpressionExeption {

        CalculatorVisitor calculatorVisitor = new CalculatorVisitor();


        for (Token token : tokenList) {
            token.accept(calculatorVisitor);
        }


        return calculatorVisitor.getResult();



    }
}
