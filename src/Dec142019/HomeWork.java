package Dec142019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/automationpractice.com");
        Actions action = new Actions(driver);

        driver.findElement(By.xpath("//ul[@class='toggle-footer'] / li / a")).click();

        List<WebElement> topDresses = driver.findElements(By.xpath("//li[@class='clearfix']/descendant::a[@class='product-name']"));
        List<String> topSellers = new ArrayList<>();
        List<WebElement> dressPrices = driver.findElements(By.xpath("//li[@class='clearfix']/descendant::span[@class='price']"));

        System.out.println("=====Top Sellers & Prices=====");
        for (int i = 0; i < dressPrices.size(); i++) {
            System.out.println(topDresses.get(i).getText()+" - "+dressPrices.get(i).getText());
            topSellers.add(topDresses.get(i).getText());
        }
        System.out.println();

        driver.findElement(By.xpath("//a[@title='All best sellers']")).click();

        List<WebElement> bestSellers = driver.findElements(By.xpath("//div[@id='center_column']/descendant::a[@class='product-name']"));

        System.out.println("=====Top Sellers vs Best Sellers=====");
        for (int i = 0; i < bestSellers.size(); i++) {
            System.out.println("Top Seller: "+topSellers.get(i)+" - Best Seller: "+bestSellers.get(i).getText());
        }
        System.out.println();

        List<WebElement> addCart = driver.findElements(By.xpath("//div[@class='button-container']/descendant::a[@title='Add to cart']"));
        WebElement contShop = driver.findElement(By.xpath("//span[@title='Continue shopping']"));

        for (int i = 0; i < bestSellers.size(); i++) {
            action.moveToElement(bestSellers.get(i)).build().perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addCart.get(i).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contShop.click();
        }

        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();

        List<WebElement> cartItem = driver.findElements(By.xpath("//p[@class='product-name']/a"));

        System.out.println("=====Previous vs Cart Names=====");
        for (int i = 0; i < topSellers.size(); i++) {
            System.out.println("Top Seller: "+topSellers.get(i)+" - Cart Description: "+cartItem.get(i+1).getText());
        }
        System.out.println();

        List<WebElement> cartDesc = driver.findElements(By.xpath("//td[@class='cart_description']"));

        System.out.println("=====Dress=====");
        for (WebElement we : cartDesc) {
            if(we.getText().contains("Dress"))
                System.out.println(we.getText()+"\n");
        }

        System.out.println("=====Yellow=====");
        for (WebElement we : cartDesc) {
            if(we.getText().contains("Yellow"))
                System.out.println(we.getText()+"\n");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}