import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

import static java.util.logging.Logger.GLOBAL_LOGGER_NAME;

public class Items_ButtonsUtility {

    private static Logger logger = Logger.getLogger(GLOBAL_LOGGER_NAME);

    String someKey = getRandomString(234,someWords.ALPHA);


    public boolean isElementPresent(WebDriver driver, By by) {
        logger.info("Is Element Present");
        try {
            driver.findElement(by);
            System.out.println("My Element Present");
            return true;

        } catch (NoSuchElementException e) {
            System.out.println("My element Not Present");
            return false;
        }
    }

    public void isSomeTextPresent(WebDriver driver, By by) {
        logger.info("Is Some Text Present");

        WebElement text = driver.findElement(by);
        boolean is_Text_Displayed = text.isDisplayed();
        System.out.println("Is Some Text Present" + is_Text_Displayed);
    }

    public void clickButton(WebDriver driver, By by) {
        logger.info("Click Button");
        driver.findElement(by).click();
    }


    public boolean waitForElementToBecomeVisible(WebDriver driver, By by, long timeout) {
        logger.info("WaitForElement To Become Visible");

        WebDriverWait wait = new WebDriverWait(driver, timeout, 500);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            System.out.println("Element Become Visible ");
            return true;

        } catch (TimeoutException te) {
            System.out.println("Element Not Become Visible ");
            return false;

        }
    }

    public void fildForm(WebDriver driver, By by) {
        driver.findElement(by).sendKeys(someKey);

    }


    public enum someWords {

        ALPHA, ALPHANUMERIC, NUMERIC,
    }

    public static String getRandomString(int lenght, someWords mode) {
        logger.info("Get Random String");

        StringBuffer buffer = new StringBuffer();

        String characters = "";

        switch (mode) {

            case ALPHA:
                characters = "ppofidjspofIJOPIJ";
                break;


            case NUMERIC:
                characters = "sdfsdfsd3453453dAA";
                break;

            case ALPHANUMERIC:
                characters = "123456790";
                break;

        }

        int charactersLength = characters.length();

        for (int i = 0;i < lenght;i++){
            double index = Math.random()*charactersLength;
            buffer.append(characters.charAt((int)index));

        }
        return buffer.toString();
    }

    public void setSomeDataandTime(WebDriver driver,By by,int index){
        Select data = new Select(driver.findElement(by));
        data.selectByIndex(index);
    }

    public void clearData(WebDriver driver,By by){
        driver.findElement(by).clear();
        System.out.println("Everything Clear ");
    }

}









