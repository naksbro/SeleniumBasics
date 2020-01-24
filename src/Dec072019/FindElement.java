package Dec072019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver drvr = new ChromeDriver();
        drvr.manage().window().maximize();

        drvr.get("http://automationpractice.com/");
        String elmText = drvr.findElement(By.id("contact-link")).getText();
        System.out.println(elmText);
        Thread.sleep(3000);
        WebElement element = drvr.findElement(By.className("sf-with-ul"));

        System.out.println(element.getText());
        System.out.println(element.isDisplayed());
        System.out.println(element.getSize());
        element.click();
        Thread.sleep(10000);
        drvr.close();

    }
}
