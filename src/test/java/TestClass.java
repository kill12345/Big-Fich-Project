import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass extends BaseClass{

    @Test

    public void firstTest ()throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //Verify Main Page in the big_Fish_Games

        Main_Page main_page = new Main_Page();
        main_page.navigate_To_Page_and_Check_Title(driver);
        Assert.assertTrue(main_page.is_Sign_Up_ButtonPresent(driver));
        main_page.click_Sign_Up_Button(driver);


        SignIpForms signIpForms = new SignIpForms();

        Assert.assertTrue(signIpForms.is_Sign_ME_ButtonPresen(driver));
        signIpForms.clickCheckbox(driver);
        signIpForms.click_Sign_Me_Button(driver);
        signIpForms.waitForCreateAccountToBecomeVisible(driver,1);


        // Create an account or sign in to continue.

        signIpForms.sentEmail(driver);
        signIpForms.sentPassword(driver);
        signIpForms.rePassword(driver);
        signIpForms.setUsername(driver);


        // set Date of Birth

        signIpForms.monthOfBirth(driver);
        signIpForms.dataOfBird(driver);
        signIpForms.yearOfbird(driver);

        pause(2);

        // Clear all data
        signIpForms.clearEmail(driver);
        signIpForms.clearPassword(driver);
        signIpForms.clearRePassword(driver);
        signIpForms.clearUsername(driver);
        pause(2);


        // Move to the Community page

        PS_Games ps_games = new PS_Games();

        Assert.assertTrue(ps_games.is_Common_Game_Visibale(driver));
        ps_games.clickCommonGame(driver);
        ps_games.getAndroidTypesOfGames(driver);
        ps_games.blogPostOrder(driver);

        pause(2);

        // Go to the main page
        main_page.navigate_To_Page_and_Check_Title(driver);
        Assert.assertTrue(main_page.isMobileButtonVisibale(driver));
        main_page.clickMobiliButton(driver);
        main_page.clickDecurseGame(driver);
        main_page.clickHelpButton(driver);
        main_page.sentHiInformation(driver);
        pause(3);

        driver.close();

    }

}
