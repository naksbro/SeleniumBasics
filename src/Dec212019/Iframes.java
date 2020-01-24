package Dec212019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;

import java.util.Iterator;
import java.util.List;

public class Iframes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click(); Thread.sleep(500);

        driver.findElement(By.xpath("(//a[@class='login-as'])[4]")).click();

        driver.findElement(By.xpath("//span[text()='Assets']")).click(); Thread.sleep(500);

        driver.findElement(By.xpath("//span[text()='View Assets']")).click(); Thread.sleep(3000);

        driver.switchTo().frame("noncoreIframe"); Thread.sleep(500);

        List<WebElement> tr = driver.findElements(By.xpath("//tr[@class='dataRaw']/td[3]"));

        int i = 1;
        for (WebElement we : tr) System.out.println(i++ +". "+we.getText());

//        tr.forEach(cats -> System.out.println(cats.getText()));

//        Iterator<WebElement> cats = tableRow.iterator();
//        while(cats.hasNext()) System.out.println(cats.next().getText());

        Thread.sleep(5000); driver.quit();
    }
}
