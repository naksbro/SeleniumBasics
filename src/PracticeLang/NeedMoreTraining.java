package PracticeLang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class NeedMoreTraining {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://store.steampowered.com/");

        driver.findElement(By.xpath("//a[@class='global_action_link']")).click();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("NefariousP1G");

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1029384756");

        Thread.sleep(500);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id='wishlist_link']")).click();

        Thread.sleep(3000);

        List<WebElement> wishList = driver.findElements(By.xpath("//a[@class='title']"));

        for (WebElement we : wishList){
            System.out.println(we.getText());
        }

        Thread.sleep(5000); driver.close();
    }
}
