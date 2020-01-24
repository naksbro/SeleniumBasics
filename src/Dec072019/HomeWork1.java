package Dec072019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomeWork1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver drvr = new ChromeDriver();
        drvr.manage().window().maximize();

        drvr.get("https:/www.saucedemo.com");
//        System.out.println(drvr.findElement(By.className("main-body")).getText());

        System.out.println(drvr.findElement(By.id("login_credentials")).getText());

        WebElement elmnt = drvr.findElement(By.id("user-name"));
        elmnt.click();

        elmnt.sendKeys("standard_user");
        elmnt = drvr.findElement(By.id("password"));
        elmnt.click();

        elmnt.sendKeys("secret_sauce");
        elmnt = drvr.findElement(By.className("btn_action"));
        elmnt.click();

        List<WebElement> items = drvr.findElements(By.className("inventory_item_name"));
        List<WebElement> prices = drvr.findElements(By.className("inventory_item_price"));

        for(int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getText()+" : "+prices.get(i).getText());
        }
//        Map<String,String> itemsAndPrices = new LinkedHashMap<>();
//        for(int i = 0; i < items.size(); i++) {
//            itemsAndPrices.put(items.get(i).getText(), prices.get(i).getText());
//        }
//        for(Map.Entry e : itemsAndPrices.entrySet()) {
//            System.out.println(e.getKey()+" : "+e.getValue());
//        }

        items.get(0).click();
        System.out.println(drvr.findElement(By.className("inventory_details_name")).getText());
        System.out.println(drvr.findElement(By.className("inventory_details_desc")).getText());
        System.out.println(drvr.findElement(By.className("inventory_details_price")).getText());
        drvr.close();

    }
}
