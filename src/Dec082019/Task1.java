package Dec082019;

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

        driver.get("https:/amazon.com");

        driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("selenium automation book");
        driver.findElement(By.cssSelector("input.nav-input")).click();

        List<WebElement> description = driver.findElements(By.cssSelector("span.a-size-medium.a-color-base.a-text-normal"));
        List<WebElement> author = driver.findElements(By.cssSelector("div.a-row.a-size-base.a-color-secondary"));
        List<WebElement> price = driver.findElements(By.cssSelector("span.a-price"));

        System.out.println(description.size());
        System.out.println(author.size());
        System.out.println(price.size());


        for(int i = 0; i < description.size(); i++){
            System.out.println(description.get(i).getText());
            System.out.println();
        }

        for(int i = 0; i < author.size(); i ++){
            if(author.get(i).getText().startsWith("by")) {
                System.out.println(author.get(i).getText());
                System.out.println();
            }
        }

        for(int i = 0; i < price.size(); i++){
            if(price.get(i).getText().startsWith("$"))
                System.out.println(price.get(i).getText());
        }

        driver.close();
    }
}
