package Libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MethLib {
    public static void deadAir(int milliSeconds) {
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void windowChange(WebDriver driver, String main) {
        Set<String> windows = driver.getWindowHandles();
        for (String wins : windows) {
            if (!wins.equals(main)) {
                driver.switchTo().window(wins);
            }
        }
    }
}
