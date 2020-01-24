package Dec122019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/automationpractice.com");

        System.out.println(driver.findElement(By.xpath("//section[@id='block_contact_infos']")).getText());

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.close();
    }
}
