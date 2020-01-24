package Dec072019;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class warmUp {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option=new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver","/Users/admin/IdeaProjects/drivers/chromedriver");
        WebDriver chrm = new ChromeDriver();
        String url = chrm.getCurrentUrl();

        chrm.get("https://techleadacademy.io");
        url = chrm.getCurrentUrl();
        System.out.println("Title: "+chrm.getTitle());
        System.out.println("URL: "+url);
        System.out.println("URL length: "+url.length());
        System.out.println(chrm.getPageSource());
        Thread.sleep(2000);

        chrm.get("https://mashable.com");
        url = chrm.getCurrentUrl();
        System.out.println("Title: "+chrm.getTitle());
        System.out.println("URL: "+url);
        System.out.println("URL length: "+url.length());
        System.out.println(chrm.getPageSource());
        Thread.sleep(2000);

        chrm.get("https://www.theinformation.com");
        url = chrm.getCurrentUrl();
        System.out.println("Title: "+chrm.getTitle());
        System.out.println("URL: "+url);
        System.out.println("URL length: "+url.length());
        System.out.println(chrm.getPageSource());

        chrm.close();
    }
}
