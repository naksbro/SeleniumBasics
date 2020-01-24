package Dec072019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        /*
        1. Open the browser -> automationpractice.com
        2. Click "Dresses" button
        3. Print out "href" attributes of items inside "Subcategories" section
        4. Then Click on "Tops"
        5. Verify "header" of that section's name is "TOPS"
        6. Navigate back
        7. Click on "Dresses"
        8. Verify "header" of that section's name is "TOPS"
         */
        System.setProperty("webdriver.chrome.driver","/Users/techleadacademy/" +
                "IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/automationpractice.com/");
        //driver.findElement(By.className("sf-with-ul")).click();
        List<WebElement> list = driver.findElements(By.className("sf-with-ul"));
        System.out.println(list.size());
        list.get(3).click();
        List<WebElement> list2 = driver.findElements(By.className("subcategory-name"));
        System.out.println(list2.size());
        for(WebElement element: list2){
            System.out.println(element.getText());
        }
        //driver.findElement(By.className("subcategory-image")).click();
    }
}
