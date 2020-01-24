package Dec192019;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularPopups {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com/");

        driver.findElement(By.xpath("//a[@aria-label='Insider Access']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@class='locked-price-link uitk-link']")).click();
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.xpath("//h2[@class='mod-onboarding-title no-outline']")).getText());
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@id='modalCloseButton']/span")).click();
        Thread.sleep(500);
        driver.close();
    }
}