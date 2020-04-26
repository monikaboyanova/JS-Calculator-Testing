package CalculatePageObject;

import Enem.CalculatorButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.math.BigDecimal;

public class CalculatorPageObject {
    public WebDriver driver;


    //Constructor
    public CalculatorPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //Click Method
    public void clickOnButton(CalculatorButtons buttons) {
        WebElement element = driver.findElement(By.id(buttons.toString()));
        //assert
        Assert.assertNotNull(element);
        element.click();
        // cpo.clickOnButton(CalculatorButtons.ONE);
    }

    //method that return result
    public Double getResult() {
        clickOnButton(CalculatorButtons.CALCULATE);
        WebElement element = driver.findElement(By.id("display-result"));
        Assert.assertNotNull(element);
        return Double.parseDouble(element.getText());
    }

    public Integer getResultInt() {
        clickOnButton(CalculatorButtons.CALCULATE);
        WebElement element = driver.findElement(By.id("display-result"));
        Assert.assertNotNull(element);
        return Integer.parseInt(element.getText());
    }

    public Long getResultLong() {
        clickOnButton(CalculatorButtons.CALCULATE);
        WebElement element = driver.findElement(By.id("display-result"));
        Assert.assertNotNull(element);
        return Long.parseLong(element.getText());
    }

    /**
     * digit: [1, 2, 3, 4, 5, 6 ,7 ,8 ,9, 0, -, .]
     */
    private void enterDigit(char digit) {
        switch (digit) {
            case '1':
                clickOnButton(CalculatorButtons.ONE);
                break;
            case '2':
                clickOnButton(CalculatorButtons.TWO);
                break;
            case '3':
                clickOnButton(CalculatorButtons.THREE);
                break;
            case '4':
                clickOnButton(CalculatorButtons.FOUR);
                break;
            case '5':
                clickOnButton(CalculatorButtons.FIVE);
                break;
            case '6':
                clickOnButton(CalculatorButtons.SIX);
                break;
            case '7':
                clickOnButton(CalculatorButtons.SEVEN);
                break;
            case '8':
                clickOnButton(CalculatorButtons.EIGHT);
                break;
            case '9':
                clickOnButton(CalculatorButtons.NINE);
                break;
            case '0':
                clickOnButton(CalculatorButtons.ZERO);
                break;
            case '-':
                clickOnButton(CalculatorButtons.SUBTRACT);
                break;
            case '.':
                clickOnButton(CalculatorButtons.DECIMAL);
                break;
            default:
                break;
        }
    }

    /**
     * enterNumber could be positive (eg. 123)
     * negative (eg. -123)
     * decimal  (eg. 123.4 or -123.4)
     */
    public void enterNumber(Double enterNumber) {
        // 123.4 => "123.4"
        String number = Double.toString(enterNumber);

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);

            enterDigit(digit);
        }
    }

    public void add(Double firstNumber, Double secondNumber) {
        enterNumber(firstNumber);
        clickOnButton(CalculatorButtons.ADD);
        enterNumber(secondNumber);
    }

    public void add(Integer firstNumber, Integer secondNumber) {
        this.add(Double.valueOf(firstNumber), Double.valueOf(secondNumber));
    }

    public void add(Long firstNumber, Long secondNumber) {
        enterNumber((firstNumber.doubleValue()));
        clickOnButton(CalculatorButtons.ADD);
        enterNumber((secondNumber).doubleValue());
    }
//Bigdecimal
   // public void add(BigDecimal,) {

   // }

    public void substract(Double firstName, Double secondNumber) {
        enterNumber(firstName);
        clickOnButton(CalculatorButtons.SUBTRACT);
        enterNumber(secondNumber);
    }

    public void substract(Integer firstNumber, Integer secondNumber) {
        enterNumber(Double.valueOf(firstNumber));
        clickOnButton(CalculatorButtons.SUBTRACT);
        enterNumber(Double.valueOf(secondNumber));
    }

    public void multiply(Double firstNumber, Double secondNumber) {
        enterNumber(firstNumber);
        clickOnButton(CalculatorButtons.MULTIPLY);
        enterNumber(secondNumber);
    }

    public void divide(Double firstNumber, Double secondNumber) {
        enterNumber(firstNumber);
        clickOnButton(CalculatorButtons.DIVIDE);
        enterNumber(secondNumber);
    }
    }


//java enum get value
