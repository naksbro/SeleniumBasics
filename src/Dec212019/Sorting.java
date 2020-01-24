package Dec212019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/sortable/");

        Actions act = new Actions(driver);

        List<WebElement> sorts = driver.findElements(By.xpath("//li[@class='ui-state-default ui-sortable-handle']"));

        for (int i = sorts.size()-1; i > 0; i--) {
            act.dragAndDrop(sorts.get(i),sorts.get(0)).perform();
        }
    }
}