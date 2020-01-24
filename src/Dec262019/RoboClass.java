package Dec262019;

import Libs.MethLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RoboClass {
    public static void main(String[] args) throws AWTException {
        WebDriver driver = MethLib.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
        Robot rob = new Robot();

        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();

        driver.findElement(By.xpath("(//a[@class='login-as'])[4]")).click();

        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[2]")).click();

        driver.findElement(By.xpath("(//span[@class='quickAccessIcon material-icons'])[2]")).click();

        driver.findElement(By.xpath("(//a[@target='_parent'])[2]")).click();

        driver.findElement(By.xpath("//div[@class='btn']")).click();

        String mainWin = driver.getWindowHandle();

        MethLib.deadAir(500);

        rob.keyPress(KeyEvent.VK_ESCAPE);

        driver.switchTo().window(mainWin);

        MethLib.deadAir(500);

        rob.keyPress(KeyEvent.VK_TAB);

        rob.keyPress(KeyEvent.VK_T); rob.keyPress(KeyEvent.VK_L); rob.keyPress(KeyEvent.VK_A);

        MethLib.deadAir(500);

        rob.keyPress(KeyEvent.VK_TAB); rob.keyPress(KeyEvent.VK_ESCAPE);
    }
}
