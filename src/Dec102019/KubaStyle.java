package Dec102019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KubaStyle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/techleadacademy/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/automationpractice.com/");
        List<WebElement> productNames = driver.findElements(By.cssSelector("a.product-name"));
        List<WebElement> productPrice = driver.findElements(By.cssSelector("span[class='price product-price']"));
        System.out.println(productNames.size() + " - " + productPrice.size());
        for(WebElement name: productNames){
            if (name.isDisplayed()) {
                System.out.print("Name: " + name.getText());
                for (WebElement price : productPrice) {
                    if (price.isDisplayed()){
                        System.out.println(" | Price: " + price.getText());
                        productPrice.remove(price);
                        break;
                    }
                }
            }
        }
        productNames.get(0).click();
        WebElement quantity = driver.findElement(By.cssSelector("input#quantity_wanted"));
        quantity.clear();
        quantity.sendKeys("5");
        driver.findElement(By.cssSelector("button.exclusive")).click();
        Thread.sleep(3000);
        String expectedPrice = driver.findElement(By.cssSelector("span.ajax_block_products_total")).getText();
        String expectedShipping = driver.findElement(By.cssSelector("span[class='ajax_cart_shipping_cost']")).getText();
        String expectedTotal = driver.findElement(By.cssSelector("span[class='ajax_block_cart_total']")).getText();
        System.out.println("Price: "+expectedPrice+" | shipping: "+expectedShipping+" | Total: "+expectedTotal);
        driver.findElement(By.cssSelector("a[class='btn btn-default button button-medium']")).click();
        System.out.println("\n"+driver.findElement(By.cssSelector("td.cart_description")).getText());
        String actualPrice = driver.findElement(By.cssSelector("td#total_product")).getText();
        String actualShipping = driver.findElement(By.cssSelector("td#total_shipping")).getText();
        String actualTotal = driver.findElement(By.cssSelector("span#total_price")).getText();
        System.out.println("Actual Price: "+actualPrice+" | Actual shipping: "+actualShipping+" | Actual Total: "+actualTotal);
    }
}
