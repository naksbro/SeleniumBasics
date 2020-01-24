package Dec082019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class CSSLocator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https:/amazon.com");
        // finding via id
//        driver.findElement(By.cssSelector("input#twotabsearchbox")).sendKeys("apple");

        // finding via className
//        driver.findElement(By.cssSelector("span.nav-line-2")).click();

        // finding via attribute
//        driver.findElement(By.cssSelector("a[aria-label='Holiday Toy List']")).click();

        // finding via tag, class, attribute
//        driver.findElement(By.cssSelector("a.a-link-normal.image-redirect.aok-block.image-window[aria-label='Electronic Gifts']")).click();
//        driver.findElement(By.cssSelector("img.landscape-image[alt=Tech]")).click();

        // find based on part of string value
//        driver.findElement(By.cssSelector("img.landscape-image[alt^='Top 100']")).click();

        // ^ = starts with, $ = ends with, * = contains
        List<WebElement> weList = driver.findElements(By.cssSelector("img.landscape-image[alt*='toys']"));

        System.out.println(weList.size());

        Thread.sleep(2000);
        driver.close();
    }
}
