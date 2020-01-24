package Dec102019;

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
        driver.get("http:/automationpractice.com");

        List<WebElement> products = driver.findElements(By.cssSelector("a.product-name"));
        List<WebElement> prices = driver.findElements(By.cssSelector("div.right-block > div > span.price"));

        for(int i = 0; i < 7; i++) {
            System.out.println(products.get(i).getText()+" | "+prices.get(i).getText());
        }
        System.out.println();
        products.get(0).click();

        driver.findElement(By.cssSelector("p#quantity_wanted_p > input#quantity_wanted")).clear();
        driver.findElement(By.cssSelector("p#quantity_wanted_p > input#quantity_wanted")).sendKeys("5");

        driver.findElement(By.cssSelector("p#add_to_cart")).click();

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        List<WebElement> cartPrices = driver.findElements(By.cssSelector("div.layer_cart_cart > div > span"));
        String cartProd = cartPrices.get(0).getText();
        String cartShip = cartPrices.get(1).getText();
        String cartTotal = cartPrices.get(2).getText();
        System.out.println("Cart product price: "+ cartProd);
        System.out.println("Cart shipping price: "+cartShip);
        System.out.println("Cart total price: "+cartTotal+"\n");

        driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();

        System.out.println(driver.findElement(By.cssSelector("td.cart_description > p > a")).getText());
        System.out.println(driver.findElement(By.cssSelector("td.cart_description > small.cart_ref")).getText());
        System.out.println(driver.findElement(By.cssSelector("td.cart_description > small > a")).getText()+"\n");

        WebElement prod = driver.findElement(By.cssSelector("td#total_product"));
        WebElement ship = driver.findElement(By.cssSelector("td#total_shipping"));
        WebElement total = driver.findElement(By.cssSelector("td#total_price_without_tax"));

        System.out.println("Checkout product price: "+prod.getText()+" | Cart product price: "+cartProd);
        System.out.println("Checkout shipping price: "+ship.getText()+" | Cart shipping price: "+cartShip);
        System.out.println("Checkout total price: "+total.getText()+" | Cart total price: "+cartTotal);

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.close();
    }
}