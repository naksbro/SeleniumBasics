package Dec212019;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/automationpractice.com");
        Actions action = new Actions(driver);
        action.click(driver.findElement(By.xpath("//input[@name='search_query']"))).keyDown(Keys.SHIFT).sendKeys("tla").perform();
    }
}
