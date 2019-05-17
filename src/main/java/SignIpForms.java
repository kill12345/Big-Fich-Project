import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class SignIpForms extends BaseClass {

    private static Logger logger = Logger.getLogger("GLOBAL_LOGGER_NAME");
    Items_ButtonsUtility items_buttonsUtility = new Items_ButtonsUtility();

    private By signButton = By.xpath("//*[contains(text(), 'Sign Me Up')]");
    private By firstName = By.xpath("//*[@id='checkout_shipping_address_first_name']");
    private By lastName = By.xpath("//*[@id='checkout_shipping_address_last_name']");
    private By addres  =  By.xpath("//*[@id='checkout_shipping_address_address1']");
    private By appartment = By.xpath("//*[@id='checkout_shipping_address_address2']");
    private By city = By.xpath("//*[@id='checkout_shipping_address_city']");
    private By phone = By.xpath("//*[@id='checkout_shipping_address_phone']");
    private By emailForm = By.xpath("//*[@id='checkout_email']");
    private By password  = By.xpath("//*[@id='reg_pass']");
    private By reEnterPassword = By.xpath("//*[@id='reg_pass_confirm']");
    private By username   = By.xpath("//*[@id='reg_username']");
    private By date  = By.xpath("//select[@name ='reg_dob_day']");
    private By year  = By.xpath("//select[@name ='reg_dob_year']");
    String someKey = Items_ButtonsUtility.getRandomString(100, Items_ButtonsUtility.someWords.ALPHA);



    public boolean waitForAugustHomeToBecomeVisible(WebDriver driver,long timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout, 2000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.content > div > div.main > div.main__header > a > span")));
            System.out.println("Element Become Visible");
            return true;

        } catch (TimeoutException te) {
            System.out.println("Element  Not Become Visible");
            return false;
        }

    }


    public void getNewAugustHomeWindow (WebDriver driver){

        String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.

         Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                driver.findElement(emailForm).sendKeys(someKey);
                driver.findElement(firstName).sendKeys(someKey);
                driver.findElement(lastName).sendKeys(someKey);
                driver.findElement(addres).sendKeys(someKey);
                driver.findElement(appartment).sendKeys(someKey);


                Select country = new Select (driver.findElement(By.xpath("//*[@id='checkout_shipping_address_country']")));
                country.selectByVisibleText("Canada");

                Select state = new Select(driver.findElement(By.xpath("//*[@id='checkout_shipping_address_province']")));
                state.selectByIndex(2);

                driver.findElement(By.xpath("//*[@id='checkout_shipping_address_zip']")).sendKeys("95104");
                driver.findElement(city).sendKeys("344-435-34532");

                // Closing the Child Window.
                driver.close();
            }
        }

        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }



    public void sentEmail (WebDriver driver){
        logger.info("Sent Email");
        items_buttonsUtility.fildForm(driver,emailForm);

    }

    public void sentPassword (WebDriver driver){
        logger.info("Sent Password");
        items_buttonsUtility.fildForm(driver,password);
    }

    public void rePassword(WebDriver driver){
        logger.info("Re Password ");
        items_buttonsUtility.fildForm(driver,reEnterPassword);
    }

    public void setUsername(WebDriver driver){
        logger.info("Set Username ");
        items_buttonsUtility.fildForm(driver,username);
    }

    public void monthOfBirth (WebDriver driver){
        Select date = new Select(driver.findElement(By.xpath(" //select[@name='reg_dob_month']")));
        date.selectByIndex(5);
    }

    public void  dataOfBird (WebDriver driver){
        items_buttonsUtility.setSomeDataandTime(driver,date,3);

    }
    public void yearOfbird (WebDriver driver){
        Select year = new Select (driver.findElement(By.xpath("//*[@id='form_reg']/div[10]/div/select")));
        year.selectByVisibleText("2019");

    }

    public void clearEmail (WebDriver driver){
        logger.info("Clear Email");
        items_buttonsUtility.clearData(driver,emailForm);

    }

    public void clearPassword (WebDriver driver){
        logger.info("Clear  Password");
        items_buttonsUtility.clearData(driver,password);
    }

    public void clearRePassword(WebDriver driver){
        logger.info(" Clear Re Password ");
        items_buttonsUtility.clearData(driver,reEnterPassword);
    }

    public void clearUsername(WebDriver driver){
        logger.info("Clear Username ");
        items_buttonsUtility.clearData(driver,username);
    }


}















