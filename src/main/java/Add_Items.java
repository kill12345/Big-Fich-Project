import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class Add_Items extends BaseClass {

    private static Logger logger = Logger.getLogger("GLOBAL_LOGGER_NAME");
    Items_ButtonsUtility items_buttonsUtility =new Items_ButtonsUtility();
    private By smartLockitem =      By.xpath("//*[@id='shopify-section-homeProducts']/div/div/div[2]/div[2]/a[1]");
    private By blogPostButton =     By .xpath("//*[@id='com_box_blog']/ul/li[1]/a");
    private By add_To_Cart_Botton = By.xpath("//*[@id='shopify-section-newHeader']/div[6]/div[2]/div[9]");
    private By cartSmartLockItem  = By.xpath("//*[@class='cart']//*[contains(text(),'August Smart Lock + Connect')]");
    private By procceToCheckoutButton = By.xpath("//*[@id='shopify-section-newHeader']/div[6]/div[3]/a");

    public boolean is_smartLock_Visibale (WebDriver driver){
        logger.info("is_smartLock_Visibale");
        return items_buttonsUtility.isElementPresent(driver,smartLockitem);
    }

    public void click_Smart_Lock(WebDriver driver) {
        logger.info("click_Smart_Lock");
        WebDriverWait myWait = new WebDriverWait(driver,20);
        myWait.until(ExpectedConditions.elementToBeClickable(smartLockitem));
        driver.findElement(smartLockitem).click();

    }

    public boolean is_Add_To_Cart_Visibele (WebDriver driver){
        return items_buttonsUtility.isElementPresent(driver,add_To_Cart_Botton);
    }

    public void add_To_cart(WebDriver driver){
        logger.info("Add_To_cart");
        items_buttonsUtility.elementToBeclickable(driver,add_To_Cart_Botton);
    }
    public boolean is_Smart_Lock_Added(WebDriver driver){
        logger.info("is_Smart_Lock_Added");
        System.out.println("Smart_Lock  successful added ");
        return items_buttonsUtility.isElementPresent(driver,cartSmartLockItem);
    }

    public void click_Procee_button (WebDriver driver){
        logger.info("click_Procee_button");
        items_buttonsUtility.clickButton(driver,procceToCheckoutButton);
    }

}



