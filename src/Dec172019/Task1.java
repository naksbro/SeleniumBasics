package Dec172019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

/*
    1. Navigate to https://orbitz.com
    2. By default "Hotel" is already selected
    3. Going to - "Las Vegas, Nevada"
    4. Check-in - Selects today's date
    5. Check-out - January 12
    6. Rooms - 2
        a. Room 1:
            i. Adults - 2
            ii. Children - 2
                1) Child 1 - 2
                2) Child 2 - 4
        b. Room 2:
            i. Adults - 4
    7. Click on Search
    8. Print out names of all hotels displayed
    9. Store all these Hotels in maps by my criteria:
        a. Above 4.5 stars
            i. Output: Hotel name + stars
        b. Has discount over 20%
            i. Output: Hotel name + discount
        c. Price is $200
            i. Output: Hotel name + price
    10. Print out from 3 maps:
        a. All values of each map
        b. Hotels which has above 4.5 stars, price above $200 and has discount over 10%
 */

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com/");

        driver.findElement(By.xpath("(//span[@class='tab-label'])[2]")).click();

        driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys("Las Vegas, Nevada");

        Thread.sleep(500);

        driver.findElement(By.xpath("//a[@data-value='Las Vegas, Nevada']")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath("(//span[@class='icon icon-calendar'])[7]")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath("(//button[@class='datepicker-cal-date'])[1]")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath("(//span[@class='icon icon-calendar'])[8]")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath("//button[@data-day='12']")).click();

        Thread.sleep(500);

        Select rooms = new Select(driver.findElement(By.id("hotel-rooms-hp-hotel")));
        rooms.selectByIndex(1);

        Thread.sleep(500);

        Select room1 = new Select(driver.findElement(By.id("hotel-1-children-hp-hotel")));
        room1.selectByVisibleText("2");

        Thread.sleep(500);

        Select child1 = new Select(driver.findElement(By.id("hotel-1-age-select-1-hp-hotel")));
        child1.selectByVisibleText("2");

        Thread.sleep(500);

        Select child2 = new Select(driver.findElement(By.id("hotel-1-age-select-2-hp-hotel")));
        child2.selectByVisibleText("4");

        Thread.sleep(500);

        Select room2 = new Select(driver.findElement(By.id("hotel-2-adults-hp-hotel")));
        room2.selectByVisibleText("4");

        Thread.sleep(500);

        driver.findElement(By.xpath("(//button[@data-gcw-change-submit-text='Search'])[2]")).click();
        Thread.sleep(5000);
        List<WebElement> hotelEmls = driver.findElements(By.cssSelector("h3.visuallyhidden"));
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

        List<WebElement> rate = driver.findElements(By.xpath("//li[@class='reviewOverall'] / span[@aria-hidden='true']"));
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

        List<WebElement> discouts = driver.findElements(By.cssSelector("li.discount-ribbon.secondary.flex-flag"));
        List<String> over20 = new ArrayList<>();
        i = 1;
        for (WebElement we : discouts) {
            String s = we.getText();
            if (!s.isBlank()) {
                int discount = Integer.parseInt(s.substring(s.indexOf(' ') + 1, s.indexOf(' ') + 3));
                if (discount > 20) {
                    over20.add(i + " " + s);
                }
            }
            i++;
        }

        List<WebElement> prices = driver.findElements(By.cssSelector("span.actualPrice"));
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