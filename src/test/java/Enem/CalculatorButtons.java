package Enem;

import org.openqa.selenium.WebElement;

public enum CalculatorButtons {
    ONE("numberOne"),
    TWO("numberTwo"),
    THREE("numberThree"),
    FOUR("numberFour"),
    FIVE("numberFive"),
    SIX("numberSix"),
    SEVEN("numberSeven"),
    EIGHT("numberEight"),
    NINE("numberNine"),
    ZERO("numberZero"),
    ADD("button-add"),
    SUBTRACT("button-subtract"),
    MULTIPLY("button-multiply"),
    DIVIDE("button-divide"),
    DECIMAL("button-decimal"),
    CLEAR("clearAC"),
    CALCULATE("button-calculate"),
    DISPLAYRESULT("display-result");

    private String id;

    CalculatorButtons(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return id;
    }
    }