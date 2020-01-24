package PracticeLang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OffHours1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///Users/admin/Desktop/s_html/example6.html");

        WebElement firstN = driver.findElement(By.cssSelector("div[id=‘first-name’] > div > input"));
        Thread.sleep(200);
        firstN.sendKeys("Mark");

    }
}
