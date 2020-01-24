package PracticeLang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Prac2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://twitter.com/");

        driver.findElement(By.xpath("//a[@class='js-nav EdgeButton EdgeButton--medium EdgeButton--secondary StaticLoggedOutHomePage-buttonLogin']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='js-username-field email-input js-initial-focus']")).sendKeys("notreallynerdy");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@class='js-password-field']")).sendKeys("1029384756");
        driver.findElement(By.xpath("//button[@class='submit EdgeButton EdgeButton--primary EdgeButtom--medium']")).click();

        Thread.sleep(2000);
        List<WebElement> tweeters = driver.findElements(By.xpath("//*[contains(text(),'@')]"));
        for (WebElement we : tweeters) {
            System.out.println("Tweets from: "+we.getText());
        }
    }
}
