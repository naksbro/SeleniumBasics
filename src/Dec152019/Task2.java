package Dec152019;

/*
Task 2:
    1. Navigate to https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard
    2. In "Login as a Different Role" section
        Choose "1st Level Supervisor" option
    3. Click on PIM option in Menu bar
Print out all details of the employee using loop and one line of code inside the loop
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");

        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("(//a[@class='login-as'])[4]")).click();

        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[2]")).click();

        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']/descendant::span[@class='left-menu-title']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> empInfo = driver.findElements(By.xpath("//tr[@ng-repeat='employee in vm.employees track by employee.empNumber']/td"));

        for (WebElement we : empInfo) {
            if (!we.getText().isBlank())
                System.out.println(we.getText());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
}
