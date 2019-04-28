import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class SignIpForms extends BaseClass {

    private static Logger logger = Logger.getLogger("GLOBAL_LOGGER_NAME");
    Items_ButtonsUtility items_buttonsUtility = new Items_ButtonsUtility();

    private By signButton = By.xpath("//*[contains(text(), 'Sign Me Up')]");
    private By checkBox = By.xpath("//input[@type='checkbox']");
    private By emailForm = By.xpath("//*[@id='reg_email']");
    private By password  = By.xpath("//*[@id='reg_pass']");
    private By reEnterPassword = By.xpath("//*[@id='reg_pass_confirm']");
    private By username   = By.xpath("//*[@id='reg_username']");
    private By date  = By.xpath("//select[@name ='reg_dob_day']");
    private By year  = By.xpath("//select[@name ='reg_dob_year']");


    public boolean is_Sign_ME_ButtonPresen(WebDriver driver) {
        return items_buttonsUtility.isElementPresent(driver, signButton);

    }

    public void clickCheckbox(WebDriver driver) {
        driver.findElement(By.cssSelector("#dd_mac_en")).click();
        //items_buttonsUtility.clickButton(driver,checkBox);
    }

    public void click_Sign_Me_Button(WebDriver driver) {
        items_buttonsUtility.clickButton(driver, signButton);
    }

    public boolean waitForCreateAccountToBecomeVisible(WebDriver driver,long timeout) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeout, 2000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=subhead]/span[1]")));
            System.out.println("Element Become Visible");
            return true;
        } catch (TimeoutException te) {
            System.out.println("Element  Not Become Visible");
            return false;
        }

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















