package Dec232019;

import Libs.MethLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhpTravel {
    public static void main(String[] args) {
        WebDriver driver = MethLib.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/index.php");
        Actions act = new Actions(driver);

        driver.findElement(By.xpath("//button[@aria-label='dismiss cookie message']")).click();

        List<WebElement> location = driver.findElements(By.xpath("//figcaption[@class='content']/descendant::p"));
        List<WebElement> tour = driver.findElements(By.xpath("//figcaption[@class='content']/descendant::h5"));
        List<WebElement> length = driver.findElements(By.xpath("//figcaption[@class='content']/descendant::span[3]"));
        List<WebElement> price = driver.findElements(By.xpath("//figcaption[@class='content']/descendant::span[2]"));

        System.out.println("=== Featured Tours ===");
        for (int i = 0; i < tour.size(); i++)
            System.out.println(location.get(i).getText() + " | " + tour.get(i).getText() + " | " + length.get(i).getText() + " | " + price.get(i).getText() + " | ");

        String mainWin = driver.getWindowHandle();
        act.moveToElement(driver.findElement(By.xpath("//div[@class='footer-socials']"))).perform();

        List<WebElement> socials = driver.findElements(By.xpath("//div[@class='footer-socials']/a"));

        socials.get(2).click();  MethLib.windowChange(driver, mainWin);

        System.out.println("\n=== Youtube Videos ===");
        for (WebElement we : driver.findElements(By.xpath("//div[@id='meta']/descendant::a")))
            System.out.println(we.getText());

        driver.close(); driver.switchTo().window(mainWin);

        socials.get(3).click(); MethLib.windowChange(driver,mainWin);

        System.out.println("\n=== WhatsApp Title ===\n"+driver.getTitle());

        driver.close(); driver.switchTo().window(mainWin);

        socials.get(5).click(); MethLib.windowChange(driver, mainWin);

        System.out.println("\n=== Instagram Details ===");
        int j = 2;
        for (WebElement we : driver.findElements(By.xpath("//ul[@class='k9GMp ']/li/a"))) {
            System.out.println(we.getText());
            j--;
            if (j == 0) break;
        }

        driver.close(); driver.switchTo().window(mainWin);

        act.moveToElement(driver.findElement(By.xpath("//ul[@class='nav row-reverse ']"))).perform();

        driver.findElement(By.xpath("//a[@data-name='flights']")).click();

        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[2]")).click();

        driver.findElement(By.xpath("//span[text()='Economy']")).click();

        driver.findElement(By.xpath("//li[text()='First']")).click();

        act.moveToElement(driver.findElement(By.xpath("(//div[@class='form-icon-left typeahead__container'])[2]"))).click().sendKeys("wash").perform();

        driver.findElement(By.xpath("(//div[@class='select2-result-label'])[2]")).click();

        act.moveToElement(driver.findElement(By.xpath("(//div[@class='form-icon-left typeahead__container'])[3]"))).click().sendKeys("las").perform();

        driver.findElement(By.xpath("(//div[@class='select2-result-label'])[1]")).click();

        driver.findElement(By.xpath("//input[@id='FlightsDateStart']")).click();

        driver.findElement(By.xpath("(//div[@data-action='next'])[7]")).click();

        driver.findElement(By.xpath("(//div[@data-date='2'])[13]")).click();

        driver.findElement(By.xpath("(//div[@data-date='9'])[8]")).click();

        for (int i = 1; i < 20 ; i++)
            driver.findElement(By.xpath("(//button[@class='btn btn-white bootstrap-touchspin-up '])[3]")).click();

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        List<WebElement> flights = driver.findElements(By.xpath("//div[@class='theme-search-results-item-mask-link']"));

        System.out.println("\nFlights found: "+flights.size());

        List<WebElement> flyTimeRoundTrip = driver.findElements(By.xpath("//div[@class='theme-search-results-item-flight-section-path-fly-time']/p"));
        List<String> flightTimes = new ArrayList<>();
        for (int i = 0; i < flyTimeRoundTrip.size(); i+=2) {
            String s = flyTimeRoundTrip.get(i).getText();
            flightTimes.add(s.substring(14));
        }
        List<WebElement> prices = driver.findElements(By.xpath("//p[@class='theme-search-results-item-price-tag']/strong"));
        List<String> flightPrices = new ArrayList<>();
        for (WebElement we : prices) {
            String s = we.getText();
            flightPrices.add("$"+s.substring(4));
        }
        List<WebElement> companies = driver.findElements(By.xpath("//div[@class='col-md-2']/h5"));
        List<String> airlines = new ArrayList<>();
        for (int i = 0; i < companies.size(); i+=2)
            airlines.add(companies.get(i).getText());
        System.out.println("\n=== Flights under $500 and 8 hours ===");
        List<String> flightDetails = new ArrayList<>();
        for (int i = 0; i < airlines.size(); i++)
            flightDetails.add(airlines.get(i)+" | "+flightTimes.get(i)+" | "+flightPrices.get(i));
        for (String s : flightDetails) {
            int hours = Integer.parseInt(s.substring(s.indexOf('|')+2,s.indexOf('h')));
            int ticket = Integer.parseInt(s.substring(s.indexOf('$')+1));
            if (hours < 8 && ticket < 500)
                System.out.println(s);
        }
    }
}
