package Dec222019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WarmUP {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://etsy.com");

        Actions action = new Actions(driver);

        System.out.println(driver.findElement(By.xpath("//span[@class='wt-tooltip wt-tooltip--bottom-left wt-tooltip--disabled-touch']")).getText());

        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.xpath("//span[@class='wt-tooltip wt-tooltip--bottom-left wt-tooltip--disabled-touch']"))).perform();

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//span[@class='wt-tooltip wt-tooltip--bottom-left wt-tooltip--disabled-touch']")).getText());

    }
}
