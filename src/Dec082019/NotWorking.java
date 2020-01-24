package Dec082019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class NotWorking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:/google.com/");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Java");
        driver.findElement(By.className("gNO89b")).click();
        Thread.sleep(2000);
        driver.findElements(By.className("S3Uucc"));
        List<WebElement> list = driver.findElements(By.className("S3Uucc"));
        System.out.println(list.size());
        for (WebElement e : list) {
            System.out.println(e.getText());
        }
        list.get(6).click();
        driver.close();
    }
}