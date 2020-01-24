package Dec082019;

//    1. Navigate to google.com
//    2. Input anything in searchBox
//    3. Click enter/search
//    4. Click first found link option
//    5. Print out web-site's link

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver drvr = new ChromeDriver();
        drvr.manage().window().maximize();

        drvr.get("https:/www.google.com");

        WebElement srch = drvr.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
        srch.sendKeys("halo master chief collection");
        drvr.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")).click();
        WebElement link = drvr.findElement(By.className("S3Uucc"));
        link.click();
        System.out.println("URL: "+drvr.getCurrentUrl());
        System.out.println("Title: "+drvr.getTitle());
        drvr.close();
    }
}
