package Dec192019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com/");

        driver.findElement(By.xpath("//a[@id='primary-header-travel_blog']")).click();
        System.out.println(driver.getCurrentUrl());
        String main = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        Set<String> wins = driver.getWindowHandles();
        for (String win : wins){
           if (!win.equals(main)){
               driver.switchTo().window(win);
           }
        }
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(main);
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000); driver.close();
    }
}
