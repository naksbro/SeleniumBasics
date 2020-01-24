package Dec152019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");

        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("(//a[@class='login-as'])[4]")).click();

        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[36]")).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> vacsData = driver.findElements(By.xpath("//td[starts-with(@class, 'dataColumn')]"));

        System.out.println(vacsData.size());

        for (WebElement we : vacsData) {
            if (!we.getText().isBlank())
                System.out.println(we.getText());
        }

        driver.findElement(By.xpath("//tbody/tr")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
}
