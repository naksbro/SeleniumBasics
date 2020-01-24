package Dec172019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Orbitz {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com/");

        driver.findElement(By.xpath("(//span[@class='tab-label'])[2]")).click();
        // Enter destination
        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys("Las Vegas, Nevada");

        Thread.sleep(500);
        // Select destination from list
        driver.findElement(By.xpath("//a[@data-value='Las Vegas, Nevada']")).click();

        Thread.sleep(500);
        // Click check in calendar
        driver.findElement(By.xpath("(//span[@class='icon icon-calendar'])[7]")).click();

        Thread.sleep(500);
        // Select current date
        driver.findElement(By.xpath("(//button[@class='datepicker-cal-date'])[1]")).click();

        Thread.sleep(500);
        // Click check out calendar
        driver.findElement(By.xpath("(//span[@class='icon icon-calendar'])[8]")).click();

        Thread.sleep(500);
        // Select check out date
        driver.findElement(By.xpath("//button[@data-day='12']")).click();

        Thread.sleep(500);
        // Number of rooms
        Select rooms = new Select(driver.findElement(By.id("hotel-rooms-hp-hotel")));
        rooms.selectByIndex(1);

        Thread.sleep(500);
        // Children in first room
        Select room1 = new Select(driver.findElement(By.id("hotel-1-children-hp-hotel")));
        room1.selectByVisibleText("2");

        Thread.sleep(500);
        // Age of first child
        Select child1 = new Select(driver.findElement(By.id("hotel-1-age-select-1-hp-hotel")));
        child1.selectByVisibleText("2");

        Thread.sleep(500);
        // Age of second child
        Select child2 = new Select(driver.findElement(By.id("hotel-1-age-select-2-hp-hotel")));
        child2.selectByVisibleText("4");

        Thread.sleep(500);
        // Adults in room 2
        Select room2 = new Select(driver.findElement(By.id("hotel-2-adults-hp-hotel")));
        room2.selectByVisibleText("4");

        Thread.sleep(500);
        // Click "Search" button
        driver.findElement(By.xpath("(//button[@data-gcw-change-submit-text='Search'])[2]")).click();
        Thread.sleep(5000);
        // Get list of hotel names
        List<WebElement> hotelEmls = driver.findElements(By.xpath("//h3[@aria-hidden='false']"));
        // Convert list to strings
        List<String> hotels = new ArrayList<>();
        int i = 1;
        for (WebElement we : hotelEmls) {
            hotels.add(i++ + " " + we.getText());
        }
        System.out.println("=== HOTELS ===");
        for (String s : hotels) {
            System.out.println(s);
        }

        Thread.sleep(1000);
        // Get star rating
        List<WebElement> rate = driver.findElements(By.xpath("//li[@class='reviewOverall'] / span[@aria-hidden='true']"));
        // Convert to string
        List<String> four5Plus = new ArrayList<>();
        i = 1;
        for (WebElement we : rate) {
            String s = we.getText();
            double rates = Double.parseDouble(s.substring(0, s.indexOf('/')));
            if (rates >= 4.5) {
                four5Plus.add(i + " " + s);
            }
            i++;
        }
        // Get discount %
        List<WebElement> discouts = driver.findElements(By.xpath("//span[@class='uitk-badge uitk-badge-large uitk-badge-deal-generic uitk-badge-has-text']/span[@class='uitk-badge-text']"));
        // Convert to string
        List<String> over20 = new ArrayList<>();
        i = 1;
        for (WebElement we : discouts) {
            String s = we.getText();
            if (!s.isBlank()) {
                int discount = Integer.parseInt(s.substring(s.indexOf(' ')+1,s.indexOf(' ')).trim());
                if (discount > 20) {
                    over20.add(i + " " + s);
                }
            }
            i++;
        }
        // Get room prices
        List<WebElement> prices = driver.findElements(By.xpath("//span[@data-stid='content-hotel-lead-price']"));
        // Convert to string
        List<String> under200 = new ArrayList<>();
        i = 1;
        for (WebElement we : prices) {
            String s = we.getText();
            if (!s.isBlank()) {
                int price = Integer.parseInt(s.substring(s.indexOf('$') + 1));
                if (price < 200) {
                    under200.add(i + " " + s);
                }
            }
            i++;
        }
        // Add hotel and rating to map
        Map<String,String> hotelStars = new LinkedHashMap<>();

        for (String s : hotels) {
            for (String s1 : four5Plus) {
                if (s.substring(0,s.indexOf(" ")).equals(s1.substring(0,s1.indexOf(" ")))) {
                    hotelStars.put(s.substring(s.indexOf(' ')+1),s1.substring(s1.indexOf(' ')+1));
                }
            }
        }
        System.out.println("\n=== HOTEL RATINGS ===");
        for (Map.Entry each : hotelStars.entrySet()) {
            System.out.println(each);
        }
        // Add hotel and discount %
        Map<String,String> hotelDiscount = new LinkedHashMap<>();

        for (String s : hotels) {
            for (String s1 : over20) {
                if (s.substring(0,s.indexOf(" ")).equals(s1.substring(0,s1.indexOf(" ")))) {
                    hotelDiscount.put(s.substring(s.indexOf(' ')+1),s1.substring(s1.indexOf(' ')+1));
                }
            }
        }

        System.out.println("\n=== HOTEL DISCOUNT ===");
        for (Map.Entry each : hotelDiscount.entrySet()) {
            System.out.println(each);
        }
        // Add hotel and price
        Map<String,String> hotelPrice = new LinkedHashMap<>();

        for (String s : hotels) {
            for (String s1 : under200) {
                if (s.substring(0,s.indexOf(" ")).equals(s1.substring(0,s1.indexOf(" ")))) {
                    hotelPrice.put(s.substring(s.indexOf(' ')+1),s1.substring(s1.indexOf(' ')+1));
                }
            }
        }

        System.out.println("\n=== HOTEL PRICE ===");
        for (Map.Entry each : hotelPrice.entrySet()) {
            System.out.println(each);
        }
    }
}