package Dec072019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver drvr = new ChromeDriver();
        drvr.manage().window().maximize();

        drvr.get("http://automationpractice.com/");
        WebElement dress = drvr.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        dress.click();
        WebElement subCat = drvr.findElement(By.className("subcategory-name"));
        System.out.println(subCat.getAttribute("href"));

        WebElement casDrs = drvr.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img"));
        casDrs.click();
        System.out.println(drvr.findElement(By.className("cat-name")).getText());
        drvr.navigate().back();

        WebElement evnDrs = drvr.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a/img"));
        evnDrs.click();
        System.out.println(drvr.findElement(By.className("cat-name")).getText());
    }
}
