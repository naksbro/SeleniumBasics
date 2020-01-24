package Dec222019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YoutTubeTask {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        Actions action = new Actions(driver);

        System.out.println(driver.findElement(By.xpath("//button[@aria-label='Create a video or post']")).getText());

        action.moveToElement(driver.findElement(By.xpath("//button[@aria-label='Create a video or post']"))).perform();

        System.out.println(driver.findElement(By.xpath("(//div[@id='tooltip'])[2]")).getText());
    }
}
