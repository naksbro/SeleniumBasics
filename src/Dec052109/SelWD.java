package Dec052109;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelWD {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        ChromeOptions option=new ChromeOptions();
        option.addArguments("disable-infobars");
        WebDriver drvr = new ChromeDriver();
        drvr.get("https:/google.com");
        option.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, option);

//        System.setProperty("webdriver.gecko.driver","/Users/admin/IdeaProjects/drivers/geckodriver");
//        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"logs.txt");
//        WebDriver drvr = new FirefoxDriver();

        drvr.get("https:/google.com");
        System.out.println("Title "+drvr.getTitle());
        System.out.println("URL "+drvr.getCurrentUrl());
    }
}
