package PracticeLang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https:/www.microcenter.com/");
        driver.findElement(By.className("close")).click();
        driver.findElement(By.cssSelector("input#search-query")).sendKeys("wireless mechanical keyboard");
        driver.findElement(By.cssSelector("input[aria-label='Begin Product Search']")).click();
        driver.findElement(By.cssSelector("img#imgProduct_7")).click();
        driver.findElement(By.cssSelector("input.btn-add.grey.big.STBTN")).click();
        driver.findElement(By.id("ContentPlaceHolder1_ucOrderSummary_lbCheckout")).click();
        driver.findElement(By.id("ctl00_ContentLeftSide_ucLogin_txtEmailAddress")).sendKeys("email@email.com");
        driver.findElement(By.id("ctl00_ContentLeftSide_ucLogin_txtPassword")).sendKeys("password");

        Thread.sleep(3000);
        driver.close();
    }
}
