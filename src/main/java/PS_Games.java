import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

public class PS_Games extends BaseClass {

    private static Logger logger = Logger.getLogger("GLOBAL_LOGGER_NAME");
    Items_ButtonsUtility items_buttonsUtility =new Items_ButtonsUtility();
    private By communityButton = By.xpath("//*[@id='login_link_community']");
    private By blogPostButton = By .xpath("//*[@id='com_box_blog']/ul/li[1]/a");
    private By text = By.xpath("//*[@id='post_content']/p[1]/text()[1]");

    public boolean is_Common_Game_Visibale (WebDriver driver){
        logger.info("Is_Common_Game_Visible");
        return items_buttonsUtility.isElementPresent(driver,communityButton);
    }


    public void clickCommonGame(WebDriver driver) {
        logger.info("Click Commun Game");
        items_buttonsUtility.clickButton(driver,communityButton);
    }

    public void  getAndroidTypesOfGames (WebDriver driver){
        logger.info("Get AllType Of Games");

        WebElement typeOfGames = driver.findElement(By.xpath("//*[@id='footer_block_1']/ul[3]"));
        List<WebElement> links = typeOfGames.findElements(By.tagName("li"));

        for (int i = 1;i <links.size();i++){
            System.out.println(links.get(i).getText());
        }
    }

    public void blogPostOrder (WebDriver driver){
        items_buttonsUtility.clickButton(driver,blogPostButton);
    }


}



