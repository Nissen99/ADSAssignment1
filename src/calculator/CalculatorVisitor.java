package calculator;

import list.LinkedList;
import list.LinkedStack;
import token.Operand;
import token.Operation;
import token.Operator;
import token.Token;

public class CalculatorVisitor implements Visitor, Calculator {


    LinkedStack<Token> tokenStack = new LinkedStack<>();



    private void pushOperand(Operand operand) {
        tokenStack.push(operand);

    }

    private void performOperation(Operator operator) throws MalformedExpressionExeption {
        try {
            Operand secondOperand = (Operand) tokenStack.pop();
            Operand firstOperand = (Operand) tokenStack.pop();
            int result = 0;


            if (operator.getOperation().equals(Operation.PLUS)) {
                result += firstOperand.getValue() + secondOperand.getValue();
            }
            else if (operator.getOperation().equals(Operation.MINUS)) {
                result += firstOperand.getValue() - secondOperand.getValue();
            }
            else if (operator.getOperation().equals(Operation.MULTIPLY)) {
                result += firstOperand.getValue() * secondOperand.getValue();
            }
            else if (operator.getOperation().equals(Operation.DIVISION)) {
                result += firstOperand.getValue() / secondOperand.getValue();
            }

            tokenStack.push(new Operand(result));


        } catch (ClassCastException e) {
            throw new MalformedExpressionExeption();
        }

    }


    @Override
    public int getResult() throws MalformedExpressionExeption {
        int result;
        try{
            result = ((Operand) tokenStack.pop()).getValue();

        }catch (ClassCastException e){
            throw new MalformedExpressionExeption();
        }

        if (!tokenStack.isEmpty()){
            throw new MalformedExpressionExeption();
        }

        return result;
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {

            performOperation(operator);

        } catch (MalformedExpressionExeption e) {
            e.printStackTrace();
        }
    }
}
