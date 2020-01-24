package Dec122019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https:/codingbat.com/java");

        List<WebElement> heads = driver.findElements(By.cssSelector("div.tabin > h3"));

        System.out.println(heads.get(0).getText()+"\n");

        List<WebElement> javaHelp = driver.findElements(By.cssSelector("a[href*='/doc/java']"));
        List<WebElement> javaPrac = driver.findElements(By.cssSelector("a[href*='/doc/practice']"));

        for(WebElement e : javaHelp) {
            System.out.println(e.getText());
        }

        System.out.println("\n"+heads.get(1).getText()+"\n");

        for(WebElement e : javaPrac) {
            System.out.println(e.getText());
        }

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.close();
    }
}
