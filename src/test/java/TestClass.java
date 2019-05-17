import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass extends BaseClass{

    @Test

    public void firstTest ()throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //Verify Main Page in the August.com

        Main_Page main_page = new Main_Page();
        main_page.navigate_To_Page_and_Check_Title(driver);
        Assert.assertTrue(main_page.is_twitter_IconPresent(driver));
        Assert.assertTrue(main_page.is_Your_Cart_IconPresent(driver));
        main_page.click_Cart_Icon(driver);
        Assert.assertTrue(main_page.verify_Your_cart_Is_empty(driver));
        main_page.click_Keepshoping_Button(driver);


        //  Add Items to the chopping cart


        Add_Items add_items = new Add_Items();

        Assert.assertTrue(add_items.is_smartLock_Visibale(driver));
        pause(1);
        add_items.click_Smart_Lock(driver);
        Assert.assertTrue(add_items.is_Add_To_Cart_Visibele(driver));
        add_items.add_To_cart(driver);
        pause(1);
        Assert.assertTrue(add_items.is_Smart_Lock_Added(driver));
        add_items.click_Procee_button(driver);


        // Create a SignIpForms for chopping cart


        SignIpForms signIpForms = new SignIpForms();

        signIpForms.waitForAugustHomeToBecomeVisible(driver,2);
        signIpForms.getNewAugustHomeWindow(driver);

        // Verify Table content information

        main_page.closeChopingCart(driver);
        pause(2);

        main_page.clickLegalInformation(driver);
        main_page.getTableContent(driver);
        main_page.done();

        driver.close();

    }

}
