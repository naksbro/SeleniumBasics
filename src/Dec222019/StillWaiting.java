package Dec222019;

import Libs.MethLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StillWaiting {
    public static void main(String[] args) {
        WebDriver driver = MethLib.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.weather.com");
        Actions act = new Actions(driver);

        System.out.println("Popup: "+driver.findElement(By.xpath("//p[@classname='styles__mainParagraph__RcoJR']")).getText()+"\n");

        act.click(driver.findElement(By.xpath("//span[@classname='icon icon-font iconset-ui icon-close']"))).perform();

        String main = driver.getWindowHandle();

        driver.findElement(By.xpath("(//ul[@class='footer-social-icons']/li/a)[1]")).click();
        driver.findElement(By.xpath("(//ul[@class='footer-social-icons']/li/a)[2]")).click();
        driver.findElement(By.xpath("(//ul[@class='footer-social-icons']/li/a)[3]")).click();

        Set<String> windows = driver.getWindowHandles();
        for (String wins : windows) {
            if (!wins.equals(main)) {
                driver.switchTo().window(wins);
                System.out.println("Title: "+driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(main);

        driver.findElement(By.xpath("//a[@data-from-string='localsuiteNav_4_10 Day']")).click();

        List<WebElement> dates = driver.findElements(By.xpath("//tbody/tr[@class='clickable closed']/td[2]/div/span"));

        List<WebElement> description = driver.findElements(By.xpath("//tbody/tr[@class='clickable closed']/td[3]/span"));

        List<WebElement> temp = driver.findElements(By.xpath("//tbody/tr[@class='clickable closed']/td[@class='temp']"));

        System.out.println("\nDate | Description | High/Low");
        for (int i = 0; i < dates.size(); i++){
            System.out.println(dates.get(i).getText()+" | "+description.get(i).getText()+" | "+temp.get(i).getText());
        }
    }
}
