import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;


public class Main_Page extends BaseClass {

    private static Logger logger = Logger.getLogger("GLOBAL_LOGGER_NAME");
    private String url = "https://www.bigfishgames.com/";
    Items_ButtonsUtility items_buttonsUtility = new Items_ButtonsUtility();
    private By signUpButton = By.xpath("//span[@class='btn_center']");
    private By mobileButton = By.xpath("//*[@class='tab tab_4']/a/span[1]");
    private By decureButton = By.xpath("//*[@id='catalog-new-releases']/div[2]/div[1]/div[1]/p/a");
    private By helpButton   = By.xpath("//*[@id='help']");
    String  helloWorld  = "I WANT WORK HERE";

    public void navigate_To_Page_and_Check_Title(WebDriver driver) {

        logger.info("CALLED: navigate_To_Page_and_Check_Title ");

        driver.get(url);

        String actualTitle = driver.getTitle();

         System.out.println(actualTitle);

        String expectedTitle = "Games for PC, Mobile, iPhone, iPad, Android, Mac & Online | Big Fish";

        if (actualTitle.equalsIgnoreCase(expectedTitle)) {

            System.out.println("Title Matched");
        }else {
            System.out.println("Title didn't match");

        }

    }

    public boolean is_Sign_Up_ButtonPresent(WebDriver driver){
        logger.info("is LearnMore Button Present");
        return items_buttonsUtility.isElementPresent(driver,signUpButton);

    }

    public void click_Sign_Up_Button(WebDriver driver)
    {logger.info("Click_Sign_Up_Button");
        items_buttonsUtility.clickButton(driver,signUpButton);
    }

    public boolean isMobileButtonVisibale(WebDriver driver) {
        logger.info("is Mobile Button Visible");
        return items_buttonsUtility.isElementPresent(driver, mobileButton);

    }
    public void clickMobiliButton(WebDriver driver){
        logger.info("Click Mobile Button");
        items_buttonsUtility.clickButton(driver,mobileButton);
    }

    public void clickDecurseGame (WebDriver driver){
        logger.info("Click Decurse Game");
        items_buttonsUtility.clickButton(driver,decureButton);
    }

    public void clickHelpButton (WebDriver driver){
        logger.info("Click Help Button");
        items_buttonsUtility.clickButton(driver,helpButton);
    }

    public void sentHiInformation(WebDriver driver){
        logger.info("Sent Hi Information");
        driver.findElement(By.cssSelector("#app > div > div:nth-child(2) > div > div > div > form > input[type=text]")).sendKeys(helloWorld);
        System.out.println("  !!!!  Done !!!!");
    }

}
