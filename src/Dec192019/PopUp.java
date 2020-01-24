package Dec192019;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.findElement(By.id("alertBox")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.id("confirmBox")).click();
        alert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.findElement(By.id("promptBox")).click();
        alert.sendKeys("I am IronMan");
        alert.accept();
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.close();
    }
}