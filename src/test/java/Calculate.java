import CalculatePageObject.CalculatorPageObject;
import Enem.CalculatorButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;
import static org.testng.Assert.assertEquals;

public class Calculate {
    WebDriver driver;
    CalculatorPageObject cpo;
    Integer result;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("--start-maximized", "--disable-extensions");
        //Instantiating driver
        driver = new ChromeDriver(options);
        //Set implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Navigate to a web page
        driver.get("file:///C:/Users/monik/Desktop/Calculate/calculator.html");
        cpo = new CalculatorPageObject(driver);
    }

    @BeforeMethod
    @AfterMethod
    public void clear(){
        cpo.clickOnButton(CalculatorButtons.CLEAR);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    // 7 + 5 = 12
    public void additionTwoIntegerNumbers(){
        cpo.add(7,5);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,12);
    }

    @Test
    //-3 + (-4) = -7
    public void additionTwoNegativeNumbers(){
        cpo.add(-3,-4);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,-7);
    }

    @Test
    // -9 + 9 = 0
    public void addNegativeIntegerWithPositiveNumber(){
        cpo.add(-9,9);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result, 0);
    }

    @Test
    // -1 + 2.0 = 1
    public void addNegativeIntegerToPositiveFloatingPointNumber(){
        cpo.add(-1, (int) 2f);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result, 1);
    }

    @Test
    //-5 + 0 = -5
    public void addNegativeIntegerAndZero(){
        cpo.add(-5,0);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result, -5);
    }

    @Test
    //0 + 8 = 8
    public void addZeroAndPositiveInteger(){
        cpo.add(0,8);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,8);
    }

    @Test
    // 30000000 + 90000000 = 120000000
    public void addTwoLargePositiveIntegers() throws InterruptedException {
        cpo.add(3000,9000);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result, 12000);
        }

    @Test
    // 10.1 + 2 = 12.1
    public void addFloatingPointNumberToAnInteger() throws InterruptedException {
        cpo.add( 10.1,2d);
        Double result = cpo.getResult();
        Assert.assertEquals(result,12.1);
    }

    @Test
    // 10 + 9.9999 = 19.9999
    public void addIntegerNumberToFloatingPointNumber(){
        cpo.add(10d,9.9999);
        Double result = cpo.getResult();
        Assert.assertEquals(result,19.9999);
    }

    @Test
    //34.999 + 1.0 = 35.999
    public void addFloatingPointNumberToPositiveFloatingPointNumber(){
        cpo.add(34.999,1.0);
        Double result = cpo.getResult();
        Assert.assertEquals(result,35.999);
    }

    @Test
    // 6 - 4 = 2
    public void subtractTwoPositiveIntegers(){
        cpo.substract(6,4);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,2);
    }

    @Test
    //-3 - 0 = -3
    public void subtractZeroFromNegativeInteger(){
        cpo.substract(-3,0);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,-3);
    }

    @Test
    //5 - 0 = 5
    public void subtractZeroFromPositiveInteger(){
        cpo.substract(5,0);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,5);
    }

    @Test
    // -1 - 2.25 = -3.25
    public void subtractFloatingPointNumberFromNegativeInteger(){
        cpo.substract(-1d,-2.25);
        Double result = cpo.getResult();
        Assert.assertEquals(result,-3.25);
    }

    @Test
    // 9.35 - 1 = 8.35
    public void subtractIntegerFromFloatingPointNumber(){
        cpo.substract(9.35,1d);
        Double result = cpo.getResult();
        Assert.assertEquals(result,8.35);
    }

    @Test
    //9 - 1.35 = 7.65
    public void subtractFloatingPointNumberFromInteger(){
        cpo.substract(9d,1.35);
        Double result = cpo.getResult();
        Assert.assertEquals(result,7.65);
    }

    @Test
    //0.29 - 1.35 = -1.06
    public void subtractTwoFloatingPointNumbers(){
        cpo.substract(0.29,1.35);
        Double result = cpo.getResult();
        Assert.assertEquals(result,-1.06);
    }

    @Test
    // 50 + - 60 = -10
    public void subtractPositiveNumberFromNegativeNumber(){
        cpo.substract(50,-60);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,-10);
    }

    @Test
    // -1.33 - 2 = -3.33
    public void subtractIntegerFromNegativeFloatingPointNumber(){
        cpo.substract(-1.33,2d);
        Double result = cpo.getResult();
        Assert.assertEquals(result,-3.33);
    }

    @Test
    // 12345 - 21098 = -8753
    public void subtractTwoLargeIntegers(){
        cpo.substract(12345,21098);
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,-8753);
    }

    @Test
    // 15 * 20 = 300
    public void multiplyTwoPositiveIntegers(){
        cpo.multiply(Double.valueOf(15),Double.valueOf(20));
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,300);
    }

    @Test
    // 1.212 * 8 = 9.696
    public void multiplyFloatingPointMultiplicandWithIntegerMultipliplier(){
        cpo.multiply(1.212,Double.valueOf(8));
        Double result = cpo.getResult();
        Assert.assertEquals(result,9.696);
    }

    @Test
    // 0.133 * 1.212 = 0.161196
    public void multiplyTwoFloatingPointNumbers(){
        cpo.multiply(0.133,1.212);
        Double result = cpo.getResult();
        Assert.assertEquals(result,0.161196);
    }

    @Test
    // 15 * 0 = 0
    public void multiplyIntegerMultiplicandWithZero(){
        cpo.multiply(Double.valueOf(15),Double.valueOf(0));
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,0);
    }

    @Test
    // -12 * 20 = -240
    public void multiplyNegativeIntegerMultiplicandWithPositiveIntegerMultiplier(){
        cpo.multiply(Double.valueOf(-12),Double.valueOf(20));
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,-240);
    }

    @Test
    //123456789 * 210987654 = 26047858281483010
    public void multiplyTwoLargeIntegers(){

    }

    @Test
    // 6 / 2 = 3
    public void divideTwoPositiveIntegers(){
        cpo.divide(Double.valueOf(6),Double.valueOf(2));
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,3);
    }

    @Test
    // 0 / 2000 = 0
    public void divideZeroByIntegerDivisor(){
        cpo.divide(Double.valueOf(0),Double.valueOf(2000));
        Integer result = cpo.getResultInt();
        Assert.assertEquals((int)result,0);
    }

    @Test
    // -1500 / 2000 = -0.75
    public void negativeDividendByPositiveDivisor(){
        cpo.divide(Double.valueOf(-1500),Double.valueOf(2000));
        Double result = cpo.getResult();
        Assert.assertEquals(result,-0.75);
    }

    @Test
    // -3.123 / 5 = -0.6246
    public void divideNegativeFloatingPointDividendByPositiveDivisor(){
        cpo.divide(Double.valueOf(-3.123),Double.valueOf(5));
        Double result = cpo.getResult();
        Assert.assertEquals(result,-0.6246);
    }

    @Test
    // -5 / 3.123 = -1.601024655779699
    public void divideNegativeIntegerByPositiveFloatingPointNumber(){
        cpo.divide(Double.valueOf(-5),(3.123));
        Double result = cpo.getResult();
        Assert.assertEquals(result,-1.601024655779699);
    }

    @Test
    // 0.342 / 0.2 = 1.71
    public void divideTwoFloatingPointNumbers(){
        cpo.divide(0.342,0.2);
        Double result = cpo.getResult();
        Assert.assertEquals(result,1.71);
    }

    @Test
    // 1500 / 0 = Infinity
    public void reportInfinityForDivisionByZero(){
        cpo.divide(Double.valueOf(1500),Double.valueOf(0));
        Double result = cpo.getResult();
        Assert.assertEquals((String.valueOf(result)),"Infinity");
    }
}



