package Dec222019;

import Libs.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiting {
    public static void main(String[] args) {
        WebDriver driver = MethLib.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit
        driver.get("https://youtube.com");

        WebDriverWait wait = new WebDriverWait(driver, 10); // explicit

        // wait.until(ExpectedConditions.elementToBeClickable(webelement));
    }
}
