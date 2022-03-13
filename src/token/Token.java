package token;

import calculator.CalculatorVisitor;

public abstract class Token {

    private CalculatorVisitor visitor;


    public abstract void accept(CalculatorVisitor visitor);


}
