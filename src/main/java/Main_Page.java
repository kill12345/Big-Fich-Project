import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;


public class Main_Page extends BaseClass {

    private static Logger logger = Logger.getLogger("GLOBAL_LOGGER_NAME");
    private String url = "https://august.com/";
    Items_ButtonsUtility items_buttonsUtility = new Items_ButtonsUtility();
    private By twitterIcon         = By.xpath("//*[@id='shopify-section-newFooter']/div[1]/div[1]/div[1]/div/a[1]/img");
    private By facebokIcon         = By.xpath("//*[@id='shopify-section-newFooter']/div[1]/div[1]/div[1]/div/a[2]/img");
    private By cartIcon            = By.xpath("//*[@id='deskCart']");
    private By keepshopingButton   = By.xpath("//*[@class='keepShopping']");
    private By legalInformation    = By.xpath("//*[@id='shopify-section-newFooter']/div[1]/div[1]/div[2]/div/a[2]");


    public void navigate_To_Page_and_Check_Title(WebDriver driver) {

        logger.info("CALLED: navigate_To_Page_and_Check_Title ");

        driver.get(url);

        String actualTitle = driver.getTitle();

         System.out.println(actualTitle);

        String expectedTitle = "August Home | Your Smart Home Starts at the Front Door";

        if (actualTitle.equalsIgnoreCase(expectedTitle)) {

            System.out.println("Title Matched");
        }else {
            System.out.println("Title didn't match");

        }

    }

    public boolean is_twitter_IconPresent(WebDriver driver){
        logger.info("is_twitter_IconPresent");
        return items_buttonsUtility.isElementPresent(driver,twitterIcon);

    }

    public boolean is_Your_Cart_IconPresent(WebDriver driver){
        logger.info("is_Your_Cart_IconPresent");
        return items_buttonsUtility.isElementPresent(driver,cartIcon);
    }

    public void click_Cart_Icon(WebDriver driver)
    {logger.info("click_Cart_Icon");
        items_buttonsUtility.clickButton(driver,cartIcon);
    }

    public boolean verify_Your_cart_Is_empty (WebDriver driver) {
        logger.info("Verify_Your_cart_Is_empty");
        System.out.println("Your cart is empty ");
        return items_buttonsUtility.isElementPresent(driver, keepshopingButton);
    }

    public void click_Keepshoping_Button(WebDriver driver){
        items_buttonsUtility.clickButton(driver,keepshopingButton);


    }
    public void closeChopingCart(WebDriver driver){
        logger.info("Close chopping cart ");
        items_buttonsUtility.clickButton(driver,By.xpath("//*[@id='shopify-section-newHeader']/div[6]/div[3]/div[1]/div[3]/img"));

    }


    public void clickLegalInformation(WebDriver driver){
        logger.info("Sent Hi Information");
        driver.findElement(legalInformation).click();

    }


    public void  getTableContent (WebDriver driver){
        logger.info("Get Table Content");

        WebElement tableContent = driver.findElement(By.xpath("//*[@id='shopify-section-legal']/div/div[3]/ol[1]"));
        List<WebElement> links = tableContent.findElements(By.tagName("li"));

        for (int i = 1;i <links.size();i++){
            System.out.println(links.get(i).getText());

        }

    }

    public void done(){
        System.out.println(" THE TEST SUITE PASSED, EVERYTHING OK");
    }

}
