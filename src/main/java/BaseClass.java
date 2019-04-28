public class BaseClass {


    public void getDriver(){

        System.setProperty("webdriver.gecko.driver", "./chromedriver.exe");


    }


    public static void pause(int seconds){

        try{
            Thread.sleep(seconds *1000);
        }catch (InterruptedException e){

        }

    }
}
