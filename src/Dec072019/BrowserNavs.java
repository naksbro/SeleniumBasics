package Dec072019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavs {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver drvr = new ChromeDriver();
        drvr.manage().window().maximize();

        drvr.get("https://techleadacademy.io");
        drvr.get("https://google.com");
        drvr.navigate().back();
        drvr.navigate().refresh();

        Thread.sleep(5000);
        drvr.close();

    }
}
