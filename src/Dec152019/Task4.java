package Dec152019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/client/#/dashboard");

        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();

        Thread.sleep(500);

        driver.findElement(By.xpath("(//a[@class='login-as'])[4]")).click();

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();

        Thread.sleep(2000);

        List<WebElement> leaveList = driver.findElements(By.xpath("//p[@class='pending-timesheet-title truncate']"));

        for (WebElement we : leaveList) {
            System.out.println(we.getText());
        }
        System.out.println(); leaveList.get(0).click(); Thread.sleep(7000);

        List<String> leaveReqs = new ArrayList<>();

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());
        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("(//span[starts-with(@ng-show,'cell.data.from')])[6]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[2]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'US')])[8]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[3]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());
        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("(//span[starts-with(@ng-show,'cell.data.from')])[7]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[4]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());
        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("(//span[starts-with(@ng-show,'cell.data.from')])[6]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[5]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());
        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("(//span[starts-with(@ng-show,'cell.data.from')])[6]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[6]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'US')])[8]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[7]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());
        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("(//span[starts-with(@ng-show,'cell.data.from')])[7]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());

        Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//p[@class='pending-timesheet-title truncate'])[8]")).click();

        Thread.sleep(7000);

        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("//span[starts-with(@ng-show,'cell.data.from')]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());
        leaveReqs.add(driver.findElement(By.xpath("//span[@class='valign']")).getText()+" | "+driver.findElement(By.xpath("(//span[starts-with(@ng-show,'cell.data.from')])[6]")).getText()+
                " | "+driver.findElement(By.xpath("(//span[contains(text(),'Vacation')])[3]")).getText());

        for (String s : leaveReqs) {
            System.out.println(s);
        }

        Thread.sleep(2000); driver.close();
    }
}