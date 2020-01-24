package Dec152019;
/*
ask 1:
    1. Navigate to http:/www.practiceselenium.com
    2. Print out Menu buttons
    3. Click on "Our Passion"
    4. Print out all text displayed in main section
    5. Click "Menu"
    6. Print out name of the teas listed in Menu page
    7. Click "Check Out"
    8. Fill out all fields
    9. Click "Place Order"
 */

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
        driver.get("http:/www.practiceselenium.com");

        List<WebElement> welcomeMenu = driver.findElements(By.xpath("//ul[@class='wsb-navigation-rendered-top-level-menu ']/descendant::a[contains(@href,'html')]"));

        for (WebElement we : welcomeMenu) {
            System.out.println(we.getText());
        }
        System.out.println();

        welcomeMenu.get(1).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='wsb-element-text']/div/h1")).getText());
        System.out.println(driver.findElement(By.xpath("//p[starts-with(text(),'We believe')]")).getText());
        System.out.println(driver.findElement(By.xpath("//p[starts-with(text(),\"Don't\")]")).getText()+"\n");

        System.out.println(driver.findElement(By.xpath("//h2[@class='editor_h1']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[starts-with(text(),'The Passion')]")).getText()+"\n");

        driver.findElement(By.xpath("//li[@style='width: '][3]/a")).click();

        List<WebElement> menu = driver.findElements(By.xpath("//span[@style='font-size:20px;']/strong"));
        System.out.println(menu.get(1).getText());
        System.out.println(menu.get(0).getText());
        System.out.println(menu.get(2).getText());

        driver.findElement(By.xpath("//li[@style='width: '][5]/a")).click();

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email@email.com");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("This Guy");
        driver.findElement((By.xpath("//textarea[@id='address']"))).sendKeys("1234 Street Road\nTowncity,\nVA 42069");

        driver.findElement(By.xpath("//select[@id='card_type']")).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//select[@id='card_type']/option[2]")).click();

        driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4207776912346969");

        driver.findElement(By.xpath("//input[@id='cardholder_name']")).sendKeys("This Guy");

        driver.findElement(By.xpath("//input[@id='verification_code']")).sendKeys("420");

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}