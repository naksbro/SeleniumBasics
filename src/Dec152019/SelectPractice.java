package Dec152019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/www.practiceselenium.com");

        driver.findElement(By.xpath("(//li[@style='width: '])[5]/a")).click();

        Select sel = new Select(driver.findElement(By.id("card_type")));
        sel.selectByIndex(2);
        sel.selectByVisibleText("Diners Club");
        System.out.println(sel.getOptions());
    }
}
