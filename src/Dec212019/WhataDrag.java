package Dec212019;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WhataDrag {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/draggable/");
        Actions acts = new Actions(driver);
        acts.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']"))).moveByOffset(243,175).perform();
    }
}
